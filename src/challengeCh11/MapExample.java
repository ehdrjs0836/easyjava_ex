package challengeCh11;

import java.util.*;

public class MapExample {
  public static void main(String[] args) {
    Map<String,Integer> map = new HashMap<>();
    map.put("blue",96);
    map.put("hong",86);
    map.put("white",92);

    String name = null;   //최고 점수를 받은 아이디를 저장하는 변수
    int maxScore = 0;     //최고 점수를 저장하는 변수
    int totalScore = 0;   //점수 합계를 저장하는 변수

    //최고 점수
    Collection<Integer> values = map.values();
    maxScore = Collections.max(values);
    System.out.println("최고점수 : " + maxScore);
    //점수합계, 평균
    for (Integer value:values) {
      totalScore += value;
    }
    System.out.println("평균점수 : " + totalScore/values.size());

    //이 부분에서 Map.Entry 활용하기
    Set<String> keys = map.keySet();
    for (String key:keys) {
      if(map.get(key) == maxScore) {
        name = key;
        System.out.println("최고 점수를 받은 아이디 : "+ name);
      }
    }
//    Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
//    for(Map.Entry<String,Integer> entry : entrySet) {
//      if(entry.getValue()>maxScore) {
//        name = entry.getKey();
//        maxScore = entry.getValue();
//      }
//      totalScore += entry.getValue();
//    }
//
//    int avgScore = totalScore / map.size();
//    System.out.println("평균 점수: " + avgScore);
//
//    System.out.println("최고점수: " + maxScore);
//    System.out.println("최고점수를 받은 아이디: " + name);
  }
}
