public class Melding implements Comparable<Melding>{
  String meld;
  int sekvens; //Nummeret som tilsvarer denne meldingen i rekka av meldinger.
  int id; //Kanalen den kommer fra.
  Melding(String melding, int sekvens, int id){
    this.meld = melding;
    this.sekvens = sekvens;
    this.id = id;
  }

  public String getMelding(){
    return this.meld;
  }

  public void settMelding(String meld){
    this.meld = meld;
  }

  public int getSekvens(){
    return this.sekvens;
  }

  public int getID(){
    return this.id;
  }

  @Override
  public int compareTo(Melding sammenlign){
    return (this.getSekvens() - sammenlign.getSekvens());
  }
}
