abstract class Rute{
  int coor_rad = -1;
  int coor_kol = -1;
  public Labyrint ref_labyrint = null;
  public Rute ref_nord = null;
  public Rute ref_syd = null;
  public Rute ref_vest = null;
  public Rute ref_ost = null;
  public Rute r;

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

  abstract public char tilTegn(); /*Returnerer . eller #*/

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

  public void gaa(){

  }

  public void finnUtvei(){

  }

  public Liste<String> finnUtveiFra(int kol, int rad){
    
  }

}
