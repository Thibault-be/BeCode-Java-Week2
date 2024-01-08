public enum UnitOfMeasurements {
  
  METRE (1.0),
  CENTIMETRE (0.01),
  MILIMETRE (0.001);
  
  final double measurement;
  
  UnitOfMeasurements(double measurement){
    this.measurement = measurement;
  }

  public void MeasureUnit(){
    System.out.println("hello there");
  }
  

}
