public class Q5 {
    public static void main(String[] args) {
        findRootsOfEquation(1,2,2);
    }

    public static void findRootsOfEquation(int a, int b, int c){
        int delta = b * b - 4 * a * c;
        if(delta < 0)
            System.out.println("There is no roots for this equation.");

        double root1 = (-b + java.lang.Math.sqrt(delta)) / 2 * a;
        double root2 = (-b - java.lang.Math.sqrt(delta)) / 2 * a;

        System.out.println(root1);
        System.out.println(root2);
    }
}
