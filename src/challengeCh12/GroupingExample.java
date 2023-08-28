package challengeCh12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {
  public static void main(String[] args) {
    List<MemberGroup> list = Arrays.asList(
        new MemberGroup("홍길동", "개발자"),
        new MemberGroup("김나리", "디자이너"),
        new MemberGroup("신용권", "개발자")
    );
//    Map<String, List<MemberGroup>> gm = list.stream().collect(
//            Collectors.groupingBy(MemberGroup::getJob,
//            Collectors.mapping(MemberGroup::getName)));


    System.out.println("[개발자]");

    System.out.println();
    System.out.println("[디자이너]");

  }
}

class MemberGroup {
  private String name;
  private String job;
  public MemberGroup(String name, String job) {
    this.name = name;
    this.job = job;
  }
  public String getName() { return name; }
  public String getJob() { return job; }
  @Override
  public String toString() {
    return "{name:" + name + ", job:" + job + "}";
  }
}
