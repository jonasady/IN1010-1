class Integrasjonstest{
  public static void main(String[] args){
    /*Lager en instans av hver klasse for legemiddel*/
    Legemiddel LM = new Legemiddel("Paracet",199.00,500.00);
    LegemiddelA LMA = new LegemiddelA("Kokain",1000.00,50.00,6);
    LegemiddelB LMB = new LegemiddelB("Vicodin",299.00,60.00,5);
    LegemiddelC LMC = new LegemiddelC("Ibux",199.00,500.00);

    /*Lager en instans av hver klasse for lege*/
    Lege L1 = new Lege("BLA BLA");
    Fastlege L2 = new Fastlege("Eirin Korvald",42);

    /*Lager en instans av hver klasse for resept*/
    BlaaResept BR1 = new BlaaResept(LMA,L1,9090,10); /*Denne refererer til ikke-fastlege*/
    MilitaerResept MR1 = new MilitaerResept(LMA,L2,9090,10);
    PResept PR1 = new PResept(LMA,L2,9090);

    /*Skriver ut ID, navn, pris og virkestoff for superklassen av legemidlene.*/
    System.out.println("ID for legemiddel i superklassen: "+LM.hentId());
    System.out.println("Navn legemiddel: "+LM.hentNavn());
    System.out.println("Pris legemiddel: "+LM.hentPris());
    System.out.println("Virkestoff legemiddel [mg]: "+LM.hentVirkestoff());

    /*Skriver ut ID, navn, pris, virkestoff og narkotisk styrke for legemiddel A*/
    System.out.println("ID for legemiddel A: "+LMA.hentId());
    System.out.println("Navn legemiddel: "+LMA.hentNavn());
    System.out.println("Pris legemiddel: "+LMA.hentPris());
    System.out.println("Virkestoff legemiddel [mg]: "+LMA.hentVirkestoff());
    System.out.println("Narkotisk styrke: "+LMA.hentNarkotiskStyrke());

    /*Skriver ut ID, navn, pris, virkestoff og vanedannende styrke for legemiddel B*/
    System.out.println("ID for legemiddel B: "+LMB.hentId());
    System.out.println("Navn legemiddel: "+LMB.hentNavn());
    System.out.println("Pris legemiddel: "+LMB.hentPris());
    System.out.println("Virkestoff legemiddel [mg]: "+LMB.hentVirkestoff());
    System.out.println("Vanedannende styrke: "+LMB.hentVanedannendeStyrke());

    /*Skriver ut ID, navn, pris, virkestoff og narkotisk styrke for legemiddel A*/
    System.out.println("ID for legemiddel C: "+LMC.hentId());
    System.out.println("Navn legemiddel: "+LMC.hentNavn());
    System.out.println("Pris legemiddel: "+LMC.hentPris());
    System.out.println("Virkestoff legemiddel [mg]: "+LMC.hentVirkestoff());

    /*Skriver ut info om legene*/
    System.out.println("Navn, lege 1: "+L1.henteNavn());
    System.out.println("Navn, lege 2: "+L2.henteNavn());
    System.out.println("Navn legemiddel: "+L2.hentAvtalenummer());

    /*Skriver ut info om reseptene*/
    Resept[] resepter = {BR1,MR1,PR1};
    for (Resept item : resepter){
      System.out.println("Resept-ID: "+item.hentId());
      System.out.println("Resept-ID: "+item.hentLegemiddel());
      System.out.println("Resept-ID: "+item.hentLege());
      System.out.println("Resept-ID: "+item.hentPasientId());
      System.out.println("Resept-ID: "+item.hentReit());
      if (item instanceof BlaaResept){
        System.out.println("Resept-ID: "+item.farge());
        System.out.println("Resept-ID: "+item.prisAaBetale());
      }
      else if (item instanceof PResept){}
      else if (item instanceof MilitaerResept){}
    }
  }
}
