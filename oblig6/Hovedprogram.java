import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Hovedprogram{
  public static void main(String[] args){
    int antallTelegrafister = 3; //Kunne ogsaa satt dette til antall kanaler.
    int antallKryptografer = 3;
    Monitor kryptertMonitor = new Monitor(antallTelegrafister);
    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal [] kanaler = ops.hentKanalArray();

    Telegrafist telegrafist1 = new Telegrafist(kryptertMonitor,0,kanaler[0]);
    new Thread(telegrafist1).start();
    Telegrafist telegrafist2 = new Telegrafist(kryptertMonitor,1,kanaler[1]);
    new Thread(telegrafist2).start();
    Telegrafist telegrafist3 = new Telegrafist(kryptertMonitor,2,kanaler[2]);
    new Thread(telegrafist3).start();

    Monitor dekryptertMonitor = new Monitor(antallKryptografer);
    Kryptograf kryptograf1 = new Kryptograf(kryptertMonitor,dekryptertMonitor);
    new Thread(kryptograf1).start();
    Kryptograf kryptograf2 = new Kryptograf(kryptertMonitor,dekryptertMonitor);
    new Thread(kryptograf2).start();
    Kryptograf kryptograf3 = new Kryptograf(kryptertMonitor,dekryptertMonitor);
    new Thread(kryptograf3).start();
    Operasjonsleder operasjonsleder = new Operasjonsleder(dekryptertMonitor);
    new Thread(operasjonsleder).start();
  }
}
