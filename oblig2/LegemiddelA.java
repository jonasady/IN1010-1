class LegemiddelA extends Legemiddel{
  int styrke;

  public LegemiddelA(String navn, double startpris, double virkestoff, int styrke){
    super(navn,startpris,virkestoff);
    this.styrke=styrke;
  }

  public int hentNarkotiskStyrke(){
    return styrke;
  }
}
