import java.sql.*;
public class SelectPreparestmt {
    private static final String url = "jdbc:mysql://localhost:3306/teachers";
    private static final String username = "root";
    private static final String password = "Cimage@123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //

        } catch (ClassNotFoundException e) {
            System.out.println("class not found exception.");
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query=" SELECT * FROM TEACHER;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery(query);
            while(rs.next()){
                System.out.println("id="+rs.getInt("teacher_id"));
                System.out.println("name="+rs.getString("name"));
                System.out.println("subject="+rs.getString("subject"));
                System.out.println("time in minutes ="+rs.getString("time_in_minutes"));
                System.out.println("-------------------------------------");
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}