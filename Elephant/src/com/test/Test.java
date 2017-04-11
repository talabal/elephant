package com.test;
import java.sql.*;
import com.database.ElephantDB;
import com.holidays.Holiday;
import com.holidays.HolidayObject;
import com.table.HolidayTable;

public class Test {
	@SuppressWarnings("deprecation")
	
	public static void main(String[] args) throws SQLException{
		ElephantDB db = new ElephantDB();
		HolidayTable holidayTable = new HolidayTable(db);
		Holiday holiday = new Holiday(db);
		
		/**
		 * create and remove table function calls
		 **/
		//System.out.println(holidayTable.createHolidayTable());
		//System.out.println(holidayTable.removeHolidayTable());
		
		holiday.addHoliday(new HolidayObject("Holiday3",1,new Date(2017-1900,02,02),"remarks",12,new Date(2017-1900,02,02)));
		System.out.println(holiday.deleteHolidayByName("Holiday1"));
		System.out.println(holiday.deleteHolidayById(3));	
		System.out.println(holiday.editHoliday(new HolidayObject("EditedLast",1,new Date(2017-1900,02,02),"new",12,new Date(2017-1900,02,02)), 4));
		holiday.displayHoliday();
		db.close();
	}
}	
