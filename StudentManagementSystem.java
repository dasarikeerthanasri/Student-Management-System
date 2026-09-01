package project1;

import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int regNo;
    String name;
    String branch;
    int marks;
    int totalClasses;
    int attendedClasses;

    Student(int regNo, String name, String branch, int marks,
            int totalClasses, int attendedClasses) {

        this.regNo = regNo;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    double getAttendance() {
        if (totalClasses == 0) {
            return 0;
        }

        return ((double) attendedClasses / totalClasses) * 100;
    }

    char getGrade() {

        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void display() {

        System.out.println("--------------------------------");
        System.out.println("Registration No : " + regNo);
        System.out.println("Name            : " + name);
        System.out.println("Branch          : " + branch);
        System.out.println("Marks           : " + marks);
        System.out.println("Grade           : " + getGrade());
        System.out.printf("Attendance      : %.2f%%\n", getAttendance());
        System.out.println("--------------------------------");
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // 1. Add Student
    static void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        System.out.print("Enter Student Name: ");
        String name = sc.next();

        System.out.print("Enter Branch: ");
        String branch = sc.next();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        System.out.print("Enter Total Classes: ");
        int totalClasses = sc.nextInt();

        System.out.print("Enter Attended Classes: ");
        int attendedClasses = sc.nextInt();

        if (attendedClasses > totalClasses) {
            System.out.println("Attended classes cannot be greater than total classes!");
            return;
        }

        Student student = new Student(
                regNo,
                name,
                branch,
                marks,
                totalClasses,
                attendedClasses
        );

        students.add(student);

        System.out.println("Student Added Successfully!");
    }

    // 2. Display Students
    static void displayStudents() {

        System.out.println("\n===== STUDENT DETAILS =====");

        if (students.isEmpty()) {
            System.out.println("No Students Available!");
            return;
        }

        for (Student student : students) {
            student.display();
        }
    }

    // 3. Search Student
    static void searchStudent() {

        System.out.println("\n===== SEARCH STUDENT =====");

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student student : students) {

            if (student.regNo == regNo) {

                System.out.println("Student Found!");
                student.display();
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 4. Update Student
    static void updateStudent() {

        System.out.println("\n===== UPDATE STUDENT =====");

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student student : students) {

            if (student.regNo == regNo) {

                System.out.print("Enter New Name: ");
                student.name = sc.next();

                System.out.print("Enter New Branch: ");
                student.branch = sc.next();

                System.out.print("Enter New Marks: ");
                student.marks = sc.nextInt();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 5. Delete Student
    static void deleteStudent() {

        System.out.println("\n===== DELETE STUDENT =====");

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).regNo == regNo) {

                students.remove(i);

                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 6. Calculate Grade
    static void calculateGrade() {

        System.out.println("\n===== CALCULATE GRADE =====");

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student student : students) {

            if (student.regNo == regNo) {

                System.out.println("Marks : " + student.marks);
                System.out.println("Grade : " + student.getGrade());
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 7. Calculate Percentage
    static void calculatePercentage() {

        System.out.println("\n===== CALCULATE PERCENTAGE =====");

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student student : students) {

            if (student.regNo == regNo) {

                double percentage = student.marks;

                System.out.println("Percentage : " + percentage + "%");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 8. Attendance
    static void attendance() {

        System.out.println("\n===== ATTENDANCE =====");

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student student : students) {

            if (student.regNo == regNo) {

                double percentage = student.getAttendance();

                System.out.printf("Attendance : %.2f%%\n", percentage);

                if (percentage >= 75) {
                    System.out.println("Status : Eligible");
                } else {
                    System.out.println("Status : Not Eligible");
                }

                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 9. Login
    static boolean login() {

        System.out.println("\n==============================");
        System.out.println("       STUDENT LOGIN");
        System.out.println("==============================");

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        if (username.equals("student") && password.equals("1234")) {

            System.out.println("Login Successful!");
            return true;

        } else {

            System.out.println("Invalid Username or Password!");
            return false;
        }
    }

    // Main Method
    public static void main(String[] args) {

        if (!login()) {
            return;
        }

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Calculate Percentage");
            System.out.println("8. Attendance");
            System.out.println("9. Exit");
            System.out.println("====================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    calculateGrade();
                    break;

                case 7:
                    calculatePercentage();
                    break;

                case 8:
                    attendance();
                    break;

                case 9:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 9);

        sc.close();
    }
}
