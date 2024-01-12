package src.main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class FindHighestValue {
  
  public static void main(String[] args){
    
    AllData allData = new AllData();
    
    try{
      Files.lines(Paths.get("covid-effects.csv")).skip(1)
          .map(line -> line.split(","))
          .forEach(splitLine ->{
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
            allData.addData(newData);
          }
      );
    }
    catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }

    ArrayList<TradeData> chinaData = findMaxValue(allData);
    sumOfExports(chinaData);
    sortInDescendingOrder(chinaData);
  }

  public static ArrayList<TradeData> findMaxValue(AllData allData){
    ArrayList<TradeData> chinaData = new ArrayList<>();
    for (TradeData td : allData.getAllData()){
      if (
        td.getCountry().equals("China") &&
        td.getYear() == 2019 &&
        td.getDirection().equals("Exports") &&
        td.getCommodity().equals("All") &&
        td.getTransportMode().equals("All")
      )
      chinaData.add(td);
    }

    OptionalInt max = chinaData.stream()
      .mapToInt(data -> data.getValue())
      .max();
    System.out.println("The highest export value is for China: " + max.getAsInt() + " dollars");

    return chinaData;
  }

  public static void sumOfExports(ArrayList<TradeData> chinaData){
    long sum = chinaData.stream()
                .mapToLong(data -> data.getValue())
                 .reduce(0, (previousSum, nextValue) -> previousSum + nextValue);
    System.out.println("The sum of all export values is " + sum / 1000000 + " mln dollars.");
  }

  public static void  sortInDescendingOrder(List<TradeData> chinaData){
    ArrayList<TradeData> sortedInDescending = chinaData.stream()
      .sorted((valOne, valTwo) -> valTwo.getValue() - valOne.getValue())
      .collect(Collectors.toCollection(ArrayList::new));

      System.out.println("highest from sorted in descending order: " + sortedInDescending.get(0).getValue() + " dollars");

  }
}
