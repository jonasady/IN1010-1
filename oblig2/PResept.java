class PResept extends HvitResept{
  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
    super(legemiddel, utskrivendeLege, pasientId, 3);
  }
  public double prisAaBetale(){
    double fullPris=refLegemiddel.hentPris(); /*Skal ha 116 kr i avslag.*/
    if (fullPris<=116.00){
      return 0.00;
    }
    else{
      return (fullPris-116.00);
    }
  }
}
