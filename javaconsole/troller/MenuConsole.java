/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.troller;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class MenuConsole {

    int result;

    public void divide(int num1, int num2) throws ArithmeticException{

      

            result = num1 / num2;

        System.out.println(result);

    }

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.createMenu();
        
     try{menu.divide(1, 2);
     
     }catch(ArithmeticException e){
         System.out.println("num 2 phai khac 0");
     }
       

    }
public void divide1(int num1,int num2) throws ArithmeticException{
    try {
        if(num2==0){
            throw new ArithmeticException();
            
        }
          result=num1/num2;
          System.out.println(result);


        
    } catch (ArithmeticException e) {
         System.out.println("num 2 phai khac 0");
    }
}
public void divede2(int num1, int num2){
    try {
        result=num1/num2;
    } catch (ArithmeticException e) {
        System.out.println("num 2 phai khac 0");
    }
}
    public void createMenu() {
        while (true) {

            System.out.println("======Student Manager======");
            System.out.println("1. Student list.");
            System.out.println("2. Add student.");
            System.out.println("3. Edit student.");
            System.out.println("4. Delete student.");
            System.out.println("5. Exit");
            System.out.println("==========================");
            System.out.println("Please enter your choice:");
            // Yêu cầu người dùng nhập chuỗi kí tự, gán già trị người dùng nhập vào
            //ra biến kiểu chuỗi tên là strChoice.
            Scanner scanner = new Scanner(System.in);
            String strChoice = scanner.nextLine();
            System.out.println("strChoice");
            // Kiểm tra dữ liệu người dùng nhập vào có là số hay không ?
            // Trong trường hợp không phải là số thì thông báo cho người dùng và bắt đầu lặp lại vòng lặp.
            int choice = 0;
            try {
                // Ep kiểu của biến strChoice về int.
                choice = Integer.parseInt(strChoice);

            } catch (java.lang.NumberFormatException e) {
                //Cần phần lưu log lỗi ở đấy.

                System.err.println("Please enter a number");
                continue;
            }

            StudentController studentController = new StudentController();

            if (choice == 5) {
                break;
            } else {
                switch (choice) {
                    case 1:
                        // Do some thing .Please do something.
                        studentController.getList();

                        break;
                    case 2:
                        // Do some thing .Please do something.
                        studentController.addStudent();

                        break;
                    case 3:
                        // Do some thing .Please do something.
                        studentController.editStudent();
                        break;
                    case 4:
                        // Do some thing .Please do something.
                        studentController.deleteStudent();
                        break;
                    default:
                        // Do some thing .Please do something.
                        System.out.println("Please enter number from 1 to 5");
                        break;
                }
            }

        }

    }
}
