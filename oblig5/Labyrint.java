import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Labyrint{
  ArrayList<ArrayList<Rute>> lab;
  int ant_rad = -1;
  int ant_kol = -1;

  public Labyrint(int rad, int kol, ArrayList<ArrayList<Rute>> komplett){
    this.ant_rad = rad;
    this.ant_kol = kol;
    this.lab = komplett;
  }

  static Labyrint lesFraFil(File fil) throws FileNotFoundException{
  /*  try{*/
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
          if (tegn == '.'){
            ny = new HvitRute(radTeller,i);
          } else {
            ny = new SortRute(radTeller,i);
          }
          rad.add(ny);
        }
        radTeller++;
        komplett.add(rad);
      }
      Labyrint labyrint = new Labyrint(ant_rad, ant_kol, komplett);
      return labyrint;
/*    }
    catch (FileNotFoundException e){
      System.out.println("Finner ikke filen.");
      throw e;
    }*/
  }

  /*public lagLab(){
    for (int x = 0; i<=2; i++){
      for (int y = 0; y<=2;y++){
        Rute ny = new Rute(x,y);

      }
    }
  }*/
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
}
