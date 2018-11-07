package db;

import java.sql.*; //Connection, Statement, ResultSet
import javax.sql.*; //DataSource
import javax.naming.*; //lookup

public class JdbcUtil {
	public static Connection getConnection(){
		Connection con=null;
		
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			DataSource ds=(DataSource)envCtx.lookup("jdbc/mysql");
			con=ds.getConnection();
			con.setAutoCommit(false);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}//getConntection()---
	
	public static void close(Connection con){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}//close()------
	
	public static void close(Statement stmt){
		try{
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}//close()------
	
	public static void close(ResultSet rs){
		try{
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}//close()------
	
	public static void commit(Connection con){
		try{
			con.commit();
			System.out.println("commit success");
		}catch(Exception e){
			e.printStackTrace();
		}
	}//commit()------
	
	public static void rollback(Connection con){
		try{
			con.rollback();
			System.out.println("rollback success");
		}catch(Exception e){
			e.printStackTrace();
		}
	}//rollback()------
	
}//class
