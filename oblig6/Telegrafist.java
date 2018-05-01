public class Telegrafist implements Runnable{
  int id;
  private Monitor monitor;
  private int lyttetTil = 0;
  private Kanal kanal;

  Telegrafist(Monitor monitor, int id, Kanal kanal){
    this.monitor = monitor;
    this.id = id;
    this.kanal = kanal;
  }

  @Override
  public void run(){
    try{
      int kanalLengde = this.kanal.hentLengde();
      for (int i = 0; i < kanalLengde; i++){
        Melding meld = new Melding(this.kanal.lytt(),i,this.id);
        this.monitor.settInnMelding(meld);
        //System.out.println("Melding satt inn av Telegrafist.");
      }
      Melding meld = new Melding(null,kanalLengde,this.id);
      this.monitor.settInnMelding(meld);
    } catch (InterruptedException e){
      System.out.println("Stopp i run for telegrafist."); //For aa vite hvor det stopper.
    }
  }
}
