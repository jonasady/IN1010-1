import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Regneklynge{
  private File filnavn;
  private int maksNoderPerRack;
  private ArrayList<Rack> listRacks=new ArrayList<Rack>(0);

  public Regneklynge(int maksNoderPerRack){
    this.maksNoderPerRack = maksNoderPerRack;
  }

  public Regneklynge(String filnavn){
    this.lesFil(filnavn);
  }


  public void setMaksAntNoder(int setMaksNoderPerRack){
    this.maksNoderPerRack=setMaksNoderPerRack;
  }

/*Lagt til som oppgE..*/
  public void lesFil(String filnavn){
    try{
      Scanner scanner = new Scanner(new File(filnavn));
      while (scanner.hasNextLine()){
        String line = scanner.nextLine();
        String[] splitLine=line.split(" ");
        if (splitLine.length==1){
          this.setMaksAntNoder(Integer.parseInt(splitLine[0]));
        }
        else{
          for (int i=0; i<Integer.parseInt(splitLine[0]);i++){
            this.settInnNode(Integer.parseInt(splitLine[1]),Integer.parseInt(splitLine[2]));
            /*Vet ikke hva jeg skal kalle regneklyngen, ville gitt navnet paa regneklynga, f.eks. abel...*/
          }
        }
      }
    }
    catch (FileNotFoundException e){
      System.out.println("Finner ikke filen.");
      return;
    }
  }

  public void settInnNode(int minne, int antProsessorer){
    if listRacks.size()==0{

    }
    else if (maksNoderPerRack>listRacks.get(listRacks.size()-1).getAntNoder()){
      listRacks.get(listRacks.size()-1).settInn(minne,antProsessorer);
    }
    else{
      Rack newRack = new Rack();
      newRack.settInn(minne,antProsessorer);
      listRacks.add(newRack);
    }
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
