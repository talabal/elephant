package com.table;
import java.sql.SQLException;

public interface InterfaceHolidayTableDAO {
	public boolean removeHolidayTable() throws SQLException;
	public boolean createHolidayTable() throws SQLException;
}
