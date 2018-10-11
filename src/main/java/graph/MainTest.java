package graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainTest extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }
  
  /**
  * 主プログラム
  * 
  * 関数の初期化して、三角形と円形の描画クラスの呼び出して、主要機能を実現する。
  * 
  * @param primaryStage Sceneを表示するウィンドウ
  */
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    TimerCircle circle = new TimerCircle();
    TimerTri triangle = new TimerTri();
    Thread c = new Thread(circle);
    Thread t = new Thread(triangle);
    //Threadのプログラムを実行させる。
    c.start();
    t.start();
    //描画のプログラムを実行させる。
    circle.init(primaryStage, pane);
    triangle.init(primaryStage, pane);
    //結果画面を表示する。
    primaryStage.setScene(new Scene(pane, 400, 400));
    primaryStage.show();
  }
}