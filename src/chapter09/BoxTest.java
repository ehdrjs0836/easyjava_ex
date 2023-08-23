package chapter09;

import javax.swing.*;

public class BoxTest {
  public static void main(String[] args) {
    Box<Integer> i = new Box<>();
    i.setValue(Integer.valueOf(100));
    System.out.println(i.getValue());

    Box<String> s = new Box<>();
    s.setValue("만등이네!");
    System.out.println(s.getValue());
  }
}

class Box<T> {
  private T value;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
