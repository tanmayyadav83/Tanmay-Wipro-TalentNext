package Module1.Assignments;

public class FCS7 {

        public static void main(String[] args) {
            char ch = 'a';

            if (Character.isLowerCase(ch)) {
                System.out.println(ch + "->" + Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                System.out.println(ch + "->" + Character.toLowerCase(ch));
            } else {
                System.out.println("Not an alphabetic character.");
            }
        }
    }


