package chapter12;

import java.util.List;
import java.util.Optional;

public class Reduce1Demo {
  public static void main(String[] args) {
    List<Integer> list = List.of(3,4,5,1,2);
    int i = list.stream().reduce((x, y) -> x + y).get(); //초기값을 안주면 get을 넣어야하고
    int i1 = list.stream().reduce(0, (x, y) -> x + y); //초기값을 주면 get을 안넣어도 됨

    int i2 = list.stream().reduce(1,(x,y) -> x * y);
    System.out.println(i2); //초기값을 1로 주지 않으면 곱과 나누기 연산일때 문제가 생김
  }
}
