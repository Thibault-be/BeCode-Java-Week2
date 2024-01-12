package main.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TradeData {

  private String direction;
  private String year;
  private String date;
  private String weekday;
  private String country;
  private String commodity;
  private String transportMode;
  private String measure;
  private String value;
  private String cumulative;

  public TradeData (
    String direction,
    String year,
    String date,
    String weekday,
    String country,
    String commodity,
    String transportMode,
    String measure,
    String value,
    String cumulative
  ){
    this.direction = direction;
    this.year = year;
    this.date = date;
    this.weekday = weekday;
    this.country = country;
    this.commodity = commodity;
    this.transportMode = transportMode;
    this.measure = measure;
    this.value = value;
    this.cumulative = cumulative;
  }
    public String getMeasure(){
      return this.measure;
    }

    public int getYear(){
      return Integer.valueOf(this.year);
    }

    public int getValue(){
      return Integer.valueOf(this.value);
    }

    public double convertToEuro(double rate){
      return this.getValue() * rate;
    }

    public String getCountry(){
      return this.country;
    }

    public String getDirection(){
      return this.direction;
    }

    public String getDate(){
      return this.date;
    }
    
    public String getCommodity(){
      return this.commodity;
    }
    
    public String getTransportMode(){
    return this.transportMode;
    }

    public String getMonth(){
      String month = this.date.split("/")[1];
      switch (month){
        case "01": return "January";
        case "02": return "February";
        case "03": return "March";
        case "04": return "April";
        case "05": return "May";
        case "06": return "June";
        case "07": return "July";
        case "08": return "August";
        case "09": return "September";
        case "10": return "October";
        case "11": return "November";
        case "12": return "December";
        default: return "";
      }
      
    }
    
    public String toString(){
      return this.date + " - " + this.year + " - " + this.country + " - " + this.value;
    }


    public static Map<String, Integer> calculateMonthlySum(List<TradeData> dataList) {
        return dataList.stream()
                .collect(Collectors.groupingBy(TradeData::getMonth, Collectors.summingInt(TradeData::getValue)));
    }
  }