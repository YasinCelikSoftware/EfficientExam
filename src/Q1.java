public class Q1 {
    public static void main(String[] args) {
        System.out.println(countPalindrom(349, reverseNumber(349)));
    }

    public static int countPalindrom(int a, int b){
        int total = a + b;
        int count = 1;
        if(!isPalindrome(total)) {
            count++;
            countPalindrom(total, reverseNumber(total));
        }
        return count;
    }

    public static int reverseNumber(int number){
        int reverse = 0;
        int numberHolder;
        for(int i = countDigits(number); i > 0; i--){
            numberHolder = number % 10;
            reverse += numberHolder * pow(10,countDigits(number)-1);
            number /= 10;
        }

        return reverse;
    }

    public static int countDigits(int a) {

        int count = 0;

        for (int i = a; i > 0; i /= 10)
            count++;

        return count;

    }

    public static int pow(int a, int b) {
        int result = 1;

        for (int x = 0; x < b; x++)
            result *= a;

        return result;

    }

    public static boolean isPalindrome(int a){
        return a == reverseNumber(a);
    }
}
