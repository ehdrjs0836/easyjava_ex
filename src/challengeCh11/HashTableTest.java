package challengeCh11;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Map<String, Integer> map = new Hashtable<>();
    String name = "";
    map.put("김열공",80);
    map.put("최고봉",90);
    map.put("우등생",95);
    map.put("나자바",88);

    while (true) {
      System.out.println("이름을 입력하세요. 종료하려면 enter: ");
      name = in.nextLine();
      if (name.isBlank()) {
        break;
      } if (map.get(name) != null) {
        System.out.println(name + "의 점수는 " + map.get(name) + "입니다.");
      } else {
        System.out.println(name + "의 점수는 존재하지 않습니다.");
      }
    }
  }
}

