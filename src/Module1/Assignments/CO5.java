package Module1.Assignments;

public class CO5 {

        public void eat() {
            System.out.println("Animal is eating");
        }

        public void sleep() {
            System.out.println("Animal is sleeping");
        }
    }

    class Bird extends CO5 {
        @Override
        public void eat() {
            System.out.println("Bird is pecking food");
        }

        @Override
        public void sleep() {
            System.out.println("Bird is roosting");
        }

        public void fly() {
            System.out.println("Bird is flying");
        }
    }

    class Main {
        public static void main(String[] args) {
            CO5 a = new CO5();
            a.eat();
            a.sleep();

            Bird b = new Bird();
            b.eat();
            b.sleep();
            b.fly();
        }
    }


