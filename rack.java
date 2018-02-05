import java.util.ArrayList;

public class Rack{
  private int antallNoder;
  private int antallProsessorer;
  private ArrayList<Node> listNodes=new ArrayList<Node>(0);

  public void settInn(int minnestorrelse, int antNyeProsessorer){
    Node newNode = new Node();
    newNode.setMinneStr(minnestorrelse);
    newNode.setPros_ant(antNyeProsessorer);
    listNodes.add(newNode);
    antallNoder++;
    antallProsessorer+=antNyeProsessorer;
  }

  public int getAntNoder(){
    return antallNoder;
  }

  public int getAntProsessorer(){
    return antallProsessorer;
  }

  public int noderMedNokMinne(int paakrevdMinne){
    int antNokMinne=0;
    for (int i=0;i<listNodes.size();i++){
      Node temp_node=listNodes.get(i);
      if ((temp_node.nokMinne(paakrevdMinne))==true){
        antNokMinne++;
      }
    }
    return antNokMinne;
  }

}
