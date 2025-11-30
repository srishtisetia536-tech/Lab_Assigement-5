import java.util.*;

abstract class Person {
    String name;
    String email;
    public abstract void displayInfo();
}

class Student extends Person {
    int rollNo;
    String course;
    double marks;
    String grade;

    public Student(int rollNo, String name, String email, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    public void calculateGrade() {
        if (marks >= 90) grade = "A+";
        else if (marks >= 80) grade = "A";
        else if (marks >= 70) grade = "B";
        else if (marks >= 60) grade = "C";
        else if (marks >= 50) grade = "D";
        else grade = "F";
    }

    @Override
    public void displayInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println();
    }
}

interface RecordActions {
    void addStudent();
    void viewAllStudents();
    void searchStudent();
    void deleteStudent();
    void updateStudent();
    void sortByMarks();
}

class StudentManager implements RecordActions {
    ArrayList<Student> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public StudentManager() {
        list.add(new Student(301,"Simran","simran@mail.com","MBA",93.2));
        list.add(new Student(302,"Vivek","vivek@mail.com","B.Tech",85.6));
        list.add(new Student(303,"Priya","priya@mail.com","BCA",78.4));
        list.add(new Student(304,"Aditya","aditya@mail.com","MCA",64.7));
    }

    public void addStudent() {
        System.out.print("Enter Roll No: ");
        int r = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        String n = sc.nextLine();
        System.out.print("Enter Email: ");
        String e = sc.nextLine();
        System.out.print("Enter Course: ");
        String c = sc.nextLine();
        System.out.print("Enter Marks: ");
        double m = sc.nextDouble();
        list.add(new Student(r,n,e,c,m));
        System.out.println("Student Added.\n");
    }

    public void viewAllStudents() {
        for (Student s : list) s.displayInfo();
    }

    public void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int r = sc.nextInt();
        for (Student s : list) {
            if (s.rollNo == r) {
                s.displayInfo();
                return;
            }
        }
        System.out.println("Student Not Found.\n");
    }

    public void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int r = sc.nextInt();
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().rollNo == r) {
                it.remove();
                System.out.println("Deleted.\n");
                return;
            }
        }
        System.out.println("Student Not Found.\n");
    }

    public void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int r = sc.nextInt();
        for (Student s : list) {
            if (s.rollNo == r) {
                System.out.print("Enter New Marks: ");
                s.marks = sc.nextDouble();
                s.calculateGrade();
                System.out.println("Updated.\n");
                return;
            }
        }
        System.out.println("Student Not Found.\n");
    }

    public void sortByMarks() {
        list.sort((a,b)->Double.compare(b.marks,a.marks));
        System.out.println("Sorted by Marks:\n");
        viewAllStudents();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();

        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student Marks");
            System.out.println("6. Sort by Marks");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: sm.addStudent(); break;
                case 2: sm.viewAllStudents(); break;
                case 3: sm.searchStudent(); break;
                case 4: sm.deleteStudent(); break;
                case 5: sm.updateStudent(); break;
                case 6: sm.sortByMarks(); break;
                case 7: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.\n");
            }
        }
    }
}
