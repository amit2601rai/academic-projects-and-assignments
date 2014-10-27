/*
 * DbModel.java
 *
 * Created on December 12, 2009, 2:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package web;
import java.sql.*;
/**
 *
 * @author genius
 */
public class DbModel {
String uname,pwd,url;
public DbModel()
{
	uname="genius";//username on the database
	pwd="maa";//corresponding password
	url="jdbc:db2://localhost:50000/ECOPS";//provide the dbconnect url in the format: "jdbc:db2:'your database name'"
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
	Connection con= DriverManager.getConnection(url,uname,pwd);
	Statement st=con.createStatement();
        
	st.executeUpdate(query);
	
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
	Connection con= DriverManager.getConnection(url,uname,pwd);
	Statement st=con.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
	return (st.executeQuery(str));
	}
	catch(Exception e)
	{
	System.out.println(e);
	return null;
	}

	}

}

