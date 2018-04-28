public class Kryptograf implements Runnable{
  private Monitor kryptertMonitor;
  private Monitor dekryptertMonitor;
  private final int ANTALL =5;
  private int dekryptert = 0;

  Kryptograf(Monitor kryptertMonitor, Monitor dekryptertMonitor){
    this.kryptertMonitor = kryptertMonitor;
    this.dekryptertMonitor = dekryptertMonitor;
  }

  @Override
  public void run(){
    try{
      this.kryptertMonitor.henteUtMelding();

    } catch (InterruptedException e){
      System.out.println("Stopp 1"); //For aa vite hvor det stopper.
    }
  }
}
