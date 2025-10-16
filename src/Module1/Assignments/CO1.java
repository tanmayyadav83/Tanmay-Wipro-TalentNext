package Module1.Assignments;

public class CO1 {
        private double width;
        private double height;
        private double depth;

        // Parameterized constructor
        public CO1(double width, double height, double depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        // Method to calculate volume
        public double getVolume() {
            return width * height * depth;
        }

        public static void main(String[] args) {
            CO1 myBox = new CO1(5.0, 3.0, 2.0);
            System.out.println("Volume of the box: " + myBox.getVolume());
        }
    }


