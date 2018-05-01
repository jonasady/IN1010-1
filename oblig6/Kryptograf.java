public class Kryptograf implements Runnable{
  private Monitor kryptertMonitor;
  private Monitor dekryptertMonitor;
  private final int ANTALL =5;
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
        while ((this.kryptert<=this.ANTALL) /*&& (this.kryptertMonitor.henteUtMelding()!=null)*/){
          this.kryptert++;
          this.meld=this.kryptertMonitor.henteUtMelding();
          System.out.println("Melding hentet ut av Kryptograf.");
          String tekst = this.meld.getMelding();
          this.meld.settMelding(Kryptografi.dekrypter(tekst));
          System.out.println("Melding som er dekryptert: " + this.meld.getMelding());
          this.dekryptertMonitor.settInnMelding(this.meld);
          Thread.sleep((long)(2*Math.random()));
      }
    } catch (InterruptedException e){
      System.out.println("Stopp i run for Kryptograf"); //For aa vite hvor det stopper.
    }
  }
}
