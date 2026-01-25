package com.college;

import com.college.dao.StudentDAO;
import com.college.model.Student;

public class Main {
    public static void main(String[] args) throws Exception {

        StudentDAO dao = new StudentDAO();

        Student s = new Student("Mohit", 21, "CSE");
        dao.insertStudent(s);

        dao.getAllStudents();
    }
}

