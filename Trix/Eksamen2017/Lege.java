class Lege extends Ansatt{
  int legeNummer;
  String spesialisering;

  Lege(String ansattID, String navn, int legeNummer, String spesial){
    this.ansattID = ansattID;
    this.navn = navn;
    this.legeNummer = legeNummer;
    this.spesialisering = spesial;
  }
}
