public class Q6 {
    public static void main(String[] args) {

        run();

    }

    public static int countDays(int firstDay, int firstMonth, int firstYear, int lastDay, int lastMonth, int lastYear)
    {
        int totalDays = 0;

        if (isLastAndFirstDateValid(firstDay, firstMonth, firstYear, lastDay, lastMonth, lastYear))
            return -1;


        monthLoop:
        for (int i = firstMonth; i <= 12; i++)
        {
            for (int j = firstDay + 1; j <= getDays(i, firstYear); j++) {
                totalDays++;
                if (i == lastMonth && j == lastDay)
                    break monthLoop;
            }

            firstDay = 0;

            if (i == 12)
            {
                i = 0;
                firstYear++;
            }
        }

        totalDays = totalDays + countDaysOfYears(firstYear, lastYear);

        return totalDays;
    }

    public static int countDaysOfYears(int firstYear, int lastYear)
    {
        int count = 0;

        for (int i = firstYear + 1; i <= lastYear; i++)
            if (isLeapYear(i))
                count++;

        return (lastYear - firstYear) * 365 + count;
    }

    public static boolean isValidDate(int firstDay, int firstMonth, int firstYear)
    {
        return 1 <= firstDay && firstDay <= 31 && 1 <= firstMonth && firstMonth <= 12 && firstDay <= getDays(firstMonth, firstYear);
    }

    public static int getDays(int month, int year)
    {
        int day = 31;

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                day = 28;
                if (isLeapYear(year))
                    ++day;
        }

        return day;
    }

    public static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static boolean isFirstDateSmallerThanLastDate(int firstDay, int firstMonth, int firstYear, int lastDay, int lastMonth, int lastYear)
    {
        if (lastYear > firstYear)
            return true;

        if (lastYear == firstYear)
        {
            if (lastMonth > firstMonth)
                return true;
            else if (lastMonth == firstMonth) {
                return lastDay >= firstDay;
            }
        }

        return false;
    }

    public static boolean isLastAndFirstDateValid(int firstDay, int firstMonth, int firstYear, int lastDay, int lastMonth, int lastYear)
    {
        return !isValidDate(lastDay, lastMonth, lastYear) || !isValidDate(firstDay, firstMonth, firstYear) || !isFirstDateSmallerThanLastDate(firstDay, firstMonth, firstYear, lastDay, lastMonth, lastYear);
    }

    public static int lessonHours(int days){
        return days / 7 * 4;
    }

    public static int numbersOfHomeworks(int days){
        return days / 11;
    }

    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.println("Please enter the first date's day : ");
        int firstDay = kb.nextInt();

        System.out.println("Please enter the first date's month : ");
        int firstMonth = kb.nextInt();

        System.out.println("Please enter the first date's year : ");
        int firstYear = kb.nextInt();

        System.out.println("Please enter the last date's day : ");
        int lastDay = kb.nextInt();

        System.out.println("Please enter the last date's month : ");
        int lastMonth = kb.nextInt();

        System.out.println("Please enter the last date's year : ");
        int lastYear = kb.nextInt();

        int numberOfDays = countDays(firstDay, firstMonth, firstYear, lastDay, lastMonth, lastYear);

        display(numberOfDays);


    }

    public static void display(int numberOfDays)
    {
        if(numberOfDays == -1)
            System.out.println("\nYour dates are invalid. Please check and try again.");
        else
            System.out.printf("\nThere is %d hours of lesson and %d homeworks in %d days in Efficient House.", lessonHours(numberOfDays), numbersOfHomeworks(numberOfDays),  numberOfDays);
    }

}
