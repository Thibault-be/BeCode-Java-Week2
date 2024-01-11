package src.main.java;

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
  
  public TradeData(
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
  
  public String getValue(){
    return this.value;
  }
  
  public void printValueData(){
    System.out.println(
        this.date + " - " + this.country + " - " + this.direction + " - " + this.value
    );
  }
  
}