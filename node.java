class Node{
    private int minneStr; /*storrelse av minne i   GB*/
    private int pros_ant; /*maks to prosessorer*/

    public int antProsessorer(){
        return pros_ant;
    }

    public boolean nokMinne(paakrevdMinne){
        return (minneStr>=paakrevdMinne); /*Returnerer False hvis minneStr<paakrevdMinne*/
    }

}
