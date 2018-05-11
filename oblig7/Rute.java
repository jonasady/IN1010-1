import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;

import javafx.stage.FileChooser;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.File;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

class Rute extends Button{
  char merke = ' ';
  Rute(String str){
    super(" ");
    this.merke = str.charAt(0);
    setFont(new Font(50));
    setPrefSize(120,120);
    this.settMerke(this.merke);
  }
  void settMerke(char c){
    setText(""+c);
    this.merke = c;
  }
}
