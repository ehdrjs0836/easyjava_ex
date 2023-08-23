package chapter09;

import java.util.ArrayList;

public class GenericClass1Demo {
  public static void main(String[] args) {
    ArrayList<Boricha> arrayListBoricha = new ArrayList<>();
    arrayListBoricha.add(new Boricha());
    ArrayList<Beer> arrayListBeer = new ArrayList<>();
    arrayListBeer.add(new Beer());
    Cup c = new Cup();
    c.setBeverage(new Boricha());
    if (c.getBeverage() instanceof Boricha) {
      Boricha boricha = (Boricha) c.getBeverage();
    } else if (c.getBeverage() instanceof Beer) {
      c.setBeverage(new Beer());
    }
    //Beer beer = (Beer) c.getBeverage();
    c.setBeverage(new Beverage());
    c.setBeverage(new Object());

    Cup<Boricha> borichaCup = new Cup<>();
    borichaCup.setBeverage(new Boricha());
    Boricha boricha = borichaCup.getBeverage();

    Cup<Beer> beerCup = new Cup<>();
    beerCup.setBeverage(new Beer());
    //beerCup.setBeverage(new Boricha());
    Beer beer = beerCup.getBeverage();
  }
}

class Beverage { }
class Boricha extends Beverage { }
class Beer extends Beverage { }

//class Cup {
//  private Object beverage;
//  public Object getBeverage() {
//    return beverage;
//  }
//  public void setBeverage(Object beverage) {
//    this.beverage = beverage;
//  }
//}

class Cup<T> {
  private T beverage;
  public T getBeverage()
  {
    return beverage;
  }
  public void setBeverage(T beverage) {
    this.beverage = beverage;
  }
}