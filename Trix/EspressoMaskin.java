class EspressoMaskin {
  int vann = 0;
  // Lag espresso dersom det er nok vann
  public void lagEspresso() {
    if (this.vann >=40){
      System.out.println("En espresso lages.");
      this.vann = this.vann - 40;
    }
    else{
      System.out.println("Det er ikke nok vann. Fyll paa minst 40 ml vann.");
    }
  }

  // Lag lungo dersom det er nok vann
  public void lagLungo() {
    if (this.vann >=110){
      System.out.println("En lungo lages.");
      this.vann = this.vann - 110;
    }
    else{
      System.out.println("Det er ikke nok vann. Fyll paa minst 110 ml vann.");
    }
  }

  // Fyll på et gitt antall milliliter vann, dersom det er plass
  public void fyllVann(int ml) {
    this.vann = this.vann + ml;
  }

  // Les av målestrekene på vanntanken og tilgjengelig vann i ml
  public int hentVannmengde() {
    return this.vann;
  }

  public static void main(String[] args){
    EspressoMaskin maskin = new EspressoMaskin();
    int vannmengde = maskin.hentVannmengde();
    System.out.println("Menge vann i maskinen: "+vannmengde);

    maskin.fyllVann(200);
    maskin.lagLungo();
    maskin.lagLungo();
    maskin.lagEspresso();
    maskin.lagEspresso();
  }
}
