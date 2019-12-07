package controller;

import Observer.Observable;
import entity.Entity;
import entity.Homework;
import entity.Student;
import exception.ValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.HomeworkService;


public class HomeworkController implements Observable {
  @FXML public TextField fnamefield, groupfield, lnamefield;
  @FXML public TableView<Homework<String>> table;
  private HomeworkService<String> service;
  private String currentId;

  public HomeworkController() {
  }

  @SuppressWarnings("unchecked")
  private void initRepo() {
    service = HomeworkService.getFileInstance("homeworks");
    service.addObservable(this);
    loadTable();
  }

  @SuppressWarnings("unchecked")
  private void loadData() {
    table.getItems().clear();
    for (Homework x : service.getAll())
      table.getItems().add(x);
  }

  @SuppressWarnings("unchecked")
  private void loadTable() {
    TableColumn idColumn = new TableColumn("Id");
    TableColumn firstNameColumn = new TableColumn("Start week");
    TableColumn lastNameColumn = new TableColumn("End week");
    TableColumn groupColumn = new TableColumn("Description");

    idColumn.setCellValueFactory(new PropertyValueFactory<Homework<String>, String>("Id"));
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<Homework<String>, Integer>("startWeek"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<Homework<String>, Integer>("endWeek"));
    groupColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("description"));
    table.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, groupColumn);
    table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldE, newE) -> {
      if(newE == null)
        newE = oldE;
      fnamefield.setText(String.valueOf(newE.getStartWeek()));
      lnamefield.setText(String.valueOf(newE.getEndWeek()));
      groupfield.setText(newE.getDescription());
      currentId = newE.getId();
    });
    loadData();
  }

  @FXML
  public void initialize() {
    initRepo();
  }

  private void showError(Exception err) {
    Alert alert = new Alert(Alert.AlertType.ERROR, err.getMessage());
    alert.showAndWait();
  }

  private void showMessage(String msg) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, msg);
    alert.showAndWait();
  }

  @SuppressWarnings("unchecked")
  private void updateAddTableView(TableView tb, Entity en) {
    tb.getItems().add(en);
    notifyObserver();
  }

  private void updateDeleteTableView(TableView tb, Entity en) {
    tb.getItems().remove(en);
    notifyObserver();
  }

  @SuppressWarnings("unchecked")
  private void updateUpdateTableView(TableView<Homework<String>> tb, Entity en) {
    int index=0;
    for (Homework x: tb.getItems()) {
      if (x.getId().equals(en.getId())) {
        tb.getItems().set(index,(Homework<String>) en);
        break;
      } else
        index++;
    }
    notifyObserver();
  }

  @FXML
  void create(ActionEvent ac) {
    String endWeek = lnamefield.getText();
    String description = groupfield.getText();
    try {
      Homework<String> aux = new Homework<>(Integer.parseInt(endWeek), description);
      Homework st = service.add(aux);
      if (st != null) {
        showError(new Exception("Homework already exists!"));
        return;
      }
      updateAddTableView(table, aux);
      showMessage("Homework has been added!");
    } catch (ValidationException err) {
      showError(err);
    }
  }

  @FXML
  void clear(ActionEvent ac) {
    clear();
  }

  private void clear() {
    lnamefield.clear();
    fnamefield.clear();
    groupfield.clear();
    currentId = null;
  }

  @FXML
  void delete(ActionEvent ac) {
    if(currentId == null) {
      showMessage("You haven't selected any homework!");
      return;
    }
    Homework aux = service.delete(currentId);
    if(aux == null) {
      showMessage("No homework was found with this id");
      return;
    }
    showMessage("Homework was deleted!");
    clear();
    updateDeleteTableView(table, aux);
  }

  @FXML
  void update(ActionEvent ac) {
    if(currentId == null) {
      showMessage("You haven't selected any homework!");
      return;
    }
    String startWeek = fnamefield.getText();
    String endWeek = lnamefield.getText();
    String description = groupfield.getText();
    Homework<String> aux = new Homework<>(currentId,Integer.parseInt(startWeek) ,Integer.parseInt(endWeek), description);
    try {
      Homework st = service.update(aux);
      if (st == null) {
        showMessage("Homework has been updated!");
        updateUpdateTableView(table, aux);
      }
      else
        showMessage("Homework doesn't exist!");
    } catch (ValidationException e) {
      showError(e);
    }
    clear();
  }

  @Override
  public void getNotified() {
    loadData();
  }

  @Override
  public void notifyObserver() {
    service.notifyObservables();
  }
}
