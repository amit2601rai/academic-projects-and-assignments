
package elites.model;
 
import java.sql.*;

public class XmlModel {
String uname,pwd,url;
public XmlModel()
{
	uname="R@j";//username on the database
	pwd="123";//corresponding password
	url="jdbc:db2:ECOPS1";//provide the dbconnect url in the format: "jdbc:db2:'your database name'"
}
	public Connection getConnection1()
	{
	try
	{
	Class.forName("com.ibm.db2.jcc.DB2Driver");
	return DriverManager.getConnection(url,uname,pwd);
	}
	catch(Exception e)
	{
	return null;

	}

	}


    public void executeDML(String query)
	{
	try
	{
	Class.forName("com.ibm.db2.jcc.DB2Driver");
	System.out.print("11");
	Connection con= DriverManager.getConnection(url,uname,pwd);
	System.out.print("22");
	Statement st=con.createStatement();
	System.out.print("33");
	st.executeUpdate(query);
	System.out.print("44");
    }
	catch(Exception e)
		{System.out.print("in catch");
		e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String str)
	{
	try
	{
	Class.forName("com.ibm.db2.jcc.DB2Driver");
	System.out.print("111");
	Connection con= DriverManager.getConnection(url,uname,pwd);
	System.out.print("222");
	Statement st=con.createStatement();
	System.out.print("333");
	return (st.executeQuery(str));
	}
	catch(Exception e)
	{System.out.print("in catch");
	System.out.println(e);
	return null;
	}

	}
	
	
	

}



