package challengeCh10;

public class FunctionExample {
  public static double calc(FunctionEx fun) {
    double x = 10;
    double y = 4;
    return fun.apply(x, y);
  }
  public static void main(String[] args) {
    double div = calc( (x, y) -> (x / y) );
    double plus = calc( (x, y) -> (x + y) );
    double minus = calc( (x, y) -> (x - y) );
    double mutiply = calc( (x, y) -> (x * y) );
    System.out.println("div: " + div);
    System.out.println("plus: " + plus);
    System.out.println("minus: " + minus);
    System.out.println("mutiply: " + mutiply);
  }
}

@FunctionalInterface
interface FunctionEx {
  double apply(double x, double y);
}