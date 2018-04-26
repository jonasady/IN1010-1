public class Telegrafist implements Runnable{
  int id;
  private Monitor monitor;
  private int lyttetTil = 0;
  private Kanal kanal;

  Telegrafist(Monitor monitor, int id, Kanal[] kanaler){
    this.monitor = monitor;
    this.id = id;
    this.kanal = kanaler[this.id];
  }

  public void run(){
    try{
      int kanalLengde = this.kanal.length();
      for (int i = 0; i < kanalLengde; i++){
        Melding meld = new Melding(this.kanal.lytt(),i,this.id);
        //Legg til meld i monitor for krypterte meldinger.
      }
      while (){
        this.monitor.settInnMelding(meld);
      }
    }
  }
}
