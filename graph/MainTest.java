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
    TimerTri triangle = new TimerTri();
    Thread c = new Thread(circle);
    Thread t = new Thread(triangle);

/*Threadのプログラムを起動させる*/
    c.start();
    t.start();

/*表示エリアを設置する*/
    circle.Set(primaryStage, pane);
    triangle.Set(primaryStage, pane);

/*描画のプログラムを起動させる*/
    circle.init(primaryStage, pane);
    triangle.init(primaryStage, pane);

    primaryStage.setScene(new Scene(pane, 400, 400));
    primaryStage.show();
  }
}