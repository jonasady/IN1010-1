class Lege implements Comparable<Lege>{
  String navn;
  int antNark = 0;
  Lenkeliste<Resept> utskrevneResepter = new Lenkeliste<Resept>();

  public Lege(String navn){
    this.navn = navn;
  }

  public String hentNavn(){
    return this.navn;
  }

  @Override
  public int compareTo(Lege annenLege){
    return (this.navn.compareTo(annenLege.hentNavn()));
  }

  public void skrivResept(Resept x){
    this.utskrevneResepter.leggTil(x);
    if (x.hentHeleLegemiddel() instanceof LegemiddelA){
      antNark++;
    }
  }

  public Lenkeliste<Resept> hentUtskrevneResepter(){
    return this.utskrevneResepter;
  }

  public int hentAntNarkResepter(){
    return antNark;
  }
}
