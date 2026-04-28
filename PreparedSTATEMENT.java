import java.sql.*;
public class PreparedSTATEMENT {
    private static final String url="jdbc:mysql://localhost:3306/teachers";
    private static final String username="root";
    private static final String password="Cimage@123";

    public static void main(String [] args)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //

        }catch(ClassNotFoundException e )
            {
            e.printStackTrace();
            }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            String query="INSERT INTO TEACHER VALUES (?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,11);
            ps.setString(2,"satyam thakur  ");
            ps.setString(3,"science");
            ps.setInt(4,40);
           int row= ps.executeUpdate();
           if(row>0){
               System.out.println("row has been inserted");
           }
           con.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}