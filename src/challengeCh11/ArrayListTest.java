package challengeCh11;

import java.util.ArrayList;

public class ArrayListTest {
  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("갈매기");
    arrayList.add("나비");
    arrayList.add("다람쥐");
    arrayList.add("라마");

    for (String animal: arrayList) {
      if (animal.length() == 2){
        System.out.println(animal);
      }
    }
  }
}
