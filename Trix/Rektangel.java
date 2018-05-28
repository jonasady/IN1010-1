public class Rektangel{
  double l;
  double b;

  public Rektangel (double l, double b) {   // Konstruktoer
    this.l = l;
    this.b = b;
  }

  public void oekLengde (double okning) {    // Oek lengden som angitt
    this.l=this.l + okning;
  }

  public void oekBredde (double okning) {    // Oek bredden som angitt
    this.b=this.b + okning;
  }

  public double areal () {     // Beregn mitt areal
    return (this.b * this.l);
  }

  public double omkrets () {   // Beregn min omkrets
    return (this.b+this.l)*2;
  }

  public void redLengde (double reduksjon) {    // Oek lengden som angitt
    if (reduksjon>this.l){
      System.out.println("Reduksjonen er for stor.");
    } else{
      this.l = this.l - reduksjon;
    }
  }

  public void redBredde (double reduksjon) {    // Oek bredden som angitt
    if (reduksjon>this.b){
      System.out.println("Reduksjonen er for stor.");
    } else{
      this.b = this.b - reduksjon;
    }
  }
}
