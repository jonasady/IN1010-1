import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class Monitor{
  private Lock monitorlas = new ReentrantLock();
  private Condition ikkeTomMonitor = monitorlas.newCondition();
  private Condition ikkeFullMonitor = monitorlas.newCondition();
  private int antallMeldinger = 0;
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
        this.antallNull++;
        return;
      }
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
        return null;
      }
      while (antallMeldinger == 0){ //Ikke mulig aa hente ut melding naar det ikke er noen.
        ikkeTomMonitor.await();
      }
      meld = ListeMeldinger.get(0);
      ListeMeldinger.remove(0);
      antallMeldinger --;
      ikkeFullMonitor.signalAll(); //Sier fra at det er plass til flere meldinger.
    }
    finally {monitorlas.unlock();}
    return meld;
  }
}
