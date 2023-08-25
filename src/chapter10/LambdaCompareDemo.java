package chapter10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaCompareDemo {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
    Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
    System.out.println("내림차순 정렬 후 : " + list);
  }
}

interface Comparator<T> {
  int compare(T o1, T o2);
}