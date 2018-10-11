package graph;

import java.util.*;
import javax.swing.Timer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TimerCircle implements Runnable {
  private Timer timer;
  public int i = 0;
  Circle circle = new Circle();
  Text text = new Text();
  Pane pane = new Pane();
  Scene scene = new Scene(pane, 400, 400);
  Stage stage = new Stage();

  protected void Set(Stage q, Pane p) {
    pane = p;
    stage = q;
  }

/*三角形描画のプログラムを起動させる*/
  protected void init(Stage primaryStage, Pane pane) {
    startCircle();
    pane.getChildren().add(circle);
    pane.getChildren().add(text);
  }

/*タイマーとランダムな座標の設置*/
  protected void startCircle() {
    int delay = 2000;
    timer = new Timer(delay, new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            Random r = new Random();
            int x = r.nextInt(300) + 40;
            int y = r.nextInt(300) + 40;
            resetCircle(x, y);
          }
        });
      }
    });
    timer.start();
  }

/*円形を描いて、マークする*/
  protected void resetCircle(int x, int y) {
    String j = String.valueOf(i);
    text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 30));
    text.setX(x - 8);
    text.setY(y + 10);
    text.setText(j);
    circle.setCenterX(x);
    circle.setCenterY(y);
    circle.setRadius(40);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
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