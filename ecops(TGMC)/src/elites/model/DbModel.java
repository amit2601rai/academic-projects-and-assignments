package elites.model;
import java.sql.*;

public class DbModel {
String uname,pwd,url;
Connection con;
public DbModel()
{
	uname="R@j";//username on the database
	pwd="123";//corresponding password
	url="jdbc:db2:ECOPS1";//provide the dbconnect url in the format: "jdbc:db2:'your database name'"
	try
	{
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		con= DriverManager.getConnection(url,uname,pwd);
		
	}
	catch(Exception e)
	{
	System.out.println(e);

	}
}
	public Connection getConnection1()
	{
	try
	{
		
	
		return con;
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
	
	System.out.print("u22");
	Statement st=con.createStatement();
	System.out.print("u33");
	st.executeUpdate(query);
	System.out.print("u44");
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
	
	System.out.print("q22");
	Statement st=con.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
	System.out.print("q33");
	return (st.executeQuery(str));
	}
	catch(Exception e)
	{
	System.out.println(e);
	return null;
	}

	}
	
	public void close()
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

}

