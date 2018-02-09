class TestLegemiddel{
  public static void main(){
    Legemiddel LM = new Legemiddel("Paracet",99.00,"Paracetamol");
    LegemiddelA LMA = new LegemiddelA("Kokain",10000.00,"Bensoylmethylekgonin");
    /*LegemiddelB LMB = new LegemiddelB("Vicodin",199.00,"Hydrocodone");
    LegemiddelC LMC = new LegemiddelB("Ibux",99.00,"Ibuprofen");*/

    /*Tester Legemiddel A:*/
    String navnet= LMA.hentNavn();
    Double prisA= LMA.hentPris();
    String virkA= LMA.hentVirkestoff();

    /*Tester Legemiddel B:*/

    /*Tester Legemiddel C:*/

  }
}
