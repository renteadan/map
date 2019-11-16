package com.company;

import com.company.entity.Entity;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController {
  @FXML public TextField fnamefield, groupfield, lnamefield, emailfield;
  @FXML public TableView<Student<String>> studentTable;
  private StudentService<String> studentService;
  private String currentId;

  public StudentController() {
  }

  @SuppressWarnings("unchecked")
  private void initStudentRepo() {
    studentService = StudentService.getFileInstance("students");
    loadStudentTable();
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
    studentTable.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, groupColumn, emailColumn);
    studentTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldStudent, newStudent) -> {
      if(newStudent == null)
        newStudent = oldStudent;
      fnamefield.setText(newStudent.getFirstName());
      lnamefield.setText(newStudent.getLastName());
      groupfield.setText(newStudent.getGroup());
      emailfield.setText(newStudent.getEmail());
      currentId = newStudent.getId();
    });
    for (Student x : studentService.getAll())
      studentTable.getItems().add(x);
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
  }

  private void updateDeleteTableView(TableView tb, Entity en) {
    tb.getItems().remove(en);
  }

  @SuppressWarnings("unchecked")
  private void updateUpdateTableView(TableView tb, Entity en) {
    int index = Integer.parseInt((String) en.getId());
    tb.getItems().set(index-1, en);
  }

  @FXML
  void createStudent(ActionEvent ac) {
    String firstName = fnamefield.getText();
    String lastName = lnamefield.getText();
    String group = groupfield.getText();
    String email = emailfield.getText();
    try {
      Student<String> aux = new Student<>(firstName, lastName, group, email);
      Student st = studentService.add(aux);
      if (st != null) {
        showError(new Exception("Student already exists!"));
        return;
      }
      updateAddTableView(studentTable, aux);
      showMessage("Student has been added!");
    } catch (ValidationException err) {
      showError(err);
    }
  }

  @FXML
  void clearStudent(ActionEvent ac) {
    clearStudent();
  }

  void clearStudent() {
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
    Student aux = studentService.delete(currentId);
    if(aux == null) {
      showMessage("No student was found with this id");
      return;
    }
    showMessage("Student was deleted!");
    clearStudent();
    updateDeleteTableView(studentTable, aux);
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
      Student st = studentService.update(aux);
      if (st == null) {
        showMessage("Student has been updated!");
        updateUpdateTableView(studentTable, aux);
      }
      else
        showMessage("Student doesn't exist!");
    } catch (ValidationException e) {
      showError(e);
    }
    clearStudent();
  }
}
