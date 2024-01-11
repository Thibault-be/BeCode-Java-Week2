import java.util.Scanner;

public class UserInterface {
  
  private Scanner scanner;
  
  public UserInterface(Scanner scanner){
    this.scanner = scanner;
  }
  
  public void start(){
    
    System.out.println("Welcome to the converter");
    System.out.println("Please give the length and width that you wish to calculate");
    System.out.println("You may use metres (m), centimetres (cm) or (mm)");
    System.out.println("You may also use two different units in one calculation. For instance: Length: 2.5m, Width: 60cm");

    //TODO: error handling when not valid input
    
    boolean flag = true;
    String lengthUnit = "";
    Double lengthValue = null;
    while(flag){
      System.out.print("Length: ");
      String lengthInput = this.scanner.nextLine();
      String[] lengthAndUnit = separateDoubleFromUnit(lengthInput);
      
      lengthUnit = lengthAndUnit[1];
      String lengthUnit = UnitOfMeasurements.CENTIMETRE;
      
      if (! (lengthUnit.equals("mm") || lengthUnit.equals("cm") || lengthUnit.equals("m"))){
        System.out.println("That wasn't valid input, please try again");
        continue;
      }
      
      try{
        lengthValue = Double.valueOf(lengthAndUnit[0]);
      } catch (Exception e){
        System.out.println("That wasn't valid input, please try again");
        continue;
      }
      flag = false;
    }
    
    boolean widthFlag = true;
    Double widthValue = null;
    String widthUnit = "";
    while(widthFlag){
      System.out.print("Width: ");
      String widthInput = this.scanner.nextLine();
      String[] widthAndUnit = separateDoubleFromUnit(widthInput);
      
      widthUnit = widthAndUnit[1];
      if (! (widthUnit.equals("mm") || widthUnit.equals("cm") || widthUnit.equals("m"))){
        System.out.println("That wasn't valid input, please try again");
        continue;
      }
      
      try{
        widthValue = Double.valueOf(widthAndUnit[0]);
      } catch (Exception e){
        System.out.println("That wasn't valid input, please try again");
        continue;
      }
      widthFlag = false;
    }
    
    
    double surfaceAreaM = lengthValue * widthValue;
    double surfaceAreaCm = lengthValue * widthValue * 10000;
    double surfaceAreaMm = lengthValue * widthValue * 1000000;

    String roundedValueStrM = String.format("%.2f", surfaceAreaM);
    String roundedValueStrCm = String.format("%.2f", surfaceAreaCm);
    String roundedValueStrMm = String.format("%.2f", surfaceAreaMm);

    System.out.println("The surface is " + roundedValueStrM + "m²");
    System.out.println("This is also " + roundedValueStrCm + " cm²");
    System.out.println("or " + roundedValueStrMm + " mm²");
    
  }
  
  public static String[] separateDoubleFromUnit(String input){
    input = input.replaceAll(" ","").toLowerCase();
    String[] characterArray = input.split("");
    
    //final character in characterArray
    int lastIndex = input.length()-1;
    
    //check if it's cm or mm or something else
    String lastTwo = characterArray[lastIndex-1] + characterArray[lastIndex];
    
    String Unit = "";
    String inputNumber ="";
    String[] numberAndUnit =  {inputNumber, Unit};
    if (lastTwo.equals("cm") || lastTwo.equals("mm")){
      inputNumber = obtainDouble(characterArray, lastIndex-1);
      Unit = lastTwo;
      
      try{
        inputNumber = convertToMetres(inputNumber, lastTwo);
      } catch (Exception e){
        //
      }
      
      
    } else if (
        characterArray[lastIndex].equals("m") &&
        characterArray[lastIndex -1].matches("[0-9]")
    )
    {
      inputNumber = obtainDouble(characterArray, lastIndex);
      Unit = characterArray[lastIndex];
    } else {
      return numberAndUnit;
    }
    
    numberAndUnit[1] = Unit;
    numberAndUnit[0] = inputNumber;
    return numberAndUnit;
  }
  
  public static String obtainDouble(String[] characterArray, int lastIndex){
    String number = "";
    for (int i = 0; i < lastIndex; i++){
      number = number + characterArray[i];
    }
    return number;
  }
  
  public static String convertToMetres(String inputNumber, String lastTwo){
    Double inputNumberDouble = 0.0;
    switch (lastTwo){
      case "mm":
        inputNumberDouble = Double.valueOf(inputNumber) / 1000;
        return String.valueOf(inputNumberDouble);
      case "cm":
        inputNumberDouble = Double.valueOf(inputNumber) / 100;
        return String.valueOf(inputNumberDouble);
      default :
        return "";
    }
  }
}
