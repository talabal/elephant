package com.holidays;

import java.sql.SQLException;
import java.util.ArrayList;

import com.database.ElephantDB;

public interface InterfaceHolidaysDAO {
	public boolean deleteHolidayByName(String holidayName) throws SQLException;
	public boolean addHoliday(HolidayObject holiday) throws SQLException;
	public ArrayList<HolidayObject> getAll(ElephantDB db) throws SQLException;
	public void displayHoliday() throws SQLException;
	public boolean deleteHolidayById(int holidayId) throws SQLException;
	boolean editHoliday(HolidayObject holiday, int id) throws SQLException;	
}
