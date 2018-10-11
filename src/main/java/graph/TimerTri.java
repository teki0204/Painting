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
  
  /**
  * 三角形描画のプログラムを実行させて，描いたマークと三角形をpaneに保存する。
  * 
  * @param primaryStage paneを表示するウィンドウ
  * @param pane マークと三角形描画のコンテナ
  */
  protected void init(Stage primaryStage, Pane pane) {
    startTri();
    pane.getChildren().add(line1);
    pane.getChildren().add(line2);
    pane.getChildren().add(line3);
    pane.getChildren().add(text);
  }
  
  /**
  * 三秒に一回で描画することを設置する。
  */
  protected void startTri() {
    int delay = 3000;
    timer = new Timer(delay, new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        Platform.runLater(new Runnable() {
          public void run() {
            resetTri();
          }
        });
      }
    });
    timer.start();
  }
  
  /**
  * ランダムな座標を重心として生成して、三角形描画メソッドに入力する。
  */
  protected void resetTri() {
    Random r = new Random();
    int x = r.nextInt(300) + 40;
    int y = r.nextInt(300) + 40;
    Triangle(x, y);
  }
  
  /**
  * グラフのプロパテを設定して、三角形を描く。
  * パラメタ「i」で三角形の数量を記録して、数字マーク付ける。
  * 
  * @param x2 ランダムで生成した重心の横座標
  * @param y2 ランダムで生成した重心の縦座標
  */
  protected void Triangle(double x2, double y2) {
    //マーク
    String j = String.valueOf(i);
    text.setFont(Font.font("Courier", FontPosture.ITALIC, 30));
    text.setX(x2 - 10);
    text.setY(y2);
    text.setText(j);

    //重心を中心として三つの点を決めて、連結して、三角形が完成される。
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

    //描いた三角形の数量を記録する。
    i++;
  }

  //Threadを実行する。
  public void run() {
    while (true) {
      try {
      } catch (Exception ex) {
      }
    }
  }
}