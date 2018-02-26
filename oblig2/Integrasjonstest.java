class Integrasjonstest{
  public static void main(String[] args){
    /*Lager en instans av hver klasse for legemiddel*/
    LegemiddelA LMA = new LegemiddelA("Kokain",1000.00,50.00,6);
    LegemiddelB LMB = new LegemiddelB("Vicodin",299.00,60.00,5);
    LegemiddelC LMC = new LegemiddelC("Ibux",199.00,500.00);

    /*Lager en instans av hver klasse for lege*/
    Lege L1 = new Lege("BLA BLA");
    Fastlege L2 = new Fastlege("HE HE",42);

    /*Lager en instans av hver klasse for resept*/
    BlaaResept BR1 = new BlaaResept(LMA,L1,9090,10); /*Denne refererer til ikke-fastlege*/
    MilitaerResept MR1 = new MilitaerResept(LMA,L2,9090,10);
    PResept PR1 = new PResept(LMA,L2,9090);

    /*Skriver ut ID, navn, pris, virkestoff og narkotisk styrke for legemiddel A*/
    LMA.skrivUtInfo();

    /*Skriver ut ID, navn, pris, virkestoff og vanedannende styrke for legemiddel B*/
    LMB.skrivUtInfo();

    /*Skriver ut ID, navn, pris, virkestoff og narkotisk styrke for legemiddel A*/
    LMC.skrivUtInfo();

    /*Skriver ut info om legene*/
    System.out.println("\nNavn, lege 1: "+L1.henteNavn());
    System.out.println("Navn, lege 2: "+L2.henteNavn());
    System.out.println("Avtalenummer: "+L2.hentAvtalenummer());
    /*System.out.println("Avtalenummer: "+L1.hentAvtalenummer()); Denne gaar ikke, siden L1 ikke er fastlege.*/

    /*Skriver ut info om reseptene. En litt annen loesning enn over.*/
    Resept[] resepter = {BR1,MR1,PR1};
    for (Resept item : resepter){
      System.out.println("\nResept-ID: "+item.hentId());
      System.out.println("Resept, legemiddel: "+item.hentLegemiddel());
      System.out.println("Resept, utskrivende lege: "+item.hentLege());
      System.out.println("Resept, pasient-ID: "+item.hentPasientId());
      System.out.println("Antall gjenvaerende ganger: "+item.hentReit());
      if ((item instanceof BlaaResept) || (item instanceof HvitResept)){
        System.out.println("Resept, fargeklasse: "+item.farge());
        System.out.println("Pris for legemiddel: "+item.prisAaBetale());
        /*Skrive dette inn i klassen?? Som egen metode.*/
      }
    }
  }
}
