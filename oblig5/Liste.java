interface Liste<T>/* extends Iterable<T>*/{
  public abstract int stoerrelse();
  public abstract void leggTil(int pos, T x);
  public abstract void leggTil(T x);
  public abstract void sett(int pos, T x);
  public abstract T hent(int pos);
  public abstract T fjern(int pos);
  public abstract T fjern();
}
