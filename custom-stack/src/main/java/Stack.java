package src.main.java;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Stack <T> {

  private List<T> games;
  
  public Stack(){
    this.games = new LinkedList<>();
  }
  
  public T pop(){
    if (this.games.isEmpty()) throw new EmptyStackException();
    T lastElement = this.games.get(this.games.size()-1);
    this.games.remove(lastElement);
    
    return lastElement;
  }
  
  public void push(T game){
    this.games.add(game);
  }
  
  public boolean isEmpty(){
    return (this.games.isEmpty());
  }
  
  public int size(){
    return this.games.size();
  }
  
  
  @Override
  public String toString(){
    return this.games.toString();
  }
  

}
