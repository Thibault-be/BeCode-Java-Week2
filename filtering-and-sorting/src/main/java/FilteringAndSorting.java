package src.main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class FilteringAndSorting {
  
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
    
    ArrayList<TradeData> data2018 = new ArrayList<>();
    for (TradeData tradeData : allData.getAllData()){
      if(
          tradeData.getYear() == 2018 &&
          tradeData.getCountry().equals("All") &&
          tradeData.getTransportMode().equals("All") &&
          tradeData.getCommodity().equals("All") &&
          tradeData.getDirection().equals("Imports")
          
      ) {
        data2018.add(tradeData);
      }
    }
   Collections.sort(data2018, (dataOne, dataTwo) -> dataOne.getValue() - dataTwo.getValue());

   for (TradeData tradeData : data2018){
     System.out.println(tradeData.toString());
   }
  }
}
