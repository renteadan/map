import Config.Context;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.GradeService;
import service.HomeworkService;
import service.StudentService;

public class MainFX extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    loadConfig();
    Parent root = FXMLLoader.load(getClass().getResource("FXMLView/MainUI.fxml"));
    stage.setScene(new Scene(root));
    stage.setTitle("My app");
    stage.show();
  }

  private void loadConfig() {
    String gradesFile = Context.getConfig().getProperty("grades_file");
    String studentFile = Context.getConfig().getProperty("students_file");
    String homeworkFile = Context.getConfig().getProperty("homework_file");
    GradeService.getFileInstance(gradesFile);
    StudentService.getFileInstance(studentFile);
    HomeworkService.getFileInstance(homeworkFile);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
