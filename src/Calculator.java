
public class Calculator {
    public void add(int a, int b) {
        add(a, 7, b);
    }

    public void add(int a, int b, int c) {
        add(b, c, 10, a);
    }
    public void add(int a, int b, int c, int d) {
        System.out.println(a + b + c - d);
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.add(3, 5);

    }
}

