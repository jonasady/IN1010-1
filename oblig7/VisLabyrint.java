import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;

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
import javafx.event.*;

public class VisLabyrint extends Application{
  public File file = null;
  private GridPane labyrint = new GridPane();
  private Labyrint l = null;
  public int ant_rad;
  public int ant_kol;
  Text statusinfo;
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

  class Klikkbehandler implements EventHandler<ActionEvent>{
  Button tast = null;
  Integer colIndex = -1;
  Integer rowIndex = -1;

  private Button getNodeFromGridPane(GridPane gridPane, int col, int row) {
    for (Node node : gridPane.getChildren()) {
      Integer columnIndex = GridPane.getColumnIndex(node);
      Integer rowIndex = GridPane.getRowIndex(node);
      if ((columnIndex != null && columnIndex.intValue() == col) && (rowIndex != null && rowIndex.intValue() == row)) {
        if (node instanceof Button){
          Button butt = (Button) node;
          return butt;
        } else{
          return null;
        }
      }
    }
    return null;
  }

  @Override
  public void handle(ActionEvent e){
    Button button = (Button)e.getSource();
    String knappTekst = button.getText();
    //System.out.println(knappTekst);
    if (knappTekst.equals("#")){
      System.out.println(knappTekst + ": Denne kan ikke velges.");
    } else if (knappTekst.equals(".")){
      this.colIndex = GridPane.getColumnIndex(button);
      this.rowIndex = GridPane.getRowIndex(button);
      Liste<String> utveier = l.finnUtveiFra(this.colIndex, this.rowIndex);
      statusinfo.setText("Det finnes " + utveier.stoerrelse() + " utvei(er).");
      boolean[][] bool_utvei = losningStringTilTabell(utveier.hent(0),ant_kol,ant_rad);
      for (int x = 0; x<ant_rad; x++){
        for (int y = 0; y<ant_kol; y++){
          Button hentetButton = getNodeFromGridPane(labyrint, y, x); //Hente ut knapp fra en posisjon og gjore denne gul.
          if (bool_utvei[x][y]){
            hentetButton.setText("!");
            hentetButton.setStyle("-fx-background-color: #16C3EF; -fx-text-fill: #16C3EF");
          }
        }
      }
    }
  }
}

  @Override
  public void start(Stage teater) {
    this.statusinfo = new Text("Velg startrute.");
    this.statusinfo.setFont(new Font(18));
    this.statusinfo.setX(0);
    this.statusinfo.setY(20);

    Button stoppknapp = new Button("Stopp");
    stoppknapp.setFont(new Font(18));
    stoppknapp.setLayoutX(200); stoppknapp.setLayoutY(0);
    Stoppbehandler stopp = new Stoppbehandler();
    stoppknapp.setOnAction(stopp);

    this.labyrint.setGridLinesVisible(false);
    this.labyrint.setLayoutX(0); this.labyrint.setLayoutY(50);

    Klikkbehandler klikk = new Klikkbehandler();

    this.file = new FileChooser().showOpenDialog(teater);

    try{
      this.l = Labyrint.lesFraFil(this.file);
      ArrayList<ArrayList<Rute>> rutenett = this.l.getLab();
      this.ant_rad = rutenett.size();
      this.ant_kol = rutenett.get(0).size();
      for (int x = 0; x<this.ant_rad; x++){
        for (int y = 0; y<this.ant_kol; y++){
          String charTilStr = String.valueOf(rutenett.get(x).get(y).tilTegn());
          Button knapp = new Button(charTilStr);
          if (knapp.getText().equals("#")){
            knapp.setStyle("-fx-background-color: #000000; -fx-text-fill: #000000"); //Svart farge...
          } else if (knapp.getText().equals(".")){
            knapp.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #0000ff"); //Hvit farge...
          }
          knapp.setOnAction(klikk);
          this.labyrint.add(knapp,y,x);
        }
      }
    } catch (Exception e){}

    Pane kulisser = new Pane();

    kulisser.getChildren().add(this.labyrint);
    kulisser.getChildren().add(this.statusinfo);
    kulisser.getChildren().add(stoppknapp);
    Scene scene = new Scene(kulisser);

    teater.setTitle("Labyrint");
    teater.setScene(scene);
    teater.show();
  }



  public static void main(String[] args){
    launch(args);
  }
}
