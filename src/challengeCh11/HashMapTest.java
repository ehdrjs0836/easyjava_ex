package challengeCh11;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
  public static void main(String[] args) {
    Map<String,String> animals = Map.of("호랑이","tiger","표범","leopard","사자","lion");
    Map<String,String> map = new HashMap<>(animals);

    System.out.print("변경전:");
    System.out.println(map);

    map.replaceAll((k,v) -> v.toUpperCase());

    System.out.print("변경후:");
    System.out.println(map);
  }
}
