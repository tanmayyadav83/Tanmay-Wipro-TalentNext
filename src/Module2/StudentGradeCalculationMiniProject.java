package Module2;

import java.util.*;

class StudentGradeCalculation {

    // ----------------- Custom Exception Classes -----------------
    static class NullStudentException extends Exception {
        public NullStudentException() {
            super("Student object is null");
        }
    }

    static class NullNameException extends Exception {
        public NullNameException() {
            super("Student name is null");
        }
    }

    static class NullMarksArrayException extends Exception {
        public NullMarksArrayException() {
            super("Marks array is null");
        }
    }

    // ----------------- Student Class -----------------
    static class Student {
        private String name;
        private int[] marks;
        private String grade;

        public Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int[] getMarks() { return marks; }
        public void setMarks(int[] marks) { this.marks = marks; }

        public String getGrade() { return grade; }
        public void setGrade(String grade) { this.grade = grade; }
    }

    // ----------------- StudentReport Class -----------------
    static class StudentReport {
        public String findGrade(Student student) {
            int[] marks = student.getMarks();
            int sum = 0;
            for (int mark : marks)
                sum += mark;

            if (sum < 150)
                return "F";
            else if (sum < 200)
                return "D";
            else
                return "A";
        }

        public String validate(Student s) throws NullStudentException, NullNameException, NullMarksArrayException {
            if (s == null)
                throw new NullStudentException();
            if (s.getName() == null)
                throw new NullNameException();
            if (s.getMarks() == null)
                throw new NullMarksArrayException();

            return findGrade(s);
        }
    }

    // ----------------- StudentService Class -----------------
    static class StudentService {
        public int findNumberOfNullMarksArray(Student[] data) {
            int count = 0;
            for (Student s : data) {
                if (s != null && s.getMarks() == null)
                    count++;
            }
            return count;
        }

        public int findNumberOfNullName(Student[] data) {
            int count = 0;
            for (Student s : data) {
                if (s != null && s.getName() == null)
                    count++;
            }
            return count;
        }

        public int findNumberOfNullObjects(Student[] data) {
            int count = 0;
            for (Student s : data) {
                if (s == null)
                    count++;
            }
            return count;
        }
    }

    // ----------------- Main Method -----------------
    public static void main(String[] args) {
        Student[] data = new Student[10];

        // Initializing sample data
        data[0] = new Student("Sekar", new int[]{35, 35, 35});
        data[1] = new Student(null, new int[]{11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);
        data[4] = new Student("Ravi", new int[]{100, 50, 50});
        data[5] = new Student("Meena", new int[]{20, 30, 40});
        data[6] = null;
        data[7] = new Student(null, null);
        data[8] = new Student("Kiran", new int[]{90, 80, 70});
        data[9] = new Student("John", new int[]{40, 40, 40});

        StudentService service = new StudentService();
        StudentReport report = new StudentReport();

        System.out.println("GRADE CALCULATION REPORT");
        System.out.println("=========================\n");

        for (int i = 0; i < data.length; i++) {
            try {
                String grade = report.validate(data[i]);
                data[i].setGrade(grade);
                System.out.println("Grade of " + data[i].getName() + ": " + grade);
            } catch (Exception e) {
                System.out.println("Exception at index " + i + ": " + e.getMessage());
            }
        }

        System.out.println("\nNULL VALUE COUNTS");
        System.out.println("==================");
        System.out.println("Number of Null Name: " + service.findNumberOfNullName(data));
        System.out.println("Number of Null Marks Array: " + service.findNumberOfNullMarksArray(data));
        System.out.println("Number of Null Student Objects: " + service.findNumberOfNullObjects(data));
    }
}

