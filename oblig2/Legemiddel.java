abstract class Legemiddel{
  static int countID=0;
  int id;
  String navn;
  double pris;
  double virkestoff; /*I [mg]*/

  public Legemiddel(String navn, double startpris, double virkestoff){
    this.navn = navn;
    this.pris = startpris;
    this.virkestoff = virkestoff;
    this.countID++;
    this.id=countID;
  }

  public int hentId(){
    return this.id;
  }

  public String hentNavn(){
    return this.navn;
  }

  public double hentPris(){
    return this.pris;
  }

  public double hentVirkestoff(){
    return this.virkestoff;
  }

  public void settNyPris(double pris){
    this.pris=pris;
  }

  public void skrivUtInfo(){ /*Lager en metode for aa lettere hente ut info lagret om legemidlene.*/
    System.out.println("\nLegemiddelets ID: "+this.hentId());
    System.out.println("Legemiddelets navn: "+this.hentNavn());
    System.out.println("Legemiddelets pris [kr]: "+this.hentPris());
    System.out.println("Mengde virkestoff [mg] i legemiddelet: "+this.hentVirkestoff());
  }
}
