package com.holidays;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.ElephantDB;

public class Holiday implements InterfaceHolidaysDAO{
	ElephantDB db = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public Holiday(ElephantDB db){
		this.db = db;
	}
	public ElephantDB getDb() {
		return db;
	}
	public void setDb(ElephantDB db) {
		this.db = db;
	}
	@Override
	public ArrayList<HolidayObject> getAll(ElephantDB db) throws SQLException {
		List<HolidayObject> list = new ArrayList<>();
		try{
			String sql = "Select * from Holidays";
			ps = db.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new HolidayObject(rs.getInt("holidayId"),rs.getString("holidayName"),rs.getInt("locationId"),rs.getDate("holidayDate"),rs.getString("holidayRemarks"),rs.getInt("userId"),rs.getDate("holidayDateCreated")));
			}
		}catch(java.sql.SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			rs.close();
			ps.close();
		}
		return (ArrayList<HolidayObject>) list;
	}

	//date = year - 1990, month = 0-11, day = 1-31
	@Override
	public boolean addHoliday(HolidayObject holiday) throws SQLException{
		boolean flag = false;
		if(!helperFunctionContainsName(holiday.getHolidayName())){
			String sql = "Insert into holidays (holidayName,"
					+ "locationId,"
					+ "holidayDate,"
					+ "holidayRemarks,"
					+ "userId,"
					+ "holidayDateCreated) "
					+ "values (?,?,?,?,?,?)";
			try{
				ps = db.getConnection().prepareStatement(sql);
				ps.setString(1,holiday.getHolidayName());
				ps.setInt(2,holiday.getLocationId());
				ps.setDate(3, (Date) holiday.getHolidayDate());
				ps.setString(4,holiday.getHolidayRemarks());
				ps.setInt(5,holiday.getUserId());
				ps.setDate(6,(Date) holiday.getHolidayDateCreated());
				ps.executeUpdate();
				flag = true;
			}catch(java.sql.SQLException e){
				System.out.println(e.getMessage());
			}
			finally{
				ps.close();
			}
		}
		else{
			System.out.println(holiday.getHolidayName()+ " already exists.");
		}
		return flag;
	}
	@Override
	public boolean deleteHolidayById(int holidayId) throws SQLException {
		boolean flag = false;
		if(helperFunctionContainsId(holidayId)){
			String sql = "Delete from Holidays where holidayId = ?";
			try{
				ps = db.getConnection().prepareStatement(sql);
				ps.setInt(1, holidayId);
				ps.executeUpdate();
				flag = true;	
			}catch(java.sql.SQLException e){
				System.out.println(e.getMessage());
			}finally{
				ps.close();
			}
		}else{System.out.println(holidayId+" doesn't exist.");}
		return flag;
	}

	@Override
	public boolean editHoliday(HolidayObject holiday, int id) throws SQLException {
		boolean flag = false;
		try{
			String sql = "Update Holidays set holidayName=?, locationId=?, holidayDate=?, holidayRemarks=?, userId=?, holidayDateCreated=? where holidayId=?";
			ps = db.getConnection().prepareStatement(sql);
			ps.setString(1,holiday.getHolidayName());
			ps.setInt(2,holiday.getLocationId());
			ps.setDate(3, (Date) holiday.getHolidayDate());
			ps.setString(4,holiday.getHolidayRemarks());
			ps.setInt(5,holiday.getUserId());
			ps.setDate(6,(Date) holiday.getHolidayDateCreated());
			ps.setInt(7, id);
			ps.executeUpdate();
			flag = true;
		}catch(java.sql.SQLException e){
			System.out.println(e.getMessage());
		}finally{
			ps.close();
		}
		return flag;
	}
	@Override
	public void displayHoliday() throws SQLException {
		for(HolidayObject h : getAll(db)){
			System.out.println(h);
		}
	}
	@Override
	public boolean deleteHolidayByName(String holidayName) throws SQLException {
		boolean flag = false;
		if(helperFunctionContainsName(holidayName)){
			String sql = "Delete from Holidays where holidayName = ?";
			try{
				ps = db.getConnection().prepareStatement(sql);
				ps.setString(1, holidayName);
				ps.executeUpdate();
				flag = true;	
			}catch(java.sql.SQLException e){
				System.out.println(e.getMessage());
			}finally{
				ps.close();
			}
		}else{System.out.println(holidayName+" doesn't exist.");}
		return flag;
	}
		
	private boolean helperFunctionContainsName(String holidayName) throws SQLException{
		boolean flag = false;
		String sql = "Select * from Holidays where holidayName = ?";
		try{
			ps = db.getConnection().prepareStatement(sql);
			ps.setString(1, holidayName);
			flag = ps.executeQuery().next();
		}catch(java.sql.SQLException e){
			System.out.println(e.getMessage());
		}finally{
			ps.close();
		}
		return flag;	
	}
	
	private boolean helperFunctionContainsId(int holidayId) throws SQLException{
		boolean flag = false;
		String sql = "Select * from Holidays where holidayId = ?";
		try{
			ps = db.getConnection().prepareStatement(sql);
			ps.setInt(1, holidayId);
			flag = ps.executeQuery().next();
		}catch(java.sql.SQLException e){
			System.out.println(e.getMessage());
		}finally{
			ps.close();
		}
		return flag;	
	}

}
