class Overlege extends Lege implements Administrator{
  String ansvarskode;


  Overlege(String ansattID, String navn, int legeNummer, String spesial){
    super(ansattID, navn, legeNummer, spesial);
    this.ansvarskode = "Ikke Administrator.";
  }

  //Hvis overlegen har admin-rettigheter skal denne brukes:
  Overlege(String ansattID, String navn, int legeNummer, String spesial, String ansvar){
    super(ansattID, navn, legeNummer, spesial);
    this.ansvarskode = ansvar;
  }

  @Override
  public String finnAnsvar(){
    return this.ansvarskode;
  }
}
