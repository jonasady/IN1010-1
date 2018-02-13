class Resept{
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
  }

  public int hentId(){
    return id;
  }

  public Legemiddel hentLegemiddel(){
    return refLegemiddel;
  }

  public Lege hentLege(){
    return refLege;
  }

  public int hentPasientId(){
    return idPasient;
  }

  public int hentReit(){
    return reit;
  }

  public boolean bruk(){
    if (reit>0){
      reit--;
      return True;
    }
    else{
      return False;
    }
  }

  abstract public String farge(){
    /*Returner reseptens farge, enten "hvit" eller "blaa"*/
  }

  abstract public double prisAaBetale(){
    /*Returnerer prisen pasienten maa betale.*/
  }
}
