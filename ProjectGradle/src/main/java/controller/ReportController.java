package controller;

import Observer.Observable;
import com.sun.tools.javac.util.Pair;
import entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GradeService;
import service.ReportService;

import java.util.Vector;

public class ReportController implements Observable {

  private GradeService grades = GradeService.getFileInstance("grades");
  private ReportService<String> service;

  @FXML public TableView<Report<String>> table;
  @FXML public Button examButton, allButton, timeButton, homeworkButton;

  private void initRepo() {
    service = new ReportService<>(grades);
    service.calculateAll();
    service.addObservable(this);
    grades.addObservable(this);
    loadTable();
  }

  @FXML
  public void loadAll(){
    loadData();
  }

  @SuppressWarnings("unchecked")
  private void loadData() {
    service.makeEmpty();
    service.calculateAll();
    table.getItems().clear();
    for (Report x: service.getAll())
      table.getItems().add(x);
  }

  @FXML
  public void loadOnTimeStudents() {
    service.makeEmpty();
    service.calculateAll();
    table.getItems().clear();
    for (Report x: service.getOnTimeStudents())
      table.getItems().add(x);
  }

  @FXML
  public void loadExam(ActionEvent ac) {
    loadExamStudents();
  }
  private void loadExamStudents() {
    service.makeEmpty();
    service.calculateAll();
    table.getItems().clear();
    for (Report x: service.getExamStudents())
      table.getItems().add(x);
  }

  @SuppressWarnings("unchecked")
  private void loadColumns() {
    TableColumn idColumn = new TableColumn("Id");
    TableColumn professorColumn = new TableColumn("Average");
    TableColumn gradeColumn = new TableColumn("Student");
    idColumn.setCellValueFactory(new PropertyValueFactory<Homework<String>, String>("Id"));
    professorColumn.setCellValueFactory(new PropertyValueFactory<Homework<Integer>, String>("average"));
    gradeColumn.setCellValueFactory(new PropertyValueFactory<Homework<String>, String>("name"));
    table.getColumns().addAll(idColumn, professorColumn, gradeColumn);
  }

  @FXML
  public void findHardestHomework() {
    Pair<Homework, Integer> aux = service.hardestHomework();
    if(aux.fst == null) {
      showMessage("No grades were found!");
      return;
    }
    showMessage(String.format("Hardest homework was %s with an average of %d", aux.fst.getDescription(), aux.snd));
  }

  private void loadTable() {
    loadColumns();
    table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldE, newE) -> {
      if(newE == null)
        newE = oldE;
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
  private void updateUpdateTableView(TableView<Grade<String>> tb, Entity en) {
    int index=0;
    for (Entity x: tb.getItems()) {
      if (x.getId().equals(en.getId())) {
        tb.getItems().set(index,(Grade<String>) en);
        break;
      } else
        index++;
    }
    notifyObserver();
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
