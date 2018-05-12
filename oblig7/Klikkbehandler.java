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
  @Override
  public void handle(ActionEvent e){
    if (true){
      System.out.println("Klikket.");
      System.out.println((Button)e.getSource());
      System.out.println((Button)e.getTarget());

    }
  }
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
