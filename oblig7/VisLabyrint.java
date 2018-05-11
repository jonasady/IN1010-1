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

public class VisLabyrint extends Application{
  @Override
  public void start(Stage teater) {

    GridPane labyrint = new GridPane();
    labyrint.setGridLinesVisible(true);

    File file = new FileChooser().showOpenDialog(teater);
    try {
      Scanner f = new Scanner(file);
      String forsteLine = f.nextLine();
      String[] splitLine = forsteLine.split(" ");
      int ant_rad = Integer.parseInt(splitLine[0]);
      int ant_kol = Integer.parseInt(splitLine[1]);
      int teller =0;
      Rute[] brett = new Rute[(ant_rad*ant_kol)+1];

      Klikkbehandler klikk = new Klikkbehandler();


      while (f.hasNextLine()){
        String[] linje = f.nextLine().split("");
        for (int i = 0; i<ant_kol;i++){
          Rute rute = new Rute(linje[i]);
          labyrint.add(rute,i,teller);
        }
        teller++;
      }

      labyrint.add(new Text("#"),0,0);
      labyrint.add(new Text("."),1,0);

      System.out.println("Hei verden.");
      //labyrint.setLayoutX(2);
      //labyrint.setLayoutY(2);
	  }
    catch (Exception e) {}
    Pane kulisser = new Pane();
    kulisser.getChildren().add(labyrint);
    Scene scene = new Scene(kulisser);

    teater.setTitle("Labyrint");
    teater.setScene(scene);
    teater.show();
  }
  /*public void velge(Rute r){
    if (r.merke!=' '){
      statusinfo.setText("Denne ruten er opptatt; velg en annen.");
      return;
    } else{
      statusinfo.setText("Velg en rute.");
    }
    r.settMerke('0');
  }*/
  public static void main(String[] args){
    launch(args);
  }
}
