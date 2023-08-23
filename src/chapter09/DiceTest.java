package chapter09;

public class DiceTest {
  public static void main(String[] args) {
    Dice dice = new Dice();
    System.out.println(dice.roll());
  }
}

class Dice {
  public int roll() {
    return (int)Math.ceil((Math.random()*6));
  }
}
