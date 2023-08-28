package chapter12;

import java.util.Optional;

public class Optional2Demo {
  public static void main(String[] args) {
    String s1 = "hello";
    String s2 = null;
    Optional<String> o1 = Optional.ofNullable(s1);
    Optional<String> o2 = Optional.ofNullable(s2);

    if(o2.isPresent()) {
      Util.print(o2.get());
    } else {
      System.out.println("데이터가 없습니다.");
    }

    String s = o2.orElse("데이터가 없음");
    System.out.println(s);
    //Util.print(Optional.ofNullable(s2)); //ofNullable: 값이 null이면 empty객체로 변환

  }
}
