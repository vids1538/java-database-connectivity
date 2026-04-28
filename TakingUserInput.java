import java.sql.*;
import java.util.Scanner;

public class TakingUserInput {
    private static final String url="jdbc:mysql://localhost:3306/student";
    private static final String username="root";
    private static final String password="Cimage@123";

    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //

        }catch(ClassNotFoundException e )
        {
            System.out.println("class not found exception.");
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            String query="INSERT INTO STUDENT(id,NAME,AGE) VALUES(?,?,?) ";
            PreparedStatement ps=con.prepareStatement(query);
            while(true){
                System.out.print("enter id: ");
                int id=sc.nextInt();
                sc.nextLine(); //  clear buffer and it is maindatory to clear \n
                System.out.print("enter name: ");
                String name=sc.nextLine();
                System.out.print("enter age: ");
                int age=sc.nextInt();
                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setInt(3,age);

                ps.addBatch();
                System.out.println("want to add more ? (y/n)");
                String choice=sc.next();
                if(choice.toLowerCase().equals("n"))
                {
                    break;
                }
            }
            ps.executeBatch();
            System.out.println("all student inserted");
            con.close();


        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}