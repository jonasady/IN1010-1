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

import javafx.event.*;

class Klikkbehandler implements EventHandler<ActionEvent>{
  Button tast = null;
  @Override
  public void handle(ActionEvent e){

    Button button = (Button)e.getSource();
    String knappTekst = button.getText();
    //System.out.println(knappTekst);
    if (knappTekst.equals("#")){
      System.out.println(knappTekst + ": Denne kan ikke velges.");
    } else if (knappTekst.equals(".")){
      System.out.println("Posisjonen til denne skal hentes ut.");
      Integer colIndex = GridPane.getColumnIndex(button);
      Integer rowIndex = GridPane.getRowIndex(button);
      System.out.println(colIndex);
      System.out.println(rowIndex);
      
    }
  }
}
