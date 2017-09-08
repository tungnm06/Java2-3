/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.troller;

import java.util.Scanner;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;


/**
 *
 * @author Administrator
 */
public class StudentController {
    //1. getList.
    //2. add.
    //3. edit.
    //4. delete.
    // Hàm này sẽ phải trả về danh sách SV.
    private StudentModel studentModel=new StudentModel();
    public void getList(){
        System.out.println("Get list");
        studentModel.getList();
        
    }
    
    public void addStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter student infomation. ");
        System.out.println("Please enter name");
        String name=scanner.nextLine();
        System.out.println("Please enter email");
        String email=scanner.nextLine();
        System.out.println("Name: "+name+ ", Mail: "+email);
        Student student=new Student();
        student.setName(name);
        student.setEmail(email);
        student.setId(System.currentTimeMillis());
        //. Luu thong tin sinh vien vao db.
        studentModel.insert(student);
}
    public void editStudent(){
        System.out.println("Edit");
        
    }
    public void deleteStudent(){
        System.out.println("Delete");
        
    }
}