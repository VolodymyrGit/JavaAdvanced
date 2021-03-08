public class Calculator {
    public static int counter = 0;

    public int sum(int a, int b) {
        counter++;
        return a + b;
    }

    public double div(int a, int b) throws Exception {
        counter++;
        if (b == 0) {
            throw new Exception();
        }
        return a / b;
    }
}
