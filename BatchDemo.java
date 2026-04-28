import java.sql.*;
public class BatchDemo {
    private static final String url="jdbc:mysql://localhost:3306/STUDENT";
    private static final String username="root";
    private static final String password="Cimage@123";

    public static void main(String [] args)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // this is now old java6 and newer version auto load the driver no need of this line

        }catch(ClassNotFoundException e )
        {
            System.out.println("class not found exception.");
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            String query="INSERT INTO STUDENT(id,NAME,AGE) VALUES(?,?,?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1,1);
            ps.setString(2,"satyam");
            ps.setInt(3,22);
            ps.addBatch();

            ps.setInt(1,2);
            ps.setString(2,"shivam");
            ps.setInt(3,23);
            ps.addBatch();

            ps.setInt(1,3);
            ps.setString(2,"saurabh");
            ps.setInt(3,23);
            ps.addBatch();

            ps.setInt(1,4);
            ps.setString(2,"rishu");
            ps.setInt(3,24);
            ps.addBatch();

            ps.executeBatch();
            System.out.println("all student inserted");
            ps.close();
            con.close();




        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}