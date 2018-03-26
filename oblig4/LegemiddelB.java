class LegemiddelB extends Legemiddel{
  int styrke; /*Vanedannende styrke*/

  public LegemiddelB(String navn, double startpris, double virkestoff, int styrke){
    super(navn,startpris,virkestoff);
    this.styrke=styrke;
  }

  public int hentVanedannendeStyrke(){
    return this.styrke;
  }
  @Override
  public void skrivUtInfo(){ /*Lager en metode for aa lettere hente ut info lagret om legemidlene.*/
    System.out.println("\nLegemiddelets ID: "+this.hentId());
    System.out.println("Legemiddelets navn: "+this.hentNavn());
    System.out.println("Legemiddelets pris [kr]: "+this.hentPris());
    System.out.println("Mengde virkestoff [mg] i legemiddelet: "+this.hentVirkestoff());
    System.out.println("Legemiddelets vanedannende styrke: "+this.hentVanedannendeStyrke());
  }
}
