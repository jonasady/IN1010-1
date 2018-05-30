public class Utskrift{
  public static void utskrift(String tekst){
    System.out.println(tekst);
  }

  public static void utskrift(int tall){
    System.out.println(tall);
  }

  public static void utskrift(int tall1, int tall2){
    System.out.println(tall1+tall2);
  }

  public static void main(String[] args){
    Utskrift utskrift = new Utskrift();
    utskrift.utskrift(5);
    utskrift.utskrift("Hei");
    utskrift.utskrift(5,2);
  }
}
