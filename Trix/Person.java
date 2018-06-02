public class Person {
    String navn;
    int alder;

    Person(String n, int a){
      this.navn = n;
      this.alder = a;
    }

    public void giNavn(String n){
        navn = n;
    }

    public void giAlder(int a){
        alder = a;
    }
}
