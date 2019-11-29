package com.company.controller;

import com.company.Observer.Observable;
import com.company.entity.Entity;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController implements Observable {
  @FXML public TextField fnamefield, groupfield, lnamefield, emailfield;

  @FXML private TableView<Student<String>> table;
  private StudentService<String> service;
  private String currentId;

  public StudentController() {
  }

  @SuppressWarnings("unchecked")
  private void initStudentRepo() {
    service = StudentService.getFileInstance("students");
    service.addObservable(this);
    loadStudentTable();
  }

  @SuppressWarnings("unchecked")
  private void loadData() {
    table.getItems().clear();
    for (Student x : service.getAll())
      table.getItems().add(x);
  }

  @SuppressWarnings("unchecked")
  private void loadStudentTable() {
    TableColumn idColumn = new TableColumn("Id");
    TableColumn firstNameColumn = new TableColumn("First Name");
    TableColumn lastNameColumn = new TableColumn("Last Name");
    TableColumn groupColumn = new TableColumn("Group");
    TableColumn emailColumn = new TableColumn("Email");

    idColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("Id"));
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("firstName"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("lastName"));
    groupColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("group"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("email"));
    table.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, groupColumn, emailColumn);
    table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldStudent, newStudent) -> {
      if(newStudent == null)
        newStudent = oldStudent;
      fnamefield.setText(newStudent.getFirstName());
      lnamefield.setText(newStudent.getLastName());
      groupfield.setText(newStudent.getGroup());
      emailfield.setText(newStudent.getEmail());
      currentId = newStudent.getId();
    });
    loadData();
  }

  @FXML
  public void initialize() {
    initStudentRepo();
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
  private void updateUpdateTableView(TableView<Student<String>> tb, Entity en) {
    int index=0;
    for (Student x: tb.getItems()) {
      if (x.getId().equals(en.getId())) {
        tb.getItems().set(index,(Student) en);
        break;
      } else
        index++;
    }
    notifyObserver();
  }

  @FXML
  void createStudent(ActionEvent ac) {
    String firstName = fnamefield.getText();
    String lastName = lnamefield.getText();
    String group = groupfield.getText();
    String email = emailfield.getText();
    try {
      Student<String> aux = new Student<>(firstName, lastName, group, email);
      Student st = service.add(aux);
      if (st != null) {
        showError(new Exception("Student already exists!"));
        return;
      }
      updateAddTableView(table, aux);
      showMessage("Student has been added!");
    } catch (ValidationException err) {
      showError(err);
    }
  }

  @FXML
  void clearStudent(ActionEvent ac) {
    clearStudent();
  }

  private void clearStudent() {
    lnamefield.clear();
    fnamefield.clear();
    groupfield.clear();
    emailfield.clear();
    currentId = null;
  }

  @FXML
  void deleteStudent(ActionEvent ac) {
    if(currentId == null) {
      showMessage("You haven't selected any student!");
      return;
    }
    Student aux = service.delete(currentId);
    if(aux == null) {
      showMessage("No student was found with this id");
      return;
    }
    showMessage("Student was deleted!");
    clearStudent();
    updateDeleteTableView(table, aux);
  }

  @FXML
  void updateStudent(ActionEvent ac) {
    if(currentId == null) {
      showMessage("You haven't selected any student!");
      return;
    }
    String firstName = fnamefield.getText();
    String lastName = lnamefield.getText();
    String group = groupfield.getText();
    String email = emailfield.getText();
    Student<String> aux = new Student<>(currentId,firstName,lastName,group,email);
    try {
      Student st = service.update(aux);
      if (st == null) {
        showMessage("Student has been updated!");
        updateUpdateTableView(table, aux);
      }
      else
        showMessage("Student doesn't exist!");
    } catch (ValidationException e) {
      showError(e);
    }
    clearStudent();
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
