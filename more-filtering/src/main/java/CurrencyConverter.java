package src.main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CurrencyConverter {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    AllData data = new AllData();
    
    try {
      Files.lines(Paths.get("covid-effects.csv")).skip(1)
          .map(line -> line.split(","))
          .forEach(splitLine -> {
            TradeData newData = new TradeData(
              splitLine[0],
              splitLine[1],
              splitLine[2],
              splitLine[3],
              splitLine[4],
              splitLine[5],
              splitLine[6],
              splitLine[7],
              splitLine[8],
              splitLine[9]
            );
            data.add(newData);
          });
      
      getRequestedData(data);
      
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
  
  public static void getRequestedData(AllData data){
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("File has been loaded");
    
    System.out.print("Which year? ");
    int year = Integer.valueOf(scanner.nextLine());
    
    System.out.print("Exchange rate? ");
    double rate = Double.valueOf(scanner.nextLine());
    
    System.out.print("Which country? ");
    String country = scanner.nextLine();
    
    for (TradeData tradeData : data.getValues()){
      if (
          year == tradeData.getYear() &&
          country.equals(tradeData.getCountry()) &&
          tradeData.getMeasure().equals("$")
      ){
        System.out.println(
            tradeData.getDate() + " - " +
            tradeData.getCountry() + " - " +
            tradeData.getDirection() + " - " +
            tradeData.getValue() + " dollars" + " - " +
            tradeData.convertToEuro(rate) + " euros"
        );
      }
    }
  
  }
}