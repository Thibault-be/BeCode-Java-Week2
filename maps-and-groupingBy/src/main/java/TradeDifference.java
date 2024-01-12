package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Map;


public class TradeDifference{

  public static void main (String[] args){

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
            splitLine[9]);
          data.addData(newData);
          newData.getMonth();
        });
    }
    catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }

    //store yearly data for EU in separate arrays
    ArrayList<TradeData> data2019 = obtainYearlyData(data, "2019", "European Union (27)");
    ArrayList<TradeData> data2020 = obtainYearlyData(data, "2020", "European Union (27)");

    Map<String, Integer> monthlyTotals2019 = TradeData.calculateMonthlySum(data2019);
    Map<String, Integer> monthlyTotals2020 = TradeData.calculateMonthlySum(data2020);

    
    for (String key : monthlyTotals2019.keySet()){
      System.out.println("2019 - " + key + " - " + monthlyTotals2019.get(key) + " dollars.");
      System.out.println("2020 - " + key + " - " + monthlyTotals2020.get(key) + " dollars.");

      System.out.println("The difference between 2019 and 2020 for this month was: " + (monthlyTotals2019.get(key) - monthlyTotals2020.get(key)) + " dollars.");
      System.out.println();
    }



  }

  public static ArrayList<TradeData> obtainYearlyData(AllData data, String year, String country){
    return data.getAllData().stream()
            .filter(filterYear -> String.valueOf(filterYear.getYear()).equals(year))
            .filter(filterCountry -> filterCountry.getCountry().equals(country))
            .collect(Collectors.toCollection(ArrayList::new));

  }
}


//European Union (27)

/*
Use the streaming API to filter the data for the country 'European Union' and create two separate streams for the years 2019 and 2020.

For each stream, apply the Collectors.groupingBy function to group the data by month and calculate the sum of the export values for each month.
This will result in two HashMaps: one for the year 2019 and one for the year 2020.
Print out the HashMaps for both years, displaying each month along with its corresponding sum of export values.
 */