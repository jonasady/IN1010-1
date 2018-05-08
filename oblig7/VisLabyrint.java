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

/*class Rute extends Button{
  char merke = ' ';
  Rute(){
    super(" ");
    setFont(new Font(50));
    setPrefSize(120,120);
  }
  void settMerke(char c){
    setText(""+c);
    this.merke = c;
  }
}

class Klikkbehandler implements EventHandler<ActionEvent>{
  @Override
  public void handle(ActionEvent e){
    if (true){
      velge((Rute)e.getSource());
    }
  }
}*/

public class VisLabyrint extends Application {
  @Override
  public void start(Stage teater) {
    int kol = 0;
    int rad = 0;
    GridPane labyrint = new GridPane();
    labyrint.setGridLinesVisible(true);

    File file = new FileChooser().showOpenDialog(teater);
    try {
      Scanner f = new Scanner(file);
	    rad = f.nextInt();  kol = f.nextInt();
      //System.out.println("Rad: "+ rad + " Kolonne: " + kol);
      //brett = new Rute[(rad*kol)+1];
      //Klikkbehandler klikk = new Klikkbehandler();
      //for (){}
	  }
    catch (Exception e) {}

    /*void velge(Rute r){
      if (r.merke!=' '){
        statusinto.setText("Denne ruten er opptatt; velg en annen.");
        return;
      } else{
        statusinto.setText("Velg en rute.");
      }
      r.settMerke('0');
    }*/

    /*Circle fargedemo = new Circle(100);
	  fargedemo.setCenterX(100);
    fargedemo.setCenterY(100);
	  fargedemo.setFill(Color.rgb(127,255,212));

	  Pane kulisser = new Pane();
	  kulisser.getChildren().add(fargedemo);

    Scene scene = new Scene(kulisser);
    teater.setTitle("RGB-farge");
    teater.setScene(scene);
    teater.show();*/
  }
}

//public static void main(String[] args) {
//  launch(args);
//}
