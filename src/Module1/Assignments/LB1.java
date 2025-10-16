package Module1.Assignments;

public class LB1 {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Please enter exactly two command line arguments: <CompanyName> <City>");
            return;
        }

        String company = args[0];
        String city = args[1];

        System.out.println(company + " Technologies " + city);
    }
}

