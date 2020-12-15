import java.sql.*;

public class DB_Conn{
    private static final String url = "jdbc:mysql://benwyw.com:3306/dbksy8stuuy57c";
    private static final String user = "usp9b296je2qn";
    private static final String password = "7%?b4c*9u4@D";
    public static String noob = "Chris";

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            if(connection != null) {
                System.out.println("Connected to PostgreSQL server successfully!");
            }else{
                System.out.println("Failed to connect PostgreSQL server");
            }

            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from course_timetable_2017");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
		/*
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"","","");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from course_timetable_2017");  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  */
    }
}  