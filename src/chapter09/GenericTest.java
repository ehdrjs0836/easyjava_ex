package chapter09;
/**
 * 제네릭타입 사용하지 않는 예제
 */

import java.util.ArrayList;

public class GenericTest {
  public static void main(String[] args) {
    ArrayList nums = new ArrayList();
    nums.add(10); //Integer로 10이  auto-boxing 됨
    nums.add(3.14); //Double로 3.14가  auto-boxing 됨
    nums.add("30");
    nums.add("hello");
    for (int i = 0; i < nums.size(); i++) {
      if(nums.get(i) instanceof Integer)
        System.out.println((Integer)(nums.get(i)) * 2);
      else if (nums.get(i) instanceof Double)
        System.out.println((Double)(nums.get(i)) * 2);
      else if (nums.get(i) instanceof String)
        System.out.println(Integer.parseInt((String)nums.get(i)));
      //NumberFormatException 에러도 발생할 뿐 더러
      //확장할때마다 수정해야하기 때문에 솔리드 OCP 원칙을 위반함
      //그래서 제네릭 타입 사용
    }
  }
}
