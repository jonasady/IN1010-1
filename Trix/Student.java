public class Student{
  String navn;
  int totScore;
  int antQuizer;

  public Student(String navn, int totScore, int antQuizer){
    this.navn = navn;
    this.totScore = totScore;
    this.antQuizer = antQuizer;
  }

  public String getName(){
    return this.navn;
  }

  public void leggTilQuizScore(int Score){
    this.totScore = this.totScore + Score;
    this.antQuizer++;
  }

  public int hentTotalScore(){
    return this.totScore;
  }

  public double hentGjennomsnittligScore(){
    double gjSnitt = ((double)this.totScore/this.antQuizer);
    return gjSnitt;
  }
}
