package chapter08;

/**
 * Stringbuilder 테스트
 */
public class StringbuilderDemo {
  public static void main(String[] args) {
//    String s = new String("hi");
//    System.out.println(s.hashCode());
//    s = s+ "!";
//    System.out.println(s.hashCode());
//    StringBuilder sb = new StringBuilder("hi");
//    System.out.println(sb.hashCode());
//    sb = sb.append("!");
//    System.out.println(sb.hashCode());
    StringBuilder hw = new StringBuilder("hello, world");
    System.out.println(hw.hashCode());
    System.out.println(hw.capacity());
    hw = hw.delete(7,12);
    System.out.println("7번째 자리부터 12번째자리에 있는 world를 삭제 후 : " + hw);
    hw = hw.insert(7,"world!");
    System.out.println("world를 7번째 자리에 추가후 : " + hw);
    hw = hw.replace(7,13,"JAVA!");
    System.out.println("world를 JAVA로 변경후 : " + hw);
    hw = hw.replace(0,6,"HELLO,").reverse();
    System.out.println("hello를 HELLO로 변경후 리버스 : " + hw);
  }
}
