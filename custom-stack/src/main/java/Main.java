package src.main.java;

public class Main{
  
  public static void main(String[] args) {
    
    
    Cat cat = new Cat("Darwin");
    Dog dog = new Dog("tbo");
    Cat newCat = new Cat("Feline");
    Cat simba = new Cat("Simba");
    Cat snabbel = new Cat("Snabbel");
    
    Dog olim = new Dog("Olim");
    Dog lassie = new Dog("Lassie");
    
    
    Stack<Animal> stack = new Stack<>();
    
    stack.push(cat);
    stack.push(dog);
    stack.push(newCat);
    System.out.println(stack);
    stack.pop();
    System.out.println(stack);
    stack.push(simba);
    stack.push(snabbel);
    stack.pop();
    stack.push(olim);
    stack.push(lassie);
    stack.pop();
    System.out.println(stack);
    Animal pop = stack.pop();
    System.out.println(stack);
    
    System.out.println("animal " + pop);
  }
}