class BlaaResept extends Resept{
  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }
  public String tilTegn(){
    return "blaa";
  }
}
