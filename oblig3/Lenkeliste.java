class Lenkeliste<T> implements Liste<T>{
  private class Node{
    Node neste = null;
    T data;

    Node(T x){ /*Nodens konstruktoer*/
      T data = x;
    }
  }
  private Node start = null;

  @Override
  public int stoerrelse(){
    Node p = start;
    int n = 0;
    while (p != null){
      n++;
      p = p.neste;
    }
    return n;
  } /*Kan lage en egen variabel for stoerrelse.*/


  @Override /*Foerst inn, foerst ut = queue.*/
  public void leggTil(T x){
    if (start == null){ /*Sjekker om lista er tom.*/
      start.neste = new Node(x);
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
  public T hent(int pos){
    Node p = start;
    for (int i = 0; i < pos; i++){
      Node p = p.neste;
    }
    return
  }


  @Override
  public T fjern(int pos){

  }

  @Override
  public T fjern(){

  }
}
