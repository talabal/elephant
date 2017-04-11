package com.table;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.database.ElephantDB;

public class HolidayTable implements InterfaceHolidayTableDAO{
	ElephantDB db = null;
	public HolidayTable(ElephantDB db){
		this.db = db;
	}
	public ElephantDB getDb() {
		return db;
	}
	public void setDb(ElephantDB db) {
		this.db = db;
	}
	@Override
	public boolean createHolidayTable() throws SQLException {
		boolean flag = false;
		PreparedStatement ps = null;
		try{
    		String sql = "Create Table Holidays (holidayId BIGSERIAL PRIMARY KEY,"
    				+ " holidayName varchar(255), "
    					+ "locationId int,"
    						+"holidayDate date,"
    							+ "holidayRemarks varchar(255),"
    								+ "userId int,"
    									+ "holidayDateCreated date)";
    		
    		ps = db.getConnection().prepareStatement(sql);
    		ps.execute();
    		flag = true;
    	}catch(java.sql.SQLException e){
    		System.out.println(e.getMessage());
    	}finally{
    		ps.close();
    	}
		return flag;
	}
	
	@Override
	public boolean removeHolidayTable() throws SQLException {
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			ps = db.getConnection().prepareStatement("Drop table Holidays");
			ps.executeUpdate();
			flag = true;
		}catch (java.sql.SQLException e){
			System.out.println(e.getMessage());
		}finally{
			ps.close();
		}
		return flag;
	}
}
