package graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainTest extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    TimerCircle circle = new TimerCircle();
    Thread c = new Thread(circle);
    c.start();
    circle.Set(primaryStage, pane);
    circle.init(primaryStage, pane);
    TimerTri triangle = new TimerTri();
    Thread t = new Thread(triangle);
    t.start();
    triangle.Set(primaryStage, pane);
    triangle.init(primaryStage, pane);
    primaryStage.setScene(new Scene(pane, 400, 400));
    primaryStage.show();
  }
}
