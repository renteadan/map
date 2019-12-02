package com.company.controller;

import com.company.Observer.Observable;
import com.company.entity.Entity;
import com.company.entity.Grade;
import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.service.GradeService;
import com.company.service.HomeworkService;
import com.company.service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;
import java.util.Optional;

public class GradeController implements Observable {
  @FXML
  public TextField student,homework,professorField, gradeField, dateField;
  public TextArea feedbackField;
  @FXML
  public TableView<Grade<String>> table;
  public TextField homeworkField, studentField;
  private GradeService<String> service;
  private HomeworkService<String> hmService;
  private StudentService<String> stService;
  private String currentId, studentId, homeworkId;

  public GradeController() {
  }

  @SuppressWarnings("unchecked")
  private void initRepo() {
    service = GradeService.getFileInstance("grades");
    hmService = HomeworkService.getFileInstance("homeworks");
    stService = StudentService.getFileInstance("students");
    service.addObservable(this);
    hmService.addObservable(this);
    stService.addObservable(this);
    loadTable();
  }

  @SuppressWarnings("unchecked")
  private void loadData() {
    table.getItems().clear();
    for (Grade x : service.getAll())
      table.getItems().add(x);
  }

  @SuppressWarnings("unchecked")
  private void loadColumns() {
    TableColumn idColumn = new TableColumn("Id");
    TableColumn professorColumn = new TableColumn("Professor");
    TableColumn gradeColumn = new TableColumn("Grade");
    TableColumn feedbackColumn = new TableColumn("Feedback");
    TableColumn dateColumn = new TableColumn("Date");
    TableColumn nameColumn = new TableColumn("Student name");
    TableColumn descriptionColumn = new TableColumn("Homework description");
    idColumn.setCellValueFactory(new PropertyValueFactory<Homework<String>, String>("Id"));
    professorColumn.setCellValueFactory(new PropertyValueFactory<Homework<String>, String>("professor"));
    gradeColumn.setCellValueFactory(new PropertyValueFactory<Homework<String>, Integer>("grade"));
    feedbackColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("feedback"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, LocalDateTime>("date"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("name"));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<Student<String>, String>("description"));
    table.getColumns().addAll(idColumn, professorColumn, gradeColumn, feedbackColumn, dateColumn, nameColumn, descriptionColumn);
  }

  private void loadTable() {
    loadColumns();
    table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldE, newE) -> {
      if(newE == null)
        newE = oldE;
      professorField.setText(newE.getProfessor());
      gradeField.setText(String.valueOf(newE.getGrade()));
      feedbackField.setText(newE.getFeedback());
      dateField.setText(newE.getStringDate());
      currentId = newE.getId();
      studentId = newE.getStudentId();
      homeworkId = newE.getHomeworkId();
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

  @FXML
  void studentChoice(ActionEvent ac) {
    studentChoice();
  }

  private void studentChoice() {
    ChoiceDialog<Student> dialog = new ChoiceDialog<Student>();
    dialog.getItems().clear();
    for (Student x: stService.getAll())
      dialog.getItems().add(x);
    dialog.setTitle("Student");
    dialog.setHeaderText("Select a student");
    dialog.setContentText("Students:");
    Optional<Student> studentOptional = dialog.showAndWait();
    studentOptional.ifPresent(student -> {
      studentId = (String) student.getId();
      studentField.setText(String.format("%s %s",student.getFirstName(), student.getLastName()));
    });
  }

  @FXML
  void homeworkChoice(ActionEvent ac) {
    homeworkChoice();
  }

  private void homeworkChoice() {
    ChoiceDialog<Homework> dialog = new ChoiceDialog<>();
    dialog.getItems().clear();
    for (Homework x: hmService.getAll())
      dialog.getItems().add(x);
    dialog.setTitle("Homework");
    dialog.setHeaderText("Select a homework");
    dialog.setContentText("Homework:");
    Optional<Homework> homeworkOptional = dialog.showAndWait();
    homeworkOptional.ifPresent(homework -> {
      homeworkId = (String) homework.getId();
      homeworkField.setText(homework.getDescription());
      showMessage(String.format("Max grade for this homework is %d",homework.getMaxGrade()));
      dateField.setText(LocalDateTime.now().toString());
      if (homework.getMaxGrade() < 10)
        feedbackField.setText(feedbackField.getText() + " " + "NOTA A FOST DIMINUATĂ DATORITĂ ÎNTÂRZIERILOR");
      else
        feedbackField.clear();
    });
  }

  @FXML
  void create(ActionEvent ac) {
    String professor = professorField.getText();
    int grade = Integer.parseInt(gradeField.getText());
    String feedback = feedbackField.getText();
    if(studentId == null) {
      showError(new Exception("You must select a student!"));
      return;
    }
    if(homeworkId == null) {
      showError(new Exception("You must select a homework!"));
      return;
    }

    if(service.isHomeworkGraded(studentId, homeworkId)) {
      showError(new Exception("Student is already graded for this homework!"));
      clear();
      return;
    }
    try {
      Grade<String> aux = new Grade<>(studentId, homeworkId, professor, grade, feedback);
      Grade st = service.add(aux);
      if (st != null) {
        showError(new Exception("Grade already exists!"));
        return;
      }
      updateAddTableView(table, aux);
      showMessage("Grade has been added!");
    } catch (ValidationException err) {
      showError(err);
    }
  }

  @FXML
  void clear(ActionEvent ac) {
    clear();
  }

  private void clear() {
    professorField.clear();
    gradeField.clear();
    feedbackField.clear();
    dateField.clear();
    studentField.clear();
    homeworkField.clear();
    currentId = null;
    studentId = null;
    homeworkId = null;
  }

  @FXML
  void delete(ActionEvent ac) {
    if(currentId == null) {
      showMessage("You haven't selected any grade!");
      return;
    }
    Grade aux = service.delete(currentId);
    if(aux == null) {
      showMessage("No grade was found");
      return;
    }
    showMessage("Grade was deleted!");
    clear();
    updateDeleteTableView(table, aux);
  }

  @FXML
  void update(ActionEvent ac) {
    if(currentId == null) {
      showMessage("You haven't selected any grade!");
      return;
    }
    String professor = professorField.getText();
    int grade = Integer.parseInt(gradeField.getText());
    String feedback = feedbackField.getText();
    Grade<String> aux = new Grade<>(currentId,studentId, homeworkId, professor, grade, feedback);
    try {
      Grade st = service.update(aux);
      if (st == null) {
        showMessage("Grade has been updated!");
        updateUpdateTableView(table, aux);
      }
      else
        showMessage("Grade doesn't exist!");
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
