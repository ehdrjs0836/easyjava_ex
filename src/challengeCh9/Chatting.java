package challengeCh9;

public class Chatting {
  class Chat {
    void start() {}
    void sendMessage(String message) {}
  }

  void startChat(String chatId) {
    //이것이 자바다 교재 404 page 참고
    //로컬변수(생성자 또는 메서드의 매개변수 또는 내부에서 선언된 변수)를
    //로컬 클래스에서 사용할 경우 로컬 변수는 final 특성을 갖게 되므로 값을 읽을 수만 있고 수정 할 수 없게 됨
    String nickName = chatId;
    Chat chat = new Chat() {
      @Override
      public void start() {
        while (true) {
          String inputData = "안녕하세요.";
          String message = "[" + nickName + "] " + inputData;
          sendMessage(message);
        }
      }
    };

    chat.start();
  }
}
