public class VisScore{

  public static void main(String[] args){
    Student joakim = new Student("Joakim",0,0);
    Student kristin = new Student("Kristin",0,0);
    Student dag = new Student("Dag",0,0);

    joakim.leggTilQuizScore(92);
    joakim.leggTilQuizScore(89);
    joakim.leggTilQuizScore(57);
    kristin.leggTilQuizScore(75);
    kristin.leggTilQuizScore(80);
    kristin.leggTilQuizScore(57);
    dag.leggTilQuizScore(95);
    dag.leggTilQuizScore(55);
    dag.leggTilQuizScore(35);

    System.out.println("Joakim sin totale score: "+joakim.hentTotalScore());
    System.out.println("Kristin sin totale score: "+kristin.hentTotalScore());
    System.out.println("Dag sin totale score: "+dag.hentTotalScore());
    System.out.println("Joakim sin gjennomsnitlige score: "+joakim.hentGjennomsnittligScore());
    System.out.println("Joakim sin gjennomsnitlige score: "+kristin.hentGjennomsnittligScore());
    System.out.println("Dag sin gjennomsnitlige score: "+dag.hentGjennomsnittligScore());

  }
}
