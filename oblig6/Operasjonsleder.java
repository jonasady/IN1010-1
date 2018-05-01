import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Operasjonsleder implements Runnable{
  private Monitor dekryptertMonitor;
  private int dekryptert = 0;
  private Melding meld;
  private ArrayList<Melding> ListeMeldinger = new ArrayList<Melding>();

  Operasjonsleder(Monitor dekryptertMonitor){
    this.dekryptertMonitor = dekryptertMonitor;
  }

  @Override
  public void run(){
    try{
      while (true){
        this.meld=this.dekryptertMonitor.henteUtMelding();
        if (this.meld==null){
          System.out.println("ingen flere i dekryptert Monitor.");
          break;
        }
        //System.out.println("Melding hentet ut av Kryptograf.");
        ListeMeldinger.add(this.meld);
        //System.out.println("Operasjons Melding som er dekryptert ID: " + this.meld.getID() + "  sek: "+ this.meld.getSekvens());
      }
    } catch (InterruptedException  e){
      System.out.println("Stopp i run for Kryptograf"); //For aa vite hvor det stopper.
    }
    this.skrivTilFiler();
  }

  private void skrivTilFiler(){
    try{
      PrintWriter printWriter = new PrintWriter("file.txt", "utf-8");
      System.out.println(ListeMeldinger.size());
      for (int i = 0; i<ListeMeldinger.size(); i++){
        Melding tempMeld = ListeMeldinger.get(i);
        if (tempMeld.getID()==0){
          //System.out.println(tempMeld.getMelding());
          printWriter.println(tempMeld.getMelding());
        }
      }
      printWriter.close();
    } catch (FileNotFoundException | UnsupportedEncodingException e){
      System.out.println("Ingen fil funnet eller ikke riktig kode.");
    }
  }
}
