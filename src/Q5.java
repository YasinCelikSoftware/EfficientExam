public class Q5 {
    public static void main(String[] args) {
        findRootsOfEquation(1,5,-6);
    }

    public static void findRootsOfEquation(int a, int b, int c){
        int delta = b * b - 4 * a * c;
        if(delta < 0)
            System.out.println("There is no roots for this equation.");

        double root1 = (-b + sqrtBabylonian(delta)) / 2 * a;
        double root2 = (-b - sqrtBabylonian(delta)) / 2 * a;

        System.out.printf("%.2f%n", root1);
        System.out.printf("%.2f", root2);
    }

    public static double sqrtBabylonian(double number) {

        if(number == 0)
            return 0;

        double guess = number / 2;
        double lastGuess;

        do {
            lastGuess = guess;
            double r = number / guess;
            guess = (guess + r) / 2;

        } while ((lastGuess - guess) >= 0.01);

        return guess;
    }
}
