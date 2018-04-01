import java.util.Scanner;

public class Legesystem{
  public void vis_meny(){
    System.out.println("Du har seks valgmuligheter:\n1. Skriv ut fullstendig oversikt over personer, leger, legemidler og resepter.\n2. Opprett og legg til nye elementer i systemet.\n3. Bruk en gitt resept fra listen til en pasient.\n4. Skriv ut forskjellige former for statistikk.\n5. Skriv all data til fil.\n6. Avslutt valgmenyen.\n");
    System.out.print("Skriv hvilket nummer du velger: ");
  }

  public Legesystem(){
    Scanner input = new Scanner (System.in);
    vis_meny();
    /*switch (in.nextInt()){
      case 1:
        System.out.println("Du har valgt 1");
        break;
      case 2:
        System.out.println("Du har valgt 2");
        break;
      case 3:
        System.out.println("Du har valgt 3");
        break;
      case 4:
        System.out.println("Du har valgt 4");
        break;
      case 5:
        System.out.println("Du har valgt 5");
        break;
      case 6:
        System.out.println("Du har valgt 6");
        break;
    }*/
  }

  public static void main(String[] args){
  }
}
