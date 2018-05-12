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
import java.util.ArrayList;
import java.io.*;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class VisLabyrint extends Application{

  @Override
  public void start(Stage teater) {
    Text statusinfo = new Text("Velg startrute.");
    statusinfo.setFont(new Font(20));
    statusinfo.setX(20);
    statusinfo.setY(20);

    Button stoppknapp = new Button("Stopp");
    stoppknapp.setFont(new Font(20));
    stoppknapp.setLayoutX(250); stoppknapp.setLayoutY(0);
    Stoppbehandler stopp = new Stoppbehandler();
    stoppknapp.setOnAction(stopp);

    GridPane labyrint = new GridPane();
    labyrint.setGridLinesVisible(true);
    //labyrint.setLayoutX(0); labyrint.setLayoutY(50);

    Klikkbehandler klikk = new Klikkbehandler();

    File file = new FileChooser().showOpenDialog(teater);
    Labyrint l = null;
    try{
      l = Labyrint.lesFraFil(file);
      //System.out.println(l.toString());

      ArrayList<ArrayList<Rute>> rutenett = l.getLab();
      int ant_rad = rutenett.size();
      int ant_kol = rutenett.get(0).size();
      for (int x = 0; x<ant_rad; x++){
        for (int y = 0; y<ant_kol; y++){
          String charTilStr = String.valueOf(rutenett.get(x).get(y).tilTegn());
          Button knapp = new Button(charTilStr);
          knapp.setOnAction(klikk);
          labyrint.add(knapp,y,x);
        }
      }
    } catch (Exception e){}

    /*try {
      Scanner f = new Scanner(file);
      String forsteLine = f.nextLine();
      String[] splitLine = forsteLine.split(" ");
      int ant_rad = Integer.parseInt(splitLine[0]);
      int ant_kol = Integer.parseInt(splitLine[1]);
      int teller =0;
      //Rute[] brett = new Rute[(ant_rad*ant_kol)+1];

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
    catch (Exception e) {}*/
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
    if (r.merke!='.'){
      statusinfo.setText("Denne ruten er svart, du kan ikke velge denne.");
      return;
    } else{
      statusinfo.setText("Velg en rute.");
    }
    r.settMerke('s');
  }*/
  /**
   * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
   * av losningstien.
   * @param losningString String-representasjon av utveien
   * @param bredde        bredde til labyrinten
   * @param hoyde         hoyde til labyrinten
   * @return              2D-representasjon av rutene der true indikerer at
   *                      ruten er en del av utveien.
   */
  static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
      boolean[][] losning = new boolean[hoyde][bredde];
      java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
      java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
      while (m.find()) {
          int x = Integer.parseInt(m.group(1));
          int y = Integer.parseInt(m.group(2));
          losning[y][x] = true;
      }
      return losning;
  }
  
  public static void main(String[] args){
    launch(args);
  }
}
