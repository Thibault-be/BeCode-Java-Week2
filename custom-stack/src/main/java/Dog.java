package src.main.java;

public class Dog extends Animal{
  
  private String name;
  
  public Dog(String name){
    super (name);
  }
  
  public void makeSound(){
    System.out.println("woof");
  }
}
