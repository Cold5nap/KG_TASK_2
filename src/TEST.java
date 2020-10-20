public class TEST {
    public static void main(String[] args) {
        float number = 1234.1234f;
        int degree = 0, end;
        for (; Math.pow(10, degree) < number; degree++) ;
        degree--;
        end = (int) (degree * (number % degree));
        System.out.println(number % Math.pow(10, degree));
        Float num = 123.123f;
        System.out.println(Integer.parseInt(num.toString().split("\\.")[1]));

    }
}
