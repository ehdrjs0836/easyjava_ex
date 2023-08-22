import java.util.Arrays;

public class ArrayDemo {
  public static void main(String[] args) {
    char[] c1 = {'j','a','v','a'};
    char[] c2 = Arrays.copyOf(c1, c1.length);
    Character[] c3 = {'j','a','v','a'};
    //print(c3);
    System.out.println(c1);
    System.out.println(c2);

    String[] s1 = {"A","B","C","D"};
    int d = Arrays.binarySearch(s1, "D");
    for (String s:s1) {
      if (s.equalsIgnoreCase("d")) {
        System.out.println("찾았습니다.");
      }
    }
    System.out.println(d);
  }

//  static void print(Object[] objArray){
//    for (Object obj:objArray) {
//      System.out.println(obj);
//    }
//    System.out.println();
//  }
}
