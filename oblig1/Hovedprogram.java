import java.util.Scanner;
import java.io.*;

class Hovedprogram{
  public static void main(String[] args){
    Regneklynge abel=new Regneklynge("regneklynge.txt");

    /*abel.setMaksAntNoder(12);*/
    /*for (int i=0; i<650;i++){
      abel.settInnNode(64,1);
    }*/ /*Legger inn 650 noder med 64 GB og 1 prosessor*/

    /*for (int i=0; i<16;i++){
      abel.settInnNode(1024,2);
    }*/ /*Legger inn 16 noder med 1024 GB og 2 prosessorer*/

    System.out.println("Noder med minst 32 GB: "+abel.noderMedNokMinne(32));
    System.out.println("Noder med minst 64 GB: "+abel.noderMedNokMinne(64));
    System.out.println("Noder med minst 128 GB: "+abel.noderMedNokMinne(128));
    System.out.println("Antall prosessorer: "+abel.antProsessorer());
    System.out.println("Antall rack: "+abel.antRacks());
  }
}
