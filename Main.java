import java.sql.*;
public class Main {
    private static final String url="jdbc:mysql://localhost:3306/teachers";
    private static final String username="root";
    private static final String password="Cimage@123";

    public static void main(String[] args) {
        System.out.println("..............THIS IS JDBC PROGRAM............. ");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            Statement st=con.createStatement();
            String query="UPDATE TEACHER SET time_in_minutes=40 ;";
            int row=st.executeUpdate(query);
            if(row>0){
                System.out.println(row+" rows updated");
            }
            con.close();





        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
