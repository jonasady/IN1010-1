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
    Text statusinfo = new Text("Velg startrute.");
    statusinfo.setFont(new Font(20));
    statusinfo.setX(10);
    statusinfo.setY(410);

    Button stoppknapp = new Button("Stopp");
    stoppknapp.setLayoutX(10); stoppknapp.setLayoutY(450);
    Stoppbehandler stopp = new Stoppbehandler();
    stoppknapp.setOnAction(stopp);

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
    	    rute.setOnAction(klikk);
        }
        teller++;
      }

      System.out.println("Hei verden.");
      //labyrint.setLayoutX(2);
      //labyrint.setLayoutY(2);
	  }
    catch (Exception e) {}
    Pane kulisser = new Pane();
    //kulisser.setPrefSize(4000, 5000);
    kulisser.getChildren().add(labyrint);
    kulisser.getChildren().add(statusinfo);
    kulisser.getChildren().add(stoppknapp);
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
