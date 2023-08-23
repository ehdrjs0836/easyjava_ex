package chapter09;

import java.io.IOException;

public class ThrowExceptionDemo {
  public static void main(String[] args) throws IOException {
    write("a.txt");
  }

  static void write(String filename) throws IOException {
    System.out.println(filename + "파일을 저장합니다.");
  }
}
