package chapter11;

import java.util.HashMap;
import java.util.Map;

public class HashMap1Demo {
  public static void main(String[] args) {
    Map<Fruit, Integer> fruits = new HashMap<>();
    System.out.println(fruits.size());
    fruits.put(new Fruit("사과"), 10);
    fruits.put(new Fruit("바나나"), 5);
    fruits.put(new Fruit("딸기"), 3);
    
    fruits.put(new Fruit("사과"), 3);
    fruits.put(null, 3);
    System.out.println(fruits);
  }
}

class Fruit{
  String name;

  public Fruit (String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof Fruit fruit) {
      if(fruit.hashCode() == this.hashCode()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "["+name+"]";
  }
}
