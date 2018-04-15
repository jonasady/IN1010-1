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
  public Liste<String> utveier;

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

  public boolean gaa(Rute forrige){
    if (this.tilTegn()=='#'){
      return false;
    } else if (this.erAapning() == true){
      this.vei = this.vei.concat("(" + this.coor_kol + "," + this.coor_rad + ")");
      System.out.println("(" + this.coor_kol + "," + this.coor_rad + ")");
      return true;
    } else {
      if ((this.ref_ost!=forrige) && (this.ref_ost.gaa(this)==true)){
        this.vei = this.vei.concat("(" + this.coor_kol + "," + this.coor_rad + ")");
        System.out.println("(" + this.coor_kol + "," + this.coor_rad + ")");
        return true;
      } else if ((this.ref_syd!=forrige) && (this.ref_syd.gaa(this)==true)){
        this.vei = this.vei.concat("(" + this.coor_kol + "," + this.coor_rad + ")");
        System.out.println("(" + this.coor_kol + "," + this.coor_rad + ")");
        return true;
      } else if ((this.ref_vest!=forrige) && (this.ref_vest.gaa(this)==true)){
        this.vei = this.vei.concat("(" + this.coor_kol + "," + this.coor_rad + ")");
        System.out.println("(" + this.coor_kol + "," + this.coor_rad + ")");
        return true;
      } else if ((this.ref_nord!=forrige) && (this.ref_nord.gaa(this)==true)){
        this.vei = this.vei.concat("(" + this.coor_kol + "," + this.coor_rad + ")");
        System.out.println("(" + this.coor_kol + "," + this.coor_rad + ")");
        return true;
      } else {
        return false;
      }
    }
  }

  abstract public boolean erAapning();

  public void finnUtvei(){
    this.gaa(this);
    this.vei=this.vei.substring(0,this.vei.length()-5); //For aa fjerne starten.Fjerne linjeskift?
    System.out.println(this.vei);
  }

  public Liste<String> finnUtveiFra(int kol, int rad){
    String utvei = this.ref_labyrint.getLab().get(rad).get(kol).finnUtvei();
    this.utveier.leggTil(utvei);
  }

}
