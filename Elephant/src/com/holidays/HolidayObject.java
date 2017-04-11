package com.holidays;

import java.util.Date;

public class HolidayObject {
	
	private int holidayId;			//holiday primary key
	private String holidayName;
	private int locationId;
	private Date holidayDate;
	private String holidayRemarks;
	private int userId;				//foreign key
	private Date holidayDateCreated;
	public HolidayObject(){
	}
	public HolidayObject(int holidayId, String holidayName, int locationId, Date holidayDate, String holidayRemarks, int userId, Date holidayDateCreated) {
		this.holidayId = holidayId;
		this.holidayName = holidayName;
		this.locationId = locationId;
		this.holidayDate = holidayDate;
		this.holidayRemarks = holidayRemarks;
		this.userId = userId;
		this.holidayDateCreated = holidayDateCreated;
	}
	public HolidayObject(String holidayName, int locationId, Date holidayDate, String holidayRemarks, int userId, Date holidayDateCreated) {
		this.holidayName = holidayName;
		this.locationId = locationId;
		this.holidayDate = holidayDate;
		this.holidayRemarks = holidayRemarks;
		this.userId = userId;
		this.holidayDateCreated = holidayDateCreated;
	}
	public int getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public Date getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}
	public String getHolidayRemarks() {
		return holidayRemarks;
	}
	public void setHolidayRemarks(String holidayRemarks) {
		this.holidayRemarks = holidayRemarks;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getHolidayDateCreated() {
		return holidayDateCreated;
	}
	public void setHolidayDateCreated(Date holidayDateCreated) {
		this.holidayDateCreated = holidayDateCreated;
	}
	@Override
	public String toString(){
		return "\nHolidayID:  "+ this.holidayId +
				"\nHolidayName: "+ this.holidayName +
				"\nLocationID: "+ this.locationId +
				"\nHolidayDate: "+ this.holidayDate +
				"\nHolidayRemarks: "+ this.holidayRemarks +
				"\nUserId: "+ this.userId +
				"\nHolidayDateCreated: "+ this.holidayDateCreated ;
	}
}
