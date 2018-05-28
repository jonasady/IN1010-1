public class BeregnRektangel{
  public static void main(String[] args){
    Rektangel nummerEn = new Rektangel(4.0,5.0);
    Rektangel nummerTo = new Rektangel(10.0,9.0);
    System.out.println("Areal av rektangel 1: "+nummerEn.areal());
    System.out.println("Areal av rektangel 2: "+nummerTo.areal());
    nummerEn.oekBredde(5.0);
    nummerTo.oekLengde(6.0);
    nummerEn.redBredde(1.0);
    System.out.println("Omkrets av rektangel 1: "+nummerEn.omkrets());
    System.out.println("Omkrets av rektangel 2: "+nummerTo.omkrets());
  }
}
