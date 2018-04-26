import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor{
  private int antallMeldinger = 0;
  private final int MONITOR_KAPASITET = 5; //Kanskje et annet tall??

  void settInnMelding(Melding meld) throws InterruptedException{
    monitorlas.lock();
    try {
      while (antallMeldinger >= MONITOR_KAPASITET){
        ikkeFullMonitor.await(); //Venter paa at monitor ikke skal vaere full.
      } //Naa er antallMeldinger < MONITOR_KAPASITET
      //Legg til i listen over meldinger.
      antallMeldinger++;
      System.out.println("Antall meldinger: " + antallMeldinger);
      ikkeTomMonitor.signal(); //Sier fra til operatoer.
    }
    finally {monitorlas.unlock();}
  }

  void henteUtMelding() throws InterruptedException{
    monitorlas.lock();
    try {
      while (antallMeldinger == 0){ //Ikke mulig aa hente ut melding naar det ikke er noen.
        ikkeTomMonitor.await();
      } //antallMeldinger > 0
      //Maa fjerne melding fra listen.
      antallMeldinger --;
      ikkeFullMonitor.signal(); //Sier fra at det er plass til flere meldinger.
    }
    finally {monitorlas.unlock();}
  }
}
