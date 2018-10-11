package graph;

import javax.swing.Timer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class TimerTri implements Runnable {
  private Timer timer;
  public int i = 0;
  Pane pane = new Pane();
  Text text = new Text();
  Scene scene = new Scene(pane, 400, 400);
  Stage stage = new Stage();
  Line line1 = new Line();
  Line line2 = new Line();
  Line line3 = new Line();

  protected void Set(Stage q, Pane p) {
    pane = p;
    stage = q;
  }

/*三角形描画のプログラムを起動させる*/
  protected void init(Stage primaryStage, Pane pane) {
    startTime(primaryStage, pane);
    pane.getChildren().add(line1);
    pane.getChildren().add(line2);
    pane.getChildren().add(line3);
    pane.getChildren().add(text);
  }

/*タイマー*/
  protected void startTime(Stage primaryStage, Pane pane) {
    int delay = 3000;
    timer = new Timer(delay, new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            resetPolygon(primaryStage, pane);
          }
        });
      }
    });
    timer.start();
  }

/*ランダムで三角の座標を設置する*/
  protected void resetPolygon(Stage primaryStage, Pane pane) {
    Random r = new Random();
    double x = r.nextInt(300) + 40, y = r.nextInt(300) + 40;
    Triangle(x, y, primaryStage, pane);
  }

/*三角形を描いて、マークする*/
  protected void Triangle(double x2, double y2, Stage primaryStage, Pane pane2) {
    String j = String.valueOf(i);
    text.setFont(Font.font("Courier", FontPosture.ITALIC, 30));
    text.setX(x2 - 10);
    text.setY(y2);
    text.setText(j);

    line1.setStartX(x2 - 40 * Math.sqrt(3.0));
    line1.setEndX(x2 + 40 * Math.sqrt(3.0));
    line1.setStartY(y2 + 20);
    line1.setEndY(y2 + 20);
    line1.setStroke(Color.BLACK);

    line2.setStartX(x2);
    line2.setEndX(x2 + 40 * Math.sqrt(3.0));
    line2.setStartY(y2 - 80);
    line2.setEndY(y2 + 20);
    line2.setStroke(Color.BLACK);

    line3.setStartX(x2 - 40 * Math.sqrt(3.0));
    line3.setEndX(x2);
    line3.setStartY(y2 + 20);
    line3.setEndY(y2 - 80);
    line3.setStroke(Color.BLACK);

    i++;
  }

  public void run() {
    while (true) {
      try {
      } catch (Exception ex) {
      }
    }
  }
}