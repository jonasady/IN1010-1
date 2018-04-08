abstract class Rute{
  int coor_rad = null;
  int coor_kol = null;
  public Labyrint ref_labyrint = new Labyrint(null);
  public Rute ref_nord = new Rute(null);
  public Rute ref_syd = new Rute(null);
  public Rute ref_vest = new Rute(null);
  public Rute ref_ost = new Rute(null);

  public Rute(){

  }

  public Rute(int rad, int kol, Labyrint lab){
    this.coor_rad = rad;
    this.coor_kol = kol;
    this.ref_labyrint = lab;
  }


  abstract public char tilTegn(); /*Returnerer . eller #*/
}
