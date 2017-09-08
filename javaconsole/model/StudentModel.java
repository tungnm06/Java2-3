/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaconsole.enity.Student;

/**
 *
 * @author Administrator
 */
public class StudentModel {

   

    // Insert thông tin sinh viên vao bảng student trong database studentmanager
    //insert into student(name.email....) values("Hung, Hung@gmail.com, ....)
    public void insert(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            Statement stt = cnn.createStatement();
            String sqlQuery = ("INSERT INTO "
                    + "student"
                    + "(name, email, roll_number, class_name, status)"
                    + "VALUES "
                    + "('"
                    + student.getName() + "', '"
                    + student.getEmail() + "', '"
                    + student.getRollNumber() + "','"
                    + student.getClassName() + "', "
                    + student.getStatus() + ")");
            System.out.println("Thực hiện lệnh SQL: " + sqlQuery);

            stt.execute(sqlQuery);
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình insert dữ liệu. " + e.getMessage());
        }

    }

    private void deleteId(int id) {
        String sqlCommand = "delete from student where id = ?";

        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement pst = cnn.prepareStatement(sqlCommand);

            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Delete success");

        } catch (SQLException e) {
            System.err.println("delete error !" + e.getMessage());
        }

    }

    private void updateId(int id, Student s) {
        String sqlCommand = "update student set name=?, email=?, roll_number=?, class_name=?,"
                + " status=? where id=?";

        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement pst = cnn.prepareStatement(sqlCommand);
            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setString(3, s.getRollNumber());
            pst.setString(4, s.getClassName());
            pst.setInt(5, s.getStatus());
            pst.setInt(6, s.getId());

            if (pst.executeUpdate() > 0) {
                System.out.println("updatesuccess");
            } else {
                System.out.println("update error !");
            }
        } catch (SQLException e) {
            System.err.println("update error !" + e.getMessage());
        }

    }

//Truy vấn dữ liệu trong bảng student, trả về một ArrayList các phần tử student.
    public ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {

            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs;
            rs = stt.executeQuery("select * from student;");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));

                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setClassName(rs.getString("class_name"));

                student.setStatus(rs.getInt("status"));
                listStudent.add(student);

            }

        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình lấy danh sách sinh viên " + e.getMessage());
        }
        return listStudent;

    }

    public static void main(String[] args) {
        StudentModel studentModel = new StudentModel();
        ArrayList<Student> listStudent = studentModel.getListStudent();
     //   for (Student student : listStudent) {
            // System.out.println(student.getName());
             studentModel.deleteId(7);
            studentModel.updateId(3, new Student(3, "Dung", "Dung123@gmail.com", "A123", "C1702G", 1));
      //  }

        // studentModel.updateId(2, new Student(2,"Dung", "Dung123@gmail.com", "A123", "C1702G",1));
        //   StudentModel studentModel = new StudentModel();
        //   Student student = new Student();
        //   student.setName("viethung");
        //   student.setEmail("viethung@gmail.com");
        //   student.setRollNumber("A1234");
        //   student.setClassName("C1702G");
        //   student.setStatus(1);
        //   studentModel.insert(student);
    }




 



    

    //   public static List<Student> getListStudent(){
    //     List<Student> liststudent= new ArrayList<>();
    //   ResultSet rs;
    //    int total;
    //   try{
    //        rs=DAO.getConnection().createStatement().executeQuery("select *form student");
    //       while(rs.next()){
    //       Student student=new Student();
    //       student.setId(Integer.valueOf(s))
    //  }
    //  }
    //  }
}
