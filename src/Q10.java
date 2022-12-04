public class Q10 {
    public static void main(String[] args) {
        run();
    }

    public static double findExponancial(int a){
        double result = 1 + a;
        double tempResult;
        for(int i = 2; i<2147483647; i++){
            tempResult = result;
            result += (double)pow(a,i) / findFactorial(i);
            if((result - tempResult) < 0.1)
                return result;

        }
        return result;
    }

    public static int findFactorial(int a){
        int result = 1;
        for(int i = a; i > 1; i--){
            result *= i;
        }
        return result;
    }

    public static int pow(int a, int b) {
        int result = 1;

        for (int x = 0; x < b; x++)
            result *= a;

        return result;
    }

    public static void run(){
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Please enter the x (e^x) : ");
        int x = kb.nextInt();
        display(findExponancial(x));
    }

    public static void display(double a){
        System.out.printf("e^x = %.3f", a);
    }
}
