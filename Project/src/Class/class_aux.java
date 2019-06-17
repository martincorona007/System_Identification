package Class;

import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Forms.jframe_login;

public class class_aux {

	
	public class_login obtenerUsuario(class_login usu) {
		class_login usuario=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			DbConnection conn=new DbConnection();//database
			
			//int resultado=0;
			String SSQL="SELECT * FROM Ctrl_user WHERE username=? AND password=?";
			// Statement stmt=connection.createStatement();
			 //Statement stmt=con.getConnection().createStatement();  
			// ResultSet rs=stmt.executeQuery(SSQL);
			con=(Connection) conn.getConnection();
			pst=(PreparedStatement) con.prepareStatement(SSQL);
			pst.setString(1,usu.getUsername());
			pst.setString(2, usu.getPassword());
			rs=pst.executeQuery();
			while(rs.next()) {
				usuario=new class_login(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(5)));
				
			}
			 
		}catch(Exception e) {
			System.out.println("error getting user");
		}
		
		return usuario;
	}
}
