import java.io.PrintWriter;
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Operasjonsleder implements Runnable{
  private Monitor dekryptertMonitor;
  private int dekryptert = 0;
  private ArrayList<Melding> ListeMeldinger = new ArrayList<Melding>();

  Operasjonsleder(Monitor dekryptertMonitor){
    this.dekryptertMonitor = dekryptertMonitor;
  }

  @Override
  public void run(){
    try{
      Melding meld=this.dekryptertMonitor.henteUtMelding();
      while (meld !=null){
        ListeMeldinger.add(meld);
        meld=this.dekryptertMonitor.henteUtMelding();
      }
    } catch (InterruptedException  e){
      System.out.println("Stopp i run for Kryptograf"); //For aa vite hvor det stopper.
    }
    this.skrivTilFiler();
  }

  private void skrivTilFiler(){
    ArrayList<Integer> ListeOverID = new ArrayList<Integer>();
    for (int i = 0; i<ListeMeldinger.size(); i++){
      Integer tempID = ListeMeldinger.get(i).getID();
      if (ListeOverID.contains(tempID)==false){
        ListeOverID.add(tempID);
      }
    }
    Collections.sort(ListeMeldinger);
    try{
      ArrayList<PrintWriter> ListePrintWriter = new ArrayList<PrintWriter>();
      for (int i = 0; i<ListeOverID.size();i++){
        PrintWriter printWriter = new PrintWriter("file_"+i+".txt", "utf-8");
        ListePrintWriter.add(printWriter);
      }
      for (int i = 0; i<ListeMeldinger.size(); i++){
        Melding tempMeld = ListeMeldinger.get(i);
        ListePrintWriter.get(tempMeld.getID()).println(tempMeld.getMelding());
      }
      for (int i = 0; i<ListePrintWriter.size();i++){
        ListePrintWriter.get(i).close();
      }
    } catch (FileNotFoundException | UnsupportedEncodingException e){
      System.out.println("Ingen fil funnet eller ikke riktig kode.");
    }
  }
}
