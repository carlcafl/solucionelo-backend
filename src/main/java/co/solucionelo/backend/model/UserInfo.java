package co.solucionelo.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfo {

	private int id = 0;
	private String idType = null;
	private String idNumber = null;
	private String firstName = null;
	private String lastName = null;
	private String phoneNumber = null;
	private String mobileNumber = null;
	private String email = null;
	private String referrer = null;
	private String otherServices = null;
	private List<Service> offeredServices = new ArrayList<Service>();
	private Date registeredDate = null;
	private String ipAddress = null;
	
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public List<Service> getOfferedServices() {
		return offeredServices;
	}
	public void setOfferedServices(List<Service> offeredServices) {
		this.offeredServices = offeredServices;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getOtherServices() {
		return otherServices;
	}
	public void setOtherServices(String otherServices) {
		this.otherServices = otherServices;
	}
}
