class LegemiddelA extends Legemiddel{

  int styrke;

  public LegemiddelA(String navn, Double startpris, String virkestoff){
    super(navn,startpris,virkestoff);
  }

  public int hentNarkotiskStyrke(){
    return styrke;
  }
}
