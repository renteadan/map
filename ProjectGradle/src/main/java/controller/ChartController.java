package controller;

import Observer.Observable;
import entity.Grade;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import service.GradeService;
import service.StudentService;

public class ChartController implements Observable {

  @FXML
  public BarChart<String, Number> chart;
  private GradeService<String> service;
  private StudentService<String> stService;
  @FXML
  public CategoryAxis xAxis;
  @FXML
  public NumberAxis yAxis;

  @FXML
  public CheckBox box;

  @FXML
  public ChoiceBox<Student<String>> choice;

  public ChartController() {
  }

  @FXML
  public void initialize() {
    initRepo();
  }

  @SuppressWarnings("unchecked")
  private void initRepo() {
    service = GradeService.getFileInstance("grades");
    service.addObservable(this);
    stService = StudentService.getFileInstance("students");
    loadChart();
  }

  private void loadChart() {
    xAxis.setLabel("Homework");
    yAxis.setLabel("Grade");
    loadData();
  }

  @SuppressWarnings("unchecked")
  private void loadData(Student<String> student) {
    if(box.isSelected()) {
      for(XYChart.Series x: chart.getData()) {
        if(x.getName().equals(student.getFirstName()))
         return;
      }
    } else
      chart.getData().clear();
    XYChart.Series series1 = new XYChart.Series();
    series1.setName(student.getFirstName());
    for(Grade x: service.getGradesByStudent(student.getId())) {
      series1.getData().add(new XYChart.Data<String, Number>(x.getHomework().getDescription(), x.getGrade()));
    }
    chart.getData().add(series1);
  }

  private void loadData() {
    choice.getItems().clear();
    for(Student<String> x:stService.getAll()) {
      choice.getItems().add(x);
    }
    Student<String> aux = stService.getAll().iterator().next();
    choice.setValue(aux);
    loadData(aux);
  }

  @Override
  public void getNotified() {
    loadData();
  }

  @Override
  public void notifyObserver() {
    service.notifyObservables();
  }

  public void changeStudent(ActionEvent ac) {
    Student<String> aux = choice.getValue();
    loadData(aux);
  }

  @FXML
  public void clear(ActionEvent ac) {
    chart.getData().clear();
  }
}
