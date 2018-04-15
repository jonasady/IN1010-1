class Lenkeliste<T> implements Liste<T>{
  public class Node{
    Node neste = null;
    T data;

    Node(T x){ /*Nodens konstruktoer*/
      this.data = x;
    }
  }
  public Node start = new Node(null);

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
    if (start.neste==null){
      throw new UgyldigListeIndeks(-1);
    }
    else{
      Node p = start.neste;
      start.neste = p.neste;
      return p.data;
    }
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
    p.neste.data = x;
  }

  @Override
  public void leggTil(int pos, T x){
    if (pos<0 || pos > this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    if (pos==0){
      Node p = new Node(x);
      p.neste = start.neste;
      start.neste = p;
    }
    else{
      Node p = start;
      for (int i = 0; i < pos; i++){
        p = p.neste;
      }
      Node ny = new Node(x);
      ny.neste=p.neste;
      p.neste=ny;
    }
  }

  @Override
  public T fjern(int pos){
    if (pos<0 || pos>=this.stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node p = start;
    for (int i = 0; i < pos; i++){
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
