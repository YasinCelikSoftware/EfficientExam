public class Q1 {
    public static void main(String[] args)
    {
        run();
    }

    public static int countPalindrome (int a)
    {
        long total = a + reverseNumber(a);
        int count = 1;

        while(!(total == reverseNumber(total)))
        {
            total += reverseNumber(total);
            count++;
        }
        return count;
    }

    public static long reverseNumber(long number)
    {
        long reverse = 0;
        long numberHolder;
        while(number > 0)
        {
            numberHolder = number % 10;
            reverse = reverse * 10 + numberHolder;
            number /= 10;
        }

        return reverse;
    }

    public static void display(int count, int number)
    {
        System.out.printf("Longest chain is %d and this chain formed by the number %d", count, number);
    }

    public static void run()
    {
        int maxChain = 0;
        int number = 0;
        for(int i = 10; i < 101; i++)
        {
            int chain = countPalindrome(i);
            if(maxChain < chain)
            {
                maxChain = chain;
                number = i;
            }
        }
        display(maxChain,number);
    }
}
