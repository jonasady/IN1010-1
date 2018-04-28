import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TestProgram{
  public static void main(String[] args){
    int antallTelegrafister = 3; //Kunne ogsaa satt dette til antall kanaler.
    Monitor kryptertMonitor = new Monitor();
    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal [] kanaler = ops.hentKanalArray();

    System.out.println(kanaler[0].hentId());
    System.out.println(kanaler[1].hentId());
    System.out.println(kanaler[2].hentId());

    Telegrafist telegrafist1 = new Telegrafist(kryptertMonitor,0,kanaler[0]);
    new Thread(telegrafist1).start();
    //Telegrafist telegrafist2 = new Telegrafist(kryptertMonitor,1,kanaler[1]);
    //new Thread(telegrafist2).start();
    //Telegrafist telegrafist3 = new Telegrafist(kryptertMonitor,2,kanaler[2]);
    //new Thread(telegrafist3).start();

    Monitor dekryptertMonitor = new Monitor();
    Kryptograf kryptograf1 = new Kryptograf(kryptertMonitor,dekryptertMonitor);
    new Thread(kryptograf1).start();
  }
}
