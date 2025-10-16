package Module1.Assignments;

public class CO2 {


        public static double powerInt(int num1, int num2) {
            return Math.pow(num1, num2);
        }

        public static double powerDouble(double num1, int num2) {
            return Math.pow(num1, num2);
        }

        public static void main(String[] args) {
            System.out.println("powerInt(2, 3): " + powerInt(2, 3));       // Output: 8.0
            System.out.println("powerDouble(2.5, 3): " + powerDouble(2.5, 3)); // Output: 15.625
        }
    }


