package com.college.dao;

import com.college.model.Student;
import com.college.util.DBConnection;
import java.sql.*;

public class StudentDAO {

    public void insertStudent(Student s) throws Exception {
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO students (name, age, branch) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, s.getName());
        ps.setInt(2, s.getAge());
        ps.setString(3, s.getBranch());

        ps.executeUpdate();
        con.close();
    }

    public void getAllStudents() throws Exception {
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM students";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                rs.getString("name ") + " " +
                rs.getInt("age ") + " " +
                rs.getString("branch ")
            );
        }
        con.close();
    }
}
