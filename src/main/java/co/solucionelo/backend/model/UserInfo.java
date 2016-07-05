package co.solucionelo.backend.model;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {

	private String idType = null;
	private String idNumber = null;
	private String firstName = null;
	private String lastName = null;
	private String phoneNumber = null;
	private String mobileNumber = null;
	private String email = null;
	private String city = null;
	private List<Service> offeredServices = new ArrayList<Service>();
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Service> getOfferedServices() {
		return offeredServices;
	}
	public void setOfferedServices(List<Service> offeredServices) {
		this.offeredServices = offeredServices;
	}
}
