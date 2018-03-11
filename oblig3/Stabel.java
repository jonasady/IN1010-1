class Stabel<T> extends Lenkeliste<T>{
  public Stabel(){
    super()
  }

  public void leggPaa(T x){
    this.leggTil(x);
  }

  public T taAv(){
    lengde = this.stoerrelse();
    fjern(lengde);
  }

}
