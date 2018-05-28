import java.util.Scanner;

public class SkattIRuritania{
  public static void main(String[] args){
    System.out.println("Skriv inn inntekten din: ");
    Scanner sc = new Scanner(System.in);
    double inntekt = sc.nextDouble();
    double skatt;
    if (inntekt < 10000){
      skatt = inntekt*0.1;
    } else {
      skatt = ((inntekt-10000)*0.3) + 1000;
    }
    System.out.println("Du skal betale "+skatt+" kroner i skatt.");
  }
}
