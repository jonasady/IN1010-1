class Lenkeliste<T> implements Liste<T>{
  private Node start;

  public class Node{
    T value;
    Node next;

    public Node(T x){
      this.value = x;
    }
  }

  @Override
  public void leggTil(T x){
    Node nyNode = new Node(x);
    nyNode.next = Node start;
    Node start = nyNode;
  }

  
}
