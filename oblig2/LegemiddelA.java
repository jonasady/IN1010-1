class LegemiddelA extends Legemiddel{
  int styrke;

  public LegemiddelA(String navn, double startpris, String virkestoff){
    super(navn,startpris,virkestoff);
  }

  public void setNarkotiskStyrke(int styrke){
    this.styrke=styrke;
  }

  public int hentNarkotiskStyrke(){
    return styrke;
  }
}
