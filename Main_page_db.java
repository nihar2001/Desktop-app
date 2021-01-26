
import java.sql.*;
public class Main_page_db {
	
static Connection con;
static PreparedStatement ps;
static int i=0;
public Main_page_db()
{
con=null;
try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","niharsaini");
 System.out.println("connection done");
}
catch(Exception e)
{
 System.out.println(e);
}
}

public static  void displayDB(String s,String s1,String d[][])
{
try
{ int i=0;
 ps=con.prepareStatement("select * from CONNECTION.FLIGHT ");
 ResultSet rs=ps.executeQuery();  
 while(rs.next()){  
	 if(s.equals(rs.getString(4))&&s1.equals(rs.getString(5)))
	 {
	 d[i][0]=rs.getString(1);
	 d[i][1]=rs.getString(2);
	 d[i][2]=rs.getString(3);
	 d[i][3]=rs.getString(4);
	 d[i][4]=rs.getString(5);
	i++;
	 }	 
 else
		 continue;
 }  
}
catch(SQLException e)
{
 e.printStackTrace();
 //return "FAIL";
}


}
}