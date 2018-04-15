class HvitRute extends Rute{
  public HvitRute(int rad, int kol){
    super(rad, kol);
  }

  public char tilTegn(){
    return '.';
  }

  @Override
  public boolean erAapning(){
    return false;
  }
}
