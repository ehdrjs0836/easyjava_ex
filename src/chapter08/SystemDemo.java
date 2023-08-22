package chapter08;

/**
 * 시스템 테스트
 */
public class SystemDemo {
  public static void main(String[] args) {
    int[] numbers = new int[1000];
    System.out.println(System.nanoTime());
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] += 1;
    }
    System.out.println(System.nanoTime());
  }
}
