package src.main.java;

public class Animal {
  
  private final String name;
  
  public Animal(String name){
    this.name = name;
  }
  
  public void goForWalk(){
    System.out.println("walking");
  }
  
  public void makeSound(){
    System.out.println("making a sound");
  }
  
  public String toString(){
    return this.name;
  }
}
