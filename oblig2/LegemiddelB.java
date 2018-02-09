class LegemiddelB extends Legemiddel{
  public Legemiddel(String navn, Double startpris, String virkestoff){
    navn = navn;
    pris = startpris;
    virkestoff = virkestoff;
  }
  
  int styrke;


  public int hentVanedannendeStyrke(){
    return styrke;
  }
}
