import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class Monitor{
  private Lock monitorlas = new ReentrantLock();
  private Condition ikkeTomMonitor = monitorlas.newCondition();
  private Condition ikkeFullMonitor = monitorlas.newCondition();
  private int antallMeldinger = 0;
  private final int MONITOR_KAPASITET = 1000; //Kanskje et annet tall??
  private ArrayList<Melding> ListeMeldinger = new ArrayList<Melding>();
  private int antallSendere;
  private int antallNull=0;

  Monitor(int antallSendere){
    this.antallSendere=antallSendere;
  }

  int antMeld(){
    return this.antallMeldinger;
  }

  void settInnMelding(Melding meld) throws InterruptedException{
    monitorlas.lock();
    try {
      if (meld.getMelding()==null){
        //System.out.println("Innsender tom: " + meld.getID() + "  sek: "+ meld.getSekvens());
        //System.out.println(this.antallSendere + " " + this.antallNull);
        this.antallNull++;
        return;
      }
      while (antallMeldinger >= MONITOR_KAPASITET){
        ikkeFullMonitor.await(); //Venter paa at monitor ikke skal vaere full.
      } //Naa er antallMeldinger < MONITOR_KAPASITET
      //Legg til i listen over meldinger.
      ListeMeldinger.add(meld);
      antallMeldinger++;
      ikkeTomMonitor.signalAll(); //Sier fra til operatoer.
    }
    finally {monitorlas.unlock();}
  }

  Melding henteUtMelding() throws InterruptedException{
    monitorlas.lock();
    Melding meld;
    try {
      if ((this.antallNull==this.antallSendere) && (antallMeldinger == 0)){
        //System.out.println("linje 47, monitor. sendere: " + this.antallSendere);
        return null;
      }
      while (antallMeldinger == 0){ //Ikke mulig aa hente ut melding naar det ikke er noen.
        ikkeTomMonitor.await();
      } //antallMeldinger > 0
      //Maa fjerne melding fra listen.
      meld = ListeMeldinger.get(0);
      ListeMeldinger.remove(0);
      antallMeldinger --;
      ikkeFullMonitor.signalAll(); //Sier fra at det er plass til flere meldinger.
    }
    finally {monitorlas.unlock();}
    return meld;
  }
}
