public class Bil{
  private String eier;
  private String merke;

  Bil(String eier, String merke){
    this.eier = eier;
    this.merke = merke;
  }

  public String getEier(){ //Skriver ut og returnerer.
    System.out.println(this.eier);
    return this.eier;
  }

  public String getMerke(){ //Skriver ut og returnerer.
    System.out.println(this.merke);
    return this.merke;
  }

  public static void main(String[] args){
    Bil bil1 = new Bil("Eirin", "Skoda");
    Bil bil2 = new Bil("Geir", "Volvo");

    bil1.getEier();
    bil1.getMerke();
  }

}
