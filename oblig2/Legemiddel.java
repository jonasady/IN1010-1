class Legemiddel{
  static int countID=0;
  int id;
  String navn;
  double pris;
  double virkestoff;

  public Legemiddel(String navn, double startpris, double virkestoff){
    this.navn = navn;
    this.pris = startpris;
    this.virkestoff = virkestoff;
    this.countID++;
    this.id=countID;
  }

  public int hentId(){
    return id;
  }

  public String hentNavn(){
    return navn;
  }

  public double hentPris(){
    return pris;
  }

  public double hentVirkestoff(){
    return virkestoff;
  }

  public void settNyPris(double pris){
    this.pris=pris;
  }
}
