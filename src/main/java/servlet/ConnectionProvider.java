package servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider{
    private static Connection con = null;
    
      static {
    	try {
    		Class.forName(DRIVER);
    		con = DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
      }
      public static  Connection getCon() {
    	  return con;
      }
    }

