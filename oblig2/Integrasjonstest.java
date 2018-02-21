class Integrasjonstest{
  public static void main(String[] args){
    /*Lager en instans av hver klasse for legemiddel*/
    LegemiddelA LMA = new LegemiddelA("Kokain",1000.00,50.00,6);
    LegemiddelB LMB = new LegemiddelB("Vicodin",299.00,60.00,5);
    LegemiddelC LMC = new LegemiddelC("Ibux",199.00,500.00);

    /*Lager en instans av hver klasse for resept*/
    BlaaResept BR1 = new BlaaResept(LMA,Lege1,9090,10);
    MilitaerResept MR1 = new MilitaerResept(LMA,Lege1,9090,10);
    PResept PR1 = new PResept(LMA,Lege1,9090);

    /*Lager en instans av hver klasse for lege*/
    Lege L1 = new Lege("BLA");
    Fastlege L2 = new Fastlege("Eirin Korvald");
  }
}
