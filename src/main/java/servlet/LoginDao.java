package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    public static boolean validate(LoginBean bean) {
    	boolean status = false;
    	try {
    		Connection con = ConnectionProvider.getCon();
    		
    		PreparedStatement ps = con.prepareStatement("select * from user_data where email=? and password=?");
    	   
    		ps.setString(1, bean.getEmail());
    		ps.setString(2, bean.getPassward());
    		
    		ResultSet rs = ps.executeQuery();
    		status = rs.next();
    	}catch(Exception e) {
    		
    	}
    	
    	return status;
    }
}
