import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hoved{
  private Lock monitorlas;
  private Condition ikkeTomMonitor;
  private Condition ikkeFullMonitor;
  Hoved(String[] args){
    monitorlas = new ReentrantLock();
    ikkeTomMonitor = monitorlas.newCondition();
    ikkeFullMonitor = monitorlas.newCondition();
    int antall = Integer.parseInt(args[0]);
    Monitor monitorKryptert = new Monitor();
    Monitor monitorDekryptert = new Monitor();
  }
  Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
  Kanal [] kanaler = ops.hentKanalArray();
}

public class Melding{
  String meld;
  int sekvens; //Nummeret som tilsvarer denne meldingen i rekka av meldinger.
  int id;
  Melding(String melding, int sekvens, int id){
    this.meld = melding;
    this.sekvens = sekvens;
    this.id = id;
  }
}

public class Telegrafist implements Runnable{
  int id;
  Telegrafist(int id){
    this.id = id;
  }
  int kanalLengde = kanaler[this.id].length();
  for (int i = 0; i < kanalLengde; i++){
    Melding meld = new Melding(kanaler[id].lytt(),i,this.id);
    monitorKryptert.settInnMelding(meld);
    //Legg til meld i monitor for krypterte meldinger.
  }
}

public class Kryptograf implements Runnable{

}

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
