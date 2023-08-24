package chapter11;

import java.util.ArrayList;
import java.util.LinkedList;

public class Performance1Demo {
  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>();
    LinkedList<Integer> ll = new LinkedList<>();
// arrayList 추가 - 맨뒤에 추가
    long start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.add(i);
    }
    long end = System.nanoTime();
    long arrayList = end - start;
    System.out.println(arrayList);
//    arrayList 삭제 - 맨뒤에서 
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.remove(al.size() - 1);
    }
    end = System.nanoTime();
    arrayList = end - start;
    System.out.println("arrayList 맨뒤에서 삭제" + arrayList);
//    arrayList 삭제 - 맨앞에서 삭제
    for (int i = 0; i < 100_000; i++) {
      al.add(i);
    }
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.remove(0);
    }
    end = System.nanoTime();
    arrayList = end - start;
    System.out.println("arrayList 맨앞에서 삭제" + arrayList);
//    linkedList 추가
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.add(0,1);
    }
    end = System.nanoTime();
    long linkedList = end - start;
    System.out.println(linkedList);
//    linkedList 삭제 - 맨앞에서 삭제
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.removeFirst();
    }
    end = System.nanoTime();
    linkedList = end  - start;
    System.out.println("linkedList 맨앞에서 삭제" + linkedList);
//    linkedList 삭제 - 맨뒤에서 삭제
    for (int i = 0; i < 100_000; i++) {
      ll.add(0,1);
    }
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.removeLast();
    }
    end = System.nanoTime();
    linkedList = end  - start;
    System.out.println("linkedList 맨뒤에서 삭제" + linkedList);
  }


}
