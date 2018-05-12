class HvitRute extends Rute{
  public HvitRute(int rad, int kol){
    super(rad, kol);
  }

  public char tilTegn(){
    return '.';
    //setFont(new Font(50));
    //setPrefSize(120,120);
  }

  @Override
  public boolean erAapning(){
    return false;
  }
}
