package com.ben.mongoclient;

public class Device {

	private String udid;
	private String friendlyName;
	private String serialNumber;
	private String manfDate;

	public void display() {
		System.out.println(udid);
		System.out.println(friendlyName);
		System.out.println(serialNumber);
		System.out.println(manfDate);
	}

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getManfDate() {
		return manfDate;
	}

	public void setManfDate(String manfDate) {
		this.manfDate = manfDate;
	}

}
