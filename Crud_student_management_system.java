import java.sql.*;
import java.util.Scanner;

public class Crud_student_management_system {
    private static final String url="jdbc:mysql://localhost:3306/student";
    private static final String username="root";
    private static final String password="Cimage@123";

    static Connection con;
    static Scanner sc=new Scanner(System.in);

    // add student..
    public static void addStudent(){
        try{

            System.out.println("Enter Student ID : ");
            int id=sc.nextInt();
            sc.nextLine(); // consume buffer
            System.out.println("Enter Student name : ");
            String name =sc.nextLine();
            System.out.println("Enter Student AGE : ");
            int age=sc.nextInt();
            sc.nextLine();
            String query="INSERT INTO student (id,name, age) VALUES (?, ?, ?);";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,age);

            ps.executeUpdate();
            System.out.println("Student added successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // delete student
    public static void deleteStudent(){
        try{

            String query="DELETE FROM student WHERE id=?;";
            System.out.println("enter id : ");
            int id=sc.nextInt();
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Student deleted successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // print student
    public static void printStudent(){
        try{

            String query="SELECT * FROM student ;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {

                int id =rs.getInt("id");
                String name =rs.getString("name");
                int age=rs.getInt("age");
                System.out.println("id : "+id);
                System.out.println("name : "+name);
                System.out.println("age : "+age);
                System.out.println("---------------------");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String [] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e ){
            System.out.println("class not found exception.");
        }
        try{
             con=DriverManager.getConnection(url,username,password);
             System.out.println("              -: Connected to database successfully :-");
            System.out.println(":::::::::::::::: this is student management system ::::::::::::::::");

            int choice;
            do {
                System.out.println("1. add student");
                System.out.println("2. delete student");
                System.out.println("3  view all student");
                System.out.println("4  exit student management");
                System.out.print("Enter choice : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        deleteStudent();
                        break;
                    case 3:
                        printStudent();
                        break;
                    case 4:
                        System.out.println("exit successfully ");
                        System.out.print(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            } while(choice != 4);
                 con.close();


        }catch(SQLException e){
            System.out.println("SQLException in Crud_student_management_system");
        }

    }
}
