abstract class Resept{
  static int countID=0;
  int id;
  Legemiddel refLegemiddel;
  Lege refLege;
  int idPasient;
  int reit;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    this.refLegemiddel = legemiddel;
    this.refLege = utskrivendeLege;
    this.idPasient = pasientId;
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
    return refLege.henteNavn();
  }

  public int hentPasientId(){
    return this.idPasient;
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
