package Actividades.UD6.Act62;

public class Main {
    public static void main(String[] args) {
        printReverseFrom(10);
        System.out.println(naturalSum(7));
        System.out.println(fibonacci(7));
        System.out.println(mcd(234, 543));
    }

    public static void printReverseFrom(int number) {
        System.out.print("(");
        for (int i = number; i > 0; i--) {
            if (i == 1) {
                System.out.print(i);
                break;
            }
            System.out.print(i + ", ");
        }
        System.out.println(")");
    }

    public static int naturalSum(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int mcd(int a, int b) {
        if (b == 0) return a;
        else return mcd(b, a % b);
    }
}
