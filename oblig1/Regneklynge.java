import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Regneklynge{
  private int maksNoderPerRack;
  private ArrayList<Rack> listRacks=new ArrayList<Rack>(0);
  private ArrayList<Integer> antallNoder=new ArrayList<Integer>(0); /*Lagt til som oppgE.*/
  private ArrayList<Integer> nodeMinne=new ArrayList<Integer>(0); /*Lagt til som oppgE.*/
  private ArrayList<Integer> antallProsessorer=new ArrayList<Integer>(0); /*Lagt til som oppgE.*/

  public void setMaksAntNoder(int setMaksNoderPerRack){
    maksNoderPerRack=setMaksNoderPerRack;
  }

  public void lesFil(String filnavn){ /*Lagt til som oppgE.Burde ha try/catch-*/
    try{
      Scanner scanner = new Scanner(new File(filnavn));
      while (scanner.hasNextLine()){
        String line = scanner.nextLine();
        String[] splitLine=line.split(" ");
        if (splitLine.length==1){
          maksNoderPerRack=Integer.parseInt(splitLine[0]);
        }
        else{
          antallNoder.add(Integer.parseInt(splitLine[0]));
          nodeMinne.add(Integer.parseInt(splitLine[1]));
          antallProsessorer.add(Integer.parseInt(splitLine[2]));
        }
      }
    }
    catch (FileNotFoundException e){
      System.out.println("Finner ikke filen.");
      return;
    }
  }

  public void settInnNode(int minne, int antProsessorer){
    if (listRacks.size()==0){
      Rack newRack = new Rack();
      newRack.settInn(minne,antProsessorer);
      listRacks.add(newRack);
    }
    else if (maksNoderPerRack>listRacks.get(listRacks.size()-1).getAntNoder()){
      listRacks.get(listRacks.size()-1).settInn(minne,antProsessorer);
    }
    else{
      Rack newRack = new Rack();
      newRack.settInn(minne,antProsessorer);
      listRacks.add(newRack);
    }
/*Kan skrive om dette for aa gjoere det penere. Samle fellesuttrykk utenfor.*/
  }

  public int antProsessorer(){
    int antPros=0;
    for (int i=0; i<listRacks.size();i++){
      antPros=antPros+listRacks.get(i).getAntProsessorer();
    }
    return antPros;
  }

  public int noderMedNokMinne(int paakrevdMinne){
    int noderNokMinne=0;
    for (int i=0; i<listRacks.size();i++){
      Rack temp_rack=listRacks.get(i);
      noderNokMinne+=temp_rack.noderMedNokMinne(paakrevdMinne);
    }
    return noderNokMinne;
  }

  public int antRacks(){
    return listRacks.size();
  }
}
