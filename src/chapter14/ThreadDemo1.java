package chapter14;

public class ThreadDemo1 {
  public static void main(String[] args) {
    Thread thread = new Thread(new MyRunnable());
    //thread.run(); //순차처리
    thread.start(); //병렬처리

    for (int i = 0; i < 5; i++) {
      System.out.println("메인입니다");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
  }
}

class MyRunnable implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("안녕");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
  }
}
