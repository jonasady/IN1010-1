class Fastlege extends Lege implements Kommuneavtale{
  String navn;
  int avtalenummer;

  public Fastlege(String navn, int avtalenummer){
    super(navn);
    this.avtalenummer = avtalenummer;
  }

  public String henteNavn(){
    return this.navn;
  }

  @Override
    public int hentAvtalenummer(){
      return this.avtalenummer;
    }

}
