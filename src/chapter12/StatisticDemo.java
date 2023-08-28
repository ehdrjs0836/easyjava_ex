package chapter12;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StatisticDemo {
  public static void main(String[] args) {
    IntStream is = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("sum : " + is.sum());
    is = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("avg : " + is.average().getAsDouble());

    Stream<String> ss = Stream.of("a", "b", "c", "d", "e");
    System.out.println("count : "+ss.count());
    ss = Stream.of("a", "b", "c", "d", "e");
    System.out.println("max : " + ss.max((x,y)-> x.hashCode() - y.hashCode()).get());

    Stream<String> ss1 = Stream.of("a", "bb", "ccc", "d", "ee"); //결과가 ccc가 나오도록
    System.out.println("글자수가 가장 긴 문자 : " + ss1.max((x,y)-> x.length() - y.length()).get());
    //a, d, bb, ee, ccc
    //(x,y)-> x.length() - y.length()
    // 비교했을때 -1(작다) 0(같다) 1(크다)로 비교
  }
}
