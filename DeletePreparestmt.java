import java.sql.*;
public class DeletePreparestmt {
    private static final String url="jdbc:mysql://localhost:3306/teachers";
    private static final String username="root";
    private static final String password="Cimage@123";

    public static void main(String [] args)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //

        }catch(ClassNotFoundException e )
        {
            System.out.println("class not found exception.");
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
           /* String query=" DELETE FROM teacher WHERE teacher_id=?;";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,10);*/
            String query2=" UPDATE teacher set teacher_id=? WHERE teacher_id=?;";
            PreparedStatement ps=con.prepareStatement(query2);
            ps.setInt(1,10);
            ps.setInt(2,11);

            int row= ps.executeUpdate();
            if(row>0){
                System.out.println("row has been updated");
            }
            con.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}