package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ElephantDB {
	static final String url = "jdbc:postgresql://stampy.db.elephantsql.com:5432/gwrzklnc";
    static final String user = "gwrzklnc";
    static final String pass = "aq8TBh8ktmefVDB57BPGgmpORlKhYNWT";
    static Connection conn = null;
    public ElephantDB(){
		init();
    }
    public Connection getConnection(){
    	return conn;
    }
    protected void init(){
    	try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Class found.");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connection established");
        }
        catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    public void close(){
    	try{
    	conn.close();
    	System.out.println("Connection closed.");
    	}
    	catch (java.sql.SQLException e) {
             System.out.println(e.getMessage() + " Catched in close function at ElephantDB class.");
        }
    }
}
