class Pasient{
  String navn;
  String fodselsnr;
  int id;
  Liste<Resept> reseptliste = new Stabel<Resept>();

  public Pasient(String navn, String fodselsnr){
    this.navn = navn;
    this.fodselsnr = fodselsnr;
  }

  public int hentID(){
    return this.id;
  }

  public void leggPaa(Resept x){
    this.reseptliste.leggTil(x);
  }

  public Liste hentUt(){
    return this.reseptliste;
  }
}
