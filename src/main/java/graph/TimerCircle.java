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

  /**
  * 円形描画のプログラムを実行させて，描いたマークと円形をpaneに保存する。
  * 
  * @param primaryStage paneを表示するウィンドウ
  * @param pane マークと円形描画のコンテナ
  */
  protected void init(Stage primaryStage, Pane pane) {
    startCircle();
    pane.getChildren().add(circle);
    pane.getChildren().add(text);
  }
  /**
  * 二秒に一回で描画することを設置して、ランダムな座標を円の中心として生成する。
  * 生成した座標値を圆形描画メソッドに入力する。
  */
  protected void startCircle() {
    int delay = 2000;
    timer = new Timer(delay, new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        Platform.runLater(new Runnable() {
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
  /**
  * グラフのプロパテを設定して、円形を描く。
  * パラメタ「i」で円形の数量を記録して、数字マーク付ける。
  * 
  * @param x ランダムで生成した横座標
  * @param y ランダムで生成した縦座標
  */
  protected void resetCircle(int x, int y) {
    //マーク
    String j = String.valueOf(i);
    text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 30));
    text.setX(x - 8);
    text.setY(y + 10);
    text.setText(j);
    //円形を描く。
    circle.setCenterX(x);
    circle.setCenterY(y);
    circle.setRadius(40);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
    //描いた円形の数量を記録する。
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