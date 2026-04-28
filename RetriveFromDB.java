/*  in this program i perform only retrival of data from the database and print it in the program */
import java.sql.*;
public class RetriveFromDB {
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
            String query="select * from teacher";
            ResultSet resultset=st.executeQuery(query);
            while(resultset.next()){
                String name=resultset.getString("name");
                String subject=resultset.getString("subject");
                int time_in_minutes=resultset.getInt("time_in_minutes");
                System.out.println("name :"+name);
                System.out.println("subject :"+subject);
                System.out.println("time :"+time_in_minutes);

            }
            con.close();

        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
