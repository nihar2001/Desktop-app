import java.sql.*;

public class DB_lp {

Connection con;
PreparedStatement ps;
static int i=0;
public DB_lp()
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

public void insertDB(String s,String s1,String s2,String s3)
{

try
{
 ps=con.prepareStatement("insert into CONNECTION.lp values(?,?,?,?)");

 ps.setString(1,s2);
 ps.setString(2,s3);
 ps.setString(3,s);
 ps.setString(4,s1);
 ps.executeUpdate();
 
}
catch(SQLException e)
{
 e.printStackTrace();
 //return "FAIL";
}
}


public int displayDB(String s1,String s2)
{
try
{
 ps=con.prepareStatement("select * from CONNECTION.lp");
 ResultSet rs=ps.executeQuery();  
 while(rs.next()){

 if(s1.equals(rs.getString(1)) && s2.equals(rs.getString(2)))  
 {
		 return 1;
 }
 }  
}
catch(SQLException e)
{
 e.printStackTrace();
}
return 0;

}


}