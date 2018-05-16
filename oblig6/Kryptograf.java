public class Kryptograf implements Runnable{
  private Monitor kryptertMonitor;
  private Monitor dekryptertMonitor;
  private int dekryptert = 0;
  private int kryptert = 0;

  Kryptograf(Monitor kryptertMonitor, Monitor dekryptertMonitor){
    this.kryptertMonitor = kryptertMonitor;
    this.dekryptertMonitor = dekryptertMonitor;
  }

  @Override
  public void run(){
    try{
      Melding meld = kryptertMonitor.henteUtMelding();
      while(meld != null) {
        String tekst = meld.getMelding();
        Melding ny = new Melding(Kryptografi.dekrypter(tekst),meld.getSekvens(),meld.getID());
        this.kryptert++;
        this.dekryptertMonitor.settInnMelding(ny);
        meld = kryptertMonitor.henteUtMelding();
      }
      Melding meld_slutt = new Melding(null,-1,-1);
      this.dekryptertMonitor.settInnMelding(meld_slutt);
    } catch (InterruptedException e){
      System.out.println("Stopp i run for Kryptograf");
    }
  }
}
