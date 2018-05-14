import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;

import javafx.stage.FileChooser;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;

import java.io.File;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import javafx.event.*;

class KlikkbehandlerUtkast implements EventHandler<ActionEvent>{
  Button tast = null;
  Integer colIndex = -1;
  Integer rowIndex = -1;
  @Override
  public void handle(ActionEvent e){

    Button button = (Button)e.getSource();
    String knappTekst = button.getText();
    //System.out.println(knappTekst);
    if (knappTekst.equals("#")){
      System.out.println(knappTekst + ": Denne kan ikke velges.");
    } else if (knappTekst.equals(".")){
      System.out.println("Posisjonen til denne skal hentes ut.");
      this.colIndex = GridPane.getColumnIndex(button);
      this.rowIndex = GridPane.getRowIndex(button);
      System.out.println(this.colIndex + "Klikkbehandler");
      System.out.println(this.rowIndex + "Klikkbehandler");
      button.setText("Start");
    }
  }

  public ArrayList posisjon(){
    ArrayList<Integer> liste = new ArrayList<Integer>();
    liste.add(this.rowIndex);
    liste.add(this.colIndex);
    return liste;
  }
}
