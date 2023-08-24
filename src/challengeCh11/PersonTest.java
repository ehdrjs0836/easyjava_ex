package challengeCh11;

//import chapter09.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PersonTest {
  public static void main(String[] args) {
    Set<Person> set = new HashSet<>();

    set.add(new Person("김열공", 20));
    set.add(new Person("최고봉",56));
    set.add(new Person("우등생",16));
    set.add(new Person("나자바",35));

    Iterator<Person> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next());
    }
    System.out.println();
    System.out.println(new Person("나자바",35).hashCode());
    System.out.println(new Person("나자바",35).hashCode());
    // 동일한 객체 추가해보기
    set.add(new Person("나자바",35));
    iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next());
    }
    System.out.println();
  }
}

class Person {
  String name;
  int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public int hashCode() {
    return name.hashCode() + age;
  }

  @Override
  public String toString() {
    return "Person["+name +" : " + age+ "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person person) {
      if(person != null && this.name.equals(person.name)) {
        if(this.hashCode() == person.hashCode()) {
          return true;
        }
      }
    }
    return false;
  }
}