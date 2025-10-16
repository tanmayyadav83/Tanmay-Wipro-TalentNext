package Module1.Assignments;

public class LB2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide exactly one argument.");
            return;
        }
        System.out.println("Welcome " + args[0]);
    }
}

