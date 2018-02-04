import java.util.ArrayList;

public class Rack{
  private int maksAntNoder;
  private int antallNoder;
  private int antallProsessorer;
  private ArrayList<Object> listNodes=new ArrayList<Object>(0);

  public void settInn(int minnestorrelse, int ant_prosessorer){
    Node ny_node = new Node();
    ny_node.setMinneStr(minnestorrelse);
    ny_node.setPros_ant(ant_prosessorer);
    listNodes.add(ny_node);
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
      if ((listNodes(i).nokMinne(paakrevdMinne))==true){
        antNokMinne++;
      }
    }
    return antNokMinne;
  }

}
