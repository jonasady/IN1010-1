class Legemiddel{
  int id;
  String navn;
  Double pris;
  String virkestoff;

  public Legemiddel(String navn, Double startpris, String virkestoff){
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

  public Double hentPris(){
    return pris;
  }

  public String hentVirkestoff(){
    return virkestoff;
  }

  public void settNyPris(Double pris){

  }
}
