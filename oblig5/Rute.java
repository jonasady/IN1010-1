abstract class Rute{
  int coor_rad = -1;
  int coor_kol = -1;
  public Labyrint ref_labyrint = null;
  public Rute ref_nord = null;
  public Rute ref_syd = null;
  public Rute ref_vest = null;
  public Rute ref_ost = null;
  public Rute r;
  public String vei = "";

  public Rute(int rad, int kol){
    this.coor_rad = rad;
    this.coor_kol = kol;
  }

  public void setLab(Labyrint lab){
    this.ref_labyrint = lab;
  }

  public void settNord(Rute nabo){
    this.ref_nord = nabo;
  }

  public void settSyd(Rute nabo){
    this.ref_syd = nabo;
  }

  public void settOst(Rute nabo){
    this.ref_ost = nabo;
  }

  public void settVest(Rute nabo){
    this.ref_vest = nabo;
  }

  abstract public char tilTegn(); //Returnerer . eller #

  public Rute hentNabo(char c){
    if (c == 'n'){
      this.r = this.ref_nord;
    } else if (c == 's'){
      this.r = this.ref_syd;
    } else if (c == 'o'){
      this.r = this.ref_ost;
    } else if (c == 'v'){
      this.r = this.ref_vest;
    }
    return this.r;
  }

  public void gaa(Rute forrige){
    this.vei = forrige.vei + ("(" + this.coor_kol + "," + this.coor_rad + ")");
    if (this.tilTegn()=='#'){
      return;
    } else if (this.erAapning() == true){
      this.ref_labyrint.utveier.leggTil(this.vei);
      return;
    } else {
      this.vei = this.vei + ("-->");
      if (this.ref_ost!=forrige){
        this.ref_ost.gaa(this);
      } if (this.ref_syd!=forrige){
        this.ref_syd.gaa(this);
      } if (this.ref_vest!=forrige){
        this.ref_vest.gaa(this);
      } if (this.ref_nord!=forrige){
        this.ref_nord.gaa(this);
      }
    }
  }

  abstract public boolean erAapning();

  public void finnUtvei(){
    this.gaa(this);
  }
}
