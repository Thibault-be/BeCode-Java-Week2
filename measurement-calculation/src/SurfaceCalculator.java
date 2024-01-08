import java.util.Scanner;

public class SurfaceCalculator {
  public static void main(String[]args){

    Scanner scanner = new Scanner(System.in);
    UserInterface ui = new UserInterface(scanner);

    ui.start();
  }
  

}