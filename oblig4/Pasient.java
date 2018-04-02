class Pasient{
  String navn;
  String fodselsnr;
  int id;
  int antNark;
  Lenkeliste<Resept> reseptliste = new Stabel<Resept>();

  public Pasient(String navn, String fodselsnr){
    this.navn = navn;
    this.fodselsnr = fodselsnr;
  }

  public int hentID(){
    return this.id;
  }

  public void leggPaa(Resept x){
    this.reseptliste.leggTil(x);
    if (x.hentHeleLegemiddel() instanceof LegemiddelA){
      antNark++;
    }
  }

  public Lenkeliste<Resept> hentUt(){
    return this.reseptliste;
  }

  public String hentNavn(){
    return this.navn;
  }

  public String hentFodselsnr(){
    return this.fodselsnr;
  }

  public int hentAntNarkResepter(){
    return antNark;
  }
}
