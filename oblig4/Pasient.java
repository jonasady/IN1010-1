class Pasient{
  String navn;
  String fodselsnr;
  int id;
  Liste<Resept> reseptliste = new Stabel<Resept>();

  public Pasient(String navn, String fodselsnr){
    this.navn = navn;
    this.fodselsnr = fodselsnr;
  }

  public void leggPaa(Resept x){
    this.reseptliste.leggTil(x);
  }

  public Resept hentUt(){
    /*Skal hente ut hele reseptlisten.*/
  }
}
