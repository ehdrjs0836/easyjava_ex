package chapter12;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortedDemo {
  public static void main(String[] args) {
    Stream<String> s1 = Stream.of("a1","a2","d2","b1","c2");
    s1.sorted()
        .forEach(Util::print);
        System.out.println();

    // d2, c2, b1, a2, a1
    s1 = Stream.of("a1","a2","d2","b1","c2");
    s1.sorted(new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return o2.hashCode() - o1.hashCode();
          }
        })
        .forEach(Util::print);
        System.out.println();

    s1 = Stream.of("a1","a2","d2","b1","c2");
    s1.sorted((x,y) -> y.hashCode() - x.hashCode())
        .forEach(Util::print);

    System.out.print("\n 나라이름순서 :");
    Nation.nations.stream()
        .sorted(Comparator.comparing(x->x.getName())) //comparing: 기준(~순으로)
        .map(x -> x.getName())
        .forEach(Util::printWithParenthesis);

    System.out.print("\n GDP순서 :");
        Nation.nations.stream()
        .sorted(Comparator.comparing(x->x.getGdpRank()))
        .map(x -> x.getName())
        .forEach(Util::printWithParenthesis);
  }
}
