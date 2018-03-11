class Lenkeliste<T> implements Liste<T>{
  private class Node{
    Node neste = null;
    T data;

    Node(T x){ /*Nodens konstruktoer*/
      this.data = x;
    }
  }
  private Node start = new Node(null);

  @Override /*Foerst inn, foerst ut = queue.*/
  public void leggTil(T x){
    if (start.neste == null){ /*Sjekker om lista er tom.*/
      start.neste = new Node(x);
      System.out.println(start.neste.data);
    }
    else{
      Node p = start;
      while (p.neste != null){ /*Finner siste sted i lista.*/
        p = p.neste;
      }
      p.neste = new Node(x);
    }
  }

  @Override
  public T fjern(){
    Node p = start.neste;
    start.neste = p.neste; /*Ikke lenger noen peker til foerste i lista.*/
    return p.data; /*Er det p.data de vil ha tak i eller bare p?*/
  }

  @Override
  public void sett(int pos, T x){
    if (pos<0 || pos>=this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node p = start;
    for (int i = 0; i < pos; i++){
      p = p.neste;
    }
    p.data = x;
  }

  @Override
  public void leggTil(int pos, T x){
    if (pos<0 || pos>=this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    if (start == null){
      start.neste = new Node(x);
    }
    Node p = start;
    for (int i = 1; i < pos; i++){ /*Teller til elementet foer pos.*/
      p = p.neste;
    }
    Node foerst = p; /*For aa ta vare paa peker til elementet etter.*/
    p.neste = new Node(x);
    Node nyeste = p.neste;
    nyeste.neste = foerst.neste;
  }

  @Override
  public T fjern(int pos){
    if (pos<0 || pos>this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node p = start;
    for (int i = 1; i < pos; i++){
      p = p.neste;
    }
    Node fjernes = p.neste;
    p.neste = fjernes.neste;
    return fjernes.data;
  }

  @Override
  public int stoerrelse(){
    Node p = start;
    int n = 0;
    while (p.neste != null){
      n++;
      p = p.neste;
    }
    return n;
  } /*Kan lage en egen variabel for stoerrelse.*/

  @Override
  public T hent(int pos){
    if (pos<0 || pos>=this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node p = start.neste;
    for (int i = 0; i < pos; i++){
      p = p.neste;
    }
    return p.data;
  }

}
