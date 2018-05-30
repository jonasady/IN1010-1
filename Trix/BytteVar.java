public class BytteVar{
  public static void variabelBytte(int a, int b) {
      int temp = a;
      a = b;
      b = temp;
  }

    public static void main(String[] args) {
      int x = 3;
      int y = 4;
      variabelBytte(x, y);
      System.out.println(x + " " +y);
  }

}
//Metodene maa inn i BytteVar-klassen.
//Variablene i variabelBytte er kun kopier av variablene, ikke de faktiske variablene.
