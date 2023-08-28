package chapter12;

import java.util.stream.IntStream;

public class Laziness1Demo {
  public static void main(String[] args) {
    IntStream is = IntStream.rangeClosed(1, 5);
    //스트림의 최종 연산은 조급한 연산이지만 중간 연산은 느긋한 연산이다.
    is.filter(x -> { //느긋한 연산
      System.out.println("filter:" + x);
      return x % 2 == 0;
    }).map(x -> { //느긋한 연산
      System.out.println("map:" + x);
      return x * x;
    }).forEach(x -> System.out.println("foreach:" + x)); //조급한 연산
  }
}
