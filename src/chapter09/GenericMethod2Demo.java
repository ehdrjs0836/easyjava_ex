package chapter09;

public class GenericMethod2Demo {
  public static void main(String[] args) {
    Integer[] ia = {1,2,3,4,5};
    Double[] da = {1.0,2.0,3.0,4.0,5.0};
    Character[] ca = {'a', 'b', 'c', 'd', 'e'};

    Utils2.showArray(ia); //[1,2,3,4,5]
    Utils2.showArray(da); //[1.0,2.0,3.0,4.0,5.0]
//    Utils2.showArray(ca); //error
    System.out.println(Utils2.getLast(ia));  // 5
    System.out.println(Utils2.getLast(da));  // 5.0
//    System.out.println(Utils2.getLast(ca));  // error
  }
}

class Utils2 {
  static <T extends Number> void showArray(T[] array){
    //System.out.println(Arrays.toString(array));
    for (T t:array) {
      System.out.printf("%s ", t);
    }
  }

  static <T extends Number> T getLast(T[] array) {
    return array[array.length-1];
  }

//  static void showArray(Character[] array){
//    System.out.println(Arrays.toString(array));
//  }
}
