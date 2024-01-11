public enum UnitOfMeasurements {
  
  METRE,
  CENTIMETRE,
  MILLIMETRE;
  
  UnitOfMeasurements(){
  
  }

  public boolean isCorrectUnit(String measurement){
    measurement = measurement.replaceAll(" ","").toLowerCase();
    String[] characterArray = measurement.split("");
    
    int lastChar = measurement.length() -1;
    int penultimateChar = lastChar - 1;
    String lastTwo = characterArray[penultimateChar] + characterArray[lastChar];
    
    if (lastTwo.equals("cm") || lastTwo.equals("mm")) return true;
    return characterArray[lastChar].equals("m");
  }
  
}
