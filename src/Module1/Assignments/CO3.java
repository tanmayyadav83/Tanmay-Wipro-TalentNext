package Module1.Assignments;

public class CO3 {

        private String name;
        private String email;
        private char gender;

        // Parameterized constructor
        public CO3(String name, String email, char gender) {
            this.name = name;
            this.email = email;
            this.gender = gender;
        }

        // Optional: Getter methods
        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public char getGender() {
            return gender;
        }

        // Optional: toString method
        public String toString() {
            return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
        }

        // Test the class
        public static void main(String[] args) {
            CO3 author = new CO3("Tanmay Yadav", "tanmay@example.com", 'M');
            System.out.println(author);
        }
    }


