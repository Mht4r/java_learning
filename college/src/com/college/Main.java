package com.college;

import com.college.dao.StudentDAO;
import com.college.model.Student;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your branch: ");
        String branch = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        

        Student s = new Student(name, age, branch);
        dao.insertStudent(s);

        dao.getAllStudents();
    }
}
