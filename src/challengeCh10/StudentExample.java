package challengeCh10;

public class StudentExample {
  private static Student[] students = {
      new Student("홍길동", 90, 96),
      new Student("신용권", 95, 93)
  };

  //avg() 메서드 작성
  public static double avg(Function<Student> function) {
    double sum = 0.0;
    for (Student student:students) {
      sum += function.apply(student);
    }
    return sum / students.length;
  }

  public static void main(String[] args) {
    double englishAvg = avg( s -> s.getEnglishScore() );
    System.out.println("영어 평균 점수: " + englishAvg);
    double mathAvg = avg( s -> s.getMathScore() );
    System.out.println("수학 평균 점수: " + mathAvg);
  }
}

class Student {
  private String name;
  private int englishScore;
  private int mathScore;
  public Student(String name, int englishScore, int mathScore) {
    this.name = name;
    this.englishScore = englishScore;

    this.mathScore = mathScore;
  }
  public String getName() { return name; }
  public int getEnglishScore() { return englishScore; }
  public int getMathScore() { return mathScore; }
}

@FunctionalInterface
interface Function<T> {
  public double apply(T t);
}