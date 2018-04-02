abstract class Resept{
  static int countID=0;
  int id;
  Legemiddel refLegemiddel;
  Lege refLege;
  Pasient p;
  int reit;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int id, int reit){
    this.refLegemiddel = legemiddel;
    this.refLege = utskrivendeLege;
    this.id = id;
    this.reit = reit;
    this.countID++;
    this.id=countID;
  }

  public int hentId(){
    return this.id;
  }

  public String hentLegemiddel(){
    return refLegemiddel.hentNavn();
  }

  public String hentLege(){
    return refLege.hentNavn();
  }

  public Pasient hentPasientId(){
    return this.p;
  }

  public int hentReit(){
    return this.reit;
  }

  public boolean bruk(){/*Forsoker aa bruke resept? try-setn.?*/
    if (reit>0){
      reit--;
      return true;
    }
    else{
      return false;
    }
  }

  abstract public String farge();
  abstract public double prisAaBetale();
}
