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
      while (this.kanal.lytt()!=null){
        int kanalLengde = this.kanal.hentLengde();
        for (int i = 0; i < kanalLengde; i++){
          Melding meld = new Melding(this.kanal.lytt(),i,this.id);
          System.out.println(meld);
          this.monitor.settInnMelding(meld);
        }
      }
    } catch (InterruptedException e){
      System.out.println("Stopp 1"); //For aa vite hvor det stopper.
    }
  }
}
