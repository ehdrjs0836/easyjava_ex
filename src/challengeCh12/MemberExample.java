package challengeCh12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberExample {
  public static void main(String[] args) {
    List<Member> list = Arrays.asList(
        new Member("홍길동", 30, "개발자"),
        new Member("신용권", 40,"디자이너"),
        new Member("김자바", 26,"개발자")
    );
//    double avg = list.stream()
//        .mapToInt(x-> x.getAge())
//        .average()
//        .getAsDouble();
//    System.out.println("평균나이 : "+avg);
    List<Member> developers = list.stream()
        .filter(x -> x.getJob().equals("개발자"))
        .collect(Collectors.toList());
    developers.stream()
        .forEach(m -> System.out.println(m.getName()));
  }
}

class Member {
  private String name;
  private int age;
  private String job;
  public Member(String name, int age, String job) {
    this.name = name;
    this.age = age;
    this.job = job;
  }
  public String getName() { return name; }
  public int getAge() { return age; }
  public String getJob() { return job; }
}