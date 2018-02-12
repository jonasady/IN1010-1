public class Node{
    private int minneStr; /*storrelse av minne i   GB*/
    private int pros_ant; /*maks to prosessorer*/

    public void setMinneStr(int storrelse){
      minneStr=storrelse;
    }

    public void setPros_ant(int pros_ant){
      pros_ant=pros_ant;
    }

    public int getAntProsessorer(){
        return pros_ant;
    }

    public boolean nokMinne(int paakrevdMinne){
        return (minneStr>=paakrevdMinne); /*Returnerer False hvis minneStr<paakrevdMinne*/
    }
}
