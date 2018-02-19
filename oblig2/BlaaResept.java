class BlaaResept extends Resept{
  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }
  public String farge(){
    return "blaa";
  }
  public double prisAaBetale(){
    double fullPris=refLegemiddel.hentPris(); /*Skal ha 75% avslag.*/
    return 0.25*fullPris;
  }
}
