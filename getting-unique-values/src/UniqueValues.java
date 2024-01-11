
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class UniqueValues{
  
  public static void main(String[] args){
    try{
      Map<Integer, Set<String>> columnValuesMap = new HashMap<>();
  
      Files.lines(Paths.get("covid-effects.csv")).skip(1)
          .map(line -> line.split(","))
          .forEach(columns -> {
            for (int i = 0; i < columns.length; i++) {
              columnValuesMap
                  .computeIfAbsent(i, k -> new HashSet<>())
                  .add(columns[i].trim());
            }
          });
      
      columnValuesMap.forEach((columnIndex, uniqueValues) ->
              System.out.println("Unique values in column " + (columnIndex + 1) + ": " + uniqueValues));
      
    } catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
  }
}