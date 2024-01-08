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
    System.out.println("Type in 'X' if you wish to stop calculating surface areas");
    
    //TODO: error handling when not valid input
    System.out.print("Length: ");
    String length = this.scanner.nextLine();
    
    System.out.print("Width: ");
    String Width = this.scanner.nextLine();
    
  }
  
}
