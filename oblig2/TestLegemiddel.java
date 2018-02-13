class TestLegemiddel{
  public static void main(String[] args){
    /*Legemiddel LM = new Legemiddel("Paracet",99.00,"Paracetamol");*/
    LegemiddelA LMA = new LegemiddelA("Kokain",1000.00,50.00,6);
    LegemiddelB LMB = new LegemiddelB("Vicodin",299.00,60.00,5);
    LegemiddelC LMC = new LegemiddelC("Ibux",199.00,500.00);

    /*Tester Legemiddel A:*/
    System.out.println(LMA.hentId()); /*Forventer 1*/
    System.out.println(LMA.hentNavn()); /*Forventer Kokain*/
    System.out.println(LMA.hentPris()); /*Forventer 1000.00*/
    System.out.println(LMA.hentVirkestoff()); /*Forventer 50.00*/
    LMA.settNyPris(500.00); /*Setter ny pris til 500.00*/
    System.out.println(LMA.hentPris()); /*Forventer 500.00*/
    System.out.println(LMA.hentNarkotiskStyrke()); /*Forventer 6*/

    /*Tester Legemiddel B:*/
    System.out.println(LMB.hentId()); /*Forventer 2*/
    System.out.println(LMB.hentNavn()); /*Forventer Vicodin*/
    System.out.println(LMB.hentPris()); /*Forventer 299.00*/
    System.out.println(LMB.hentVirkestoff()); /*Forventer 60.00*/
    LMB.settNyPris(400.00); /*Setter ny pris til 400.00*/
    System.out.println(LMB.hentPris()); /*Forventer 400.00*/
    System.out.println(LMB.hentVanedannendeStyrke()); /*Forventer 5*/

    /*Tester Legemiddel C:*/
    System.out.println(LMC.hentId()); /*Forventer 3*/
    System.out.println(LMC.hentNavn()); /*Forventer Ibux*/
    System.out.println(LMC.hentPris()); /*Forventer 199.00*/
    System.out.println(LMC.hentVirkestoff()); /*Forventer 60.00*/
    LMC.settNyPris(300.00); /*Setter ny pris til 300.00*/
    System.out.println(LMC.hentPris()); /*Forventer 300.00*/

  }
}
