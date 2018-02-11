import java.util.ArrayList;

public class Rack{
  private int antallProsessorer;
  private ArrayList<Node> listNodes=new ArrayList<Node>(0);

  public void settInn(int minnestorrelse, int antNyeProsessorer){
    Node newNode = new Node();
    newNode.setMinneStr(minnestorrelse);
    newNode.setPros_ant(antNyeProsessorer);
    listNodes.add(newNode);
    antallProsessorer+=antNyeProsessorer;
  }

  public int getAntNoder(){
    return listNodes.size();
  }

  public int getAntProsessorer(){
    return antallProsessorer;
  }

  public int noderMedNokMinne(int paakrevdMinne){
    int antNokMinne=0;
    for (int i=0;i<listNodes.size();i++){
      if (listNodes.get(i).nokMinne(paakrevdMinne)==true){
        antNokMinne++;
      }
    }
    return antNokMinne;
  }

}
