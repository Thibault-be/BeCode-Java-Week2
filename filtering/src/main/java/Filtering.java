package src.main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Filtering {
  
  public static void main(String[] args){
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("Which year? ");
    String year = scanner.nextLine();
    System.out.print("Which country? ");
    String country = scanner.nextLine();
    
    try{
      Files.lines(Paths.get("covid-effects.csv")).skip(1)
          .map(line -> line.split(","))
          .forEach(line -> {
            if((line[1].equals(year) && line[4].equals(country))){
              TradeData newData = new TradeData(
                  line[0],
                  line[1],
                  line[2],
                  line[3],
                  line[4],
                  line[5],
                  line[6],
                  line[7],
                  line[8],
                  line[9]
              );
              newData.printValueData();
            }
          });
      
    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
  }
}