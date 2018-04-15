class SortRute extends Rute{

  public SortRute(int rad, int kol){
    super(rad, kol);
  }

  public char tilTegn(){
    return '#';
  }

  @Override
  public boolean erAapning(){
    return false;
  }
}
