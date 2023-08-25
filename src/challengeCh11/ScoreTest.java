package challengeCh11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ScoreTest {
  static ArrayList<Integer> scoreArray = new ArrayList<>();
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int score = 0;
    while(true) {
      System.out.print("학생의 점수를 입력하세요. (종료하려면 -1 입력) : ");
      score = in.nextInt();
      if(score < 0) {
        // 학생의 정보 출력
        printScore();
        // 최고 점수 구하기
        int maxScore = getMaxScore();
        // 성적 처리
        printGrade(maxScore);
        break;
      }
      //학생의 정보 추가
      scoreArray.add(score);
    }
  }

  static void printScore() {
    //학생의 정보 출력
    System.out.printf("전체 학생은 %d 명이다.\n", scoreArray.size());
    System.out.print("학생들의 성적 : ");
    for (int score : scoreArray) {
      System.out.print(score + " ");
    }
    System.out.println();
  }

  static void printGrade(int maxScore) {
    //학생의 성적 처리
    int score = 0;
    for (int i = 0; i < scoreArray.size(); i++) {
      score = scoreArray.get(i);
      if (score - maxScore > -10 && score - maxScore != 0) {
        System.out.printf("%d 번의 학생의 성적은 %d이며 등급은 A이다.\n", i, score);
      } else if (score - maxScore > -20 && score - maxScore != 0) {
        System.out.printf("%d 번의 학생의 성적은 %d이며 등급은 B이다.\n", i, score);
      } else {
        System.out.printf("%d 번의 학생의 성적은 %d이며 등급은 C이다.\n", i, score);
      }
    }
  }

  static int getMaxScore() {
    Integer[] sArray = scoreArray.toArray(new Integer[0]);
    Arrays.sort(sArray);
    return sArray[sArray.length -1];
  }
}
