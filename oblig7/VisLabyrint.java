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
  public File file = null;

  @Override
  public void start(Stage teater) {
    Text statusinfo = new Text("Velg startrute.");
    statusinfo.setFont(new Font(20));
    statusinfo.setX(20);
    statusinfo.setY(20);

    Button stoppknapp = new Button("Stopp");
    stoppknapp.setFont(new Font(20));
    stoppknapp.setLayoutX(200); stoppknapp.setLayoutY(0);
    Stoppbehandler stopp = new Stoppbehandler();
    stoppknapp.setOnAction(stopp);

    GridPane labyrint = new GridPane();
    labyrint.setGridLinesVisible(true);
    labyrint.setLayoutX(0); labyrint.setLayoutY(50);

    Klikkbehandler klikk = new Klikkbehandler();

    this.file = new FileChooser().showOpenDialog(teater);
    Labyrint l = null;
    try{
      l = Labyrint.lesFraFil(this.file);
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
