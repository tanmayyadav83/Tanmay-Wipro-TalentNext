package Module1.Assignments;

public class CO4 {

        private String name;
        private String email;
        private char gender;

        public CO4(String name, String email, char gender) {
            this.name = name;
            this.email = email;
            this.gender = gender;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
        public char getGender() { return gender; }

        public String toString() {
            return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
        }
    }

    class Book {
        private String name;
        private CO4 author;
        private double price;
        private int qtyInStock;

        public Book(String name, CO4 author, double price, int qtyInStock) {
            this.name = name;
            this.author = author;
            this.price = price;
            this.qtyInStock = qtyInStock;
        }

        public String getName() { return name; }
        public CO4 getAuthor() { return author; }
        public double getPrice() { return price; }
        public int getQtyInStock() { return qtyInStock; }

        public void setName(String name) { this.name = name; }
        public void setAuthor(CO4 author) { this.author = author; }
        public void setPrice(double price) { this.price = price; }
        public void setQtyInStock(int qtyInStock) { this.qtyInStock = qtyInStock; }

        public String toString() {
            return "Book[name=" + name + ", " + author + ", price=" + price + ", qtyInStock=" + qtyInStock + "]";
        }

        public static void main(String[] args) {
            CO4 author = new CO4("Tanmay Yadav", "tanmay@example.com", 'M');


        }
    }
