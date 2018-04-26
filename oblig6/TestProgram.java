class TestProgram{
  public static void main(String[] args){
    Monitor kryptertMonitor = new Monitor();
    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal [] kanaler = ops.hentKanalArray();
    Telegrafist telegrafist1 = new Telegrafist(kryptertMonitor,1,kanaler[1]);

  }
}
