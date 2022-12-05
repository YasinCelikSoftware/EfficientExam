public class Q3 {
    public static void main(String[] args) {
        run();
    }

    public static int findFactorial(int a)
    {
        int result = 1;

        for(int i = a; i > 1; i--)
        {
            result *= i;
        }

        return result;
    }

    public static int findFirstArmstrong(int a)
    {
        for(int i = a+1; i < 2147483647; i++)
            if(isArmstrong(i))
                return i;

        return -1;
    }

    public static boolean isArmstrong(int number)
    {
        if(number < 0)
            return false;

        int total = 0;

        for(int i = number; i > 0; i /= 10)
        {
            total += pow(i % 10, countDigits(number));
        }

        return total == number;
    }

    public static int countDigits(int a)
    {
        int count = 0;

        for(int i = a; i > 0; i /= 10)
            count++;

        return count;
    }

    public static int pow(int a, int b)
    {
        int total = 1;

        for(int i=0; i < b; i++)
            total *= a;

        return total;
    }

    public static void display(int a)
    {
        if(findFirstArmstrong(a) == -1)
            System.out.printf("There is no bigger armstrong number than %d in bounds of int.", a);
        else
            System.out.printf("First bigger armstrong number than %d is : %d", a, findFirstArmstrong(a));
    }

    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Please enter the number : ");
        int number = kb.nextInt();

        display(findFactorial(number));
    }

}
