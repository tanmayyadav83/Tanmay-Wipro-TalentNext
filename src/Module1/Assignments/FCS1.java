package Module1.Assignments;

public class FCS1 {
        public static void main(String[] args) {
            int num = Integer.parseInt(args[0]);

            if (num > 0) {
                System.out.println("Positive");
            } else if (num < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

    public class LastDigitCheck {
        public static boolean lastDigit(int a, int b) {
            return (a % 10) == (b % 10);
        }

        public static void main(String[] args) {
            System.out.println(lastDigit(7, 17));
            System.out.println(lastDigit(6, 17));
            System.out.println(lastDigit(3, 113));
        }
    }

}


