class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{
  public SortertLenkeliste(){
    super();
  }

  @Override
  public void leggTil(T x){
    if (start.neste == null){ /*Sjekker om lista er tom.*/
      start.neste = new Node(x);
      System.out.println(start.neste.data);
    }
    else{
      Node p = start;

      while (p.neste != null && p.neste.data.compareTo(x)<0){
        p = p.neste;
      } //p er stoerre eller lik x.

      Node ny = new Node(x);
      if (p.neste != null){
        ny.neste = p.neste;
      }
      p.neste = ny;
    }
  }

  @Override
    public T fjern(){
      int lengde = this.stoerrelse();
      return fjern(lengde-1); /*Posisjon er lengde-1*/
    }

  @Override
    public void leggTil(int pos, T x){
      throw new UnsupportedOperationException("Denne kan ikke brukes.");
    }

  @Override
  public void sett(int pos, T x){
      throw new UnsupportedOperationException("Denne kan ikke brukes.");
    }
}
