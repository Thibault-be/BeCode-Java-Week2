package src.main.java;

import java.util.List;
import java.util.ArrayList;

public class AllData {
  
  private List<TradeData> data;
  
  public AllData(){
    this.data = new ArrayList<>();
  }
  
  public void add(TradeData tradeData){
    this.data.add(tradeData);
  }
  
  public List<TradeData> getValues(){
    return this.data;
  }
  
}
