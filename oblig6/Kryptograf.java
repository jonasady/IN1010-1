public class Kryptograf implements Runnable{
  private Monitor kryptertMonitor;
  private Monitor dekryptertMonitor;
  private int dekryptert = 0;
  private Melding meld;
  private int kryptert = 0;

  Kryptograf(Monitor kryptertMonitor, Monitor dekryptertMonitor){
    this.kryptertMonitor = kryptertMonitor;
    this.dekryptertMonitor = dekryptertMonitor;
  }

  @Override
  public void run(){
    try{
      while (true){
        this.kryptert++;
        this.meld=this.kryptertMonitor.henteUtMelding();
        if (this.meld==null){
          //System.out.println("Ingen meldinger aa hente.");
          Melding meld = new Melding(null,-1,-1);
          this.dekryptertMonitor.settInnMelding(meld);
          break;
        }
        //System.out.println("Melding hentet ut av Kryptograf.");
        String tekst = this.meld.getMelding();
        this.meld.settMelding(Kryptografi.dekrypter(tekst));
        //System.out.println("Melding som er dekryptert ID: " + this.meld.getID() + "  sek: "+ this.meld.getSekvens());
        this.dekryptertMonitor.settInnMelding(this.meld);
      }
    } catch (InterruptedException e){
      System.out.println("Stopp i run for Kryptograf"); //For aa vite hvor det stopper.
    }
  }
}
