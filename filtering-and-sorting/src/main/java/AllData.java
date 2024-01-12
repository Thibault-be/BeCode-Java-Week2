package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class AllData{
  
  private List<TradeData> data;
  
  public AllData(){
    this.data = new ArrayList<>();
  }
  
  public List<TradeData> getAllData(){
    return this.data;
  }
  
  public void addData(TradeData tradeData){
    this.data.add(tradeData);
  }
}