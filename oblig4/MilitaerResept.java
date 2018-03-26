class MilitaerResept extends HvitResept{
  public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }
  public double prisAaBetale(){ /*Skal vaere gratis.*/
    return 0.00;
  }
}
