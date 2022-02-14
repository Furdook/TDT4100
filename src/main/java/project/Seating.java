package project;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Seating extends Application {
  private Cell[][] cell =  new Cell[20][10];

  @Override
  public void start(Stage primaryStage) {
    GridPane pane = new GridPane(); 
    for (int i = 0; i < 20; i++)
      for (int j = 0; j < 10; j++){
        Cell bro = new Cell();
        bro.setMinSize(15, 20);
        bro.setMaxSize(15, 20);
        pane.add(cell[i][j] = bro, j, i);
    }

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);

    Scene scene = new Scene(borderPane, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();   
  }

  public class Cell extends Pane {

    public Cell() {
      setStyle("-fx-border-color: red"); 
    }

  }
  public static void main(String[] args) {
    launch(args);
  }
}