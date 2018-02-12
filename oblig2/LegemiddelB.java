class LegemiddelB extends Legemiddel{

  public LegemiddelB(String navn, double startpris, String virkestoff){
    super(navn,startpris,virkestoff);
    this.countID++;
    this.id=countID;
  }

  int styrke;


  public int hentVanedannendeStyrke(){
    return styrke;
  }
}
