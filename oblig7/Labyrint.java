import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javafx.scene.layout.GridPane;

class Labyrint{
  ArrayList<ArrayList<Rute>> lab;
  int ant_rad = -1;
  int ant_kol = -1;
  Liste<String> utveier;

  public Labyrint(int rad, int kol, ArrayList<ArrayList<Rute>> komplett){
    this.ant_rad = rad;
    this.ant_kol = kol;
    this.lab = komplett;
  }

  public ArrayList<ArrayList<Rute>> getLab(){
    return this.lab;
  }

  static Labyrint lesFraFil(File fil) throws FileNotFoundException{
    Scanner scanner = new Scanner(fil);
    String forsteLine = scanner.nextLine();
    String[] splitLine = forsteLine.split(" ");
    int ant_rad = Integer.parseInt(splitLine[0]);
    int ant_kol = Integer.parseInt(splitLine[1]);
    int radTeller = 0;
    ArrayList<ArrayList<Rute>> komplett = new ArrayList<ArrayList<Rute>>();

    while (scanner.hasNextLine()){
      String line = scanner.nextLine();
      ArrayList<Rute> rad = new ArrayList<Rute>();
      for (int i=0; i<ant_kol;i++){
        char tegn = line.charAt(i);
        Rute ny;
        if (tegn == '.' && (radTeller==ant_rad-1 || radTeller==0 || i==ant_kol-1 || i==0)){
          ny = new Aapning(radTeller,i);
        } else if (tegn == '.'){
          ny = new HvitRute(radTeller,i);
        } else {
          ny = new SortRute(radTeller,i);
        }
        rad.add(ny);
      }
      radTeller++;
      komplett.add(rad);
    }
    for (int x=0; x<ant_rad; x++){
      for (int y=0; y<ant_kol; y++){
        if (y<ant_kol-1){
          komplett.get(x).get(y).settOst(komplett.get(x).get(y+1));
          komplett.get(x).get(y+1).settVest(komplett.get(x).get(y));
        }
        if (x<ant_rad-1){
          komplett.get(x).get(y).settSyd(komplett.get(x+1).get(y));
          komplett.get(x+1).get(y).settNord(komplett.get(x).get(y));
        }
      }
    }
    Labyrint labyrint = new Labyrint(ant_rad, ant_kol, komplett);
    for (int x=0; x<ant_rad; x++){
      for (int y=0; y<ant_kol; y++){
        komplett.get(x).get(y).setLab(labyrint);
      }
    }
    return labyrint;
  }

  @Override
  public String toString(){
    String labyrintStr = "";
    String charTilStr = "";
    for (int x = 0; x<this.ant_rad; x++){
      for (int y = 0; y<this.ant_kol; y++){
        charTilStr = String.valueOf(this.lab.get(x).get(y).tilTegn());
        labyrintStr = labyrintStr.concat(charTilStr);
      }
      labyrintStr = labyrintStr.concat("\n");
    }
    return labyrintStr;
  }

  public Liste<String> finnUtveiFra(int kol, int rad){
    this.utveier = new Lenkeliste<String>();
    this.lab.get(rad).get(kol).finnUtvei();
    return this.utveier;
  }
}
