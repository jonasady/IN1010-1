class Stabel<T> extends Lenkeliste<T>{
  public Stabel(){
    super();
  }

  public void leggPaa(T x){
    this.leggTil(x);
  }

  public T taAv(){
    int lengde = this.stoerrelse();
    return fjern(lengde-1); /*Posisjon er lengde-1*/
  }
}
