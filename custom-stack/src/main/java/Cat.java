package src.main.java;

public class Cat extends Animal {
  
  private String name;
  
  public Cat(String name){
    super (name);
  }
  
  
  @Override
  public void makeSound(){
    System.out.println("meow");
  }
  
//  @Override
//  public String toString(){
//    return this.name;
//  }
  
}
