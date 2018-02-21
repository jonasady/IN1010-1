class TestResepter{
  public static void main(String[] args){
    LegemiddelA LMA = new LegemiddelA("Kokain",1000.00,50.00,6);
    LegemiddelB LMB = new LegemiddelB("Vicodin",299.00,60.00,5);
    LegemiddelC LMC = new LegemiddelC("Ibux",199.00,500.00);

    Lege Lege1 = new Lege("Lege Eirin");

    /*Tester BlaaResept:*/
    BlaaResept BR1 = new BlaaResept(LMA,Lege1,9090,10);
    if (BR1.prisAaBetale() == 0.25*LMA.hentPris()){
      System.out.println("BR1, pris = riktig.");
    }
    else{
      System.out.println("BR1, pris = feil.");
    }
    assert (BR1.prisAaBetale() == (0.75*LMA.hentPris())) : "Noe er galt med prisen.";
    System.out.println(BR1.farge());
    System.out.println(BR1.prisAaBetale());

    /*Tester MilitaerResept:*/
    MilitaerResept MR1 = new MilitaerResept(LMA,Lege1,9090,10);

    System.out.println(MR1.farge());
    System.out.println(MR1.prisAaBetale());
    assert (MR1.prisAaBetale() == 0) : "Pris aa betale er feil";

    /*Tester P-Resept:*/
    PResept PR1 = new PResept(LMA,Lege1,9090);
    System.out.println(PR1.farge());
    System.out.println(PR1.prisAaBetale());
  }
}
