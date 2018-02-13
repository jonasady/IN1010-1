class LegemiddelB extends Legemiddel{
  int styrke;
  public LegemiddelB(String navn, double startpris, double virkestoff, int styrke){
    super(navn,startpris,virkestoff);
    this.styrke=styrke;
  }

  public int hentVanedannendeStyrke(){
    return styrke;
  }
}
