class Legemiddel{
  int id;
  String navn;
  double pris;
  String virkestoff;

  public Legemiddel(String navn, double startpris, String virkestoff){
    navn = navn;
    pris = startpris;
    virkestoff = virkestoff;
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

  public String hentVirkestoff(){
    return virkestoff;
  }

  public void settNyPris(double pris){

  }
}
