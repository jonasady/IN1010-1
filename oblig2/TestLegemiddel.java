class TestLegemiddel{
  public static void main(String[] args){
    LegemiddelA LMA = new LegemiddelA("Kokain",1000.00,50.00,6);
    LegemiddelB LMB = new LegemiddelB("Vicodin",299.00,60.00,5);
    LegemiddelC LMC = new LegemiddelC("Ibux",199.00,500.00);

    /*Tester Legemiddel A:*/
    LMA.skrivUtInfo();
    LMA.settNyPris(500.00);/*Setter ny pris til 500.00*/
    LMA.skrivUtInfo();

    /*Tester Legemiddel B:*/
    LMB.skrivUtInfo();
    LMB.settNyPris(400.00); /*Setter ny pris til 400.00*/
    LMB.skrivUtInfo();

    /*Tester Legemiddel C:*/
    LMC.skrivUtInfo();
    LMC.settNyPris(300.00); /*Setter ny pris til 300.00*/
    LMC.skrivUtInfo();

  }
}
