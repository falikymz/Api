package pojos.gmibank_pojos;

import java.util.List;
import java.io.Serializable;

public class CustomerPojo implements Serializable {
	private int id;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String email;
	private String mobilePhoneNumber;
	private String phoneNumber;
	private String zipCode;
	private String address;
	private String city;
	private String ssn;
	private String createDate;
	private boolean zelleEnrolled;
	private CountryPojo country;
	private String state;
	private UserPojo user;
	private List<Object> accounts;

	public CustomerPojo() {
	}

	public CustomerPojo(int id, String firstName, String lastName, String middleInitial, String email, String mobilePhoneNumber, String phoneNumber, String zipCode, String address, String city, String ssn, String createDate, boolean zelleEnrolled, CountryPojo country, String state, UserPojo user, List<Object> accounts) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.email = email;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.address = address;
		this.city = city;
		this.ssn = ssn;
		this.createDate = createDate;
		this.zelleEnrolled = zelleEnrolled;
		this.country = country;
		this.state = state;
		this.user = user;
		this.accounts = accounts;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setMiddleInitial(String middleInitial){
		this.middleInitial = middleInitial;
	}

	public String getMiddleInitial(){
		return middleInitial;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber){
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getMobilePhoneNumber(){
		return mobilePhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

	public String getZipCode(){
		return zipCode;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setSsn(String ssn){
		this.ssn = ssn;
	}

	public String getSsn(){
		return ssn;
	}

	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}

	public String getCreateDate(){
		return createDate;
	}

	public void setZelleEnrolled(boolean zelleEnrolled){
		this.zelleEnrolled = zelleEnrolled;
	}

	public boolean isZelleEnrolled(){
		return zelleEnrolled;
	}

	public void setCountry(CountryPojo country){
		this.country = country;
	}

	public CountryPojo getCountry(){
		return country;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setUser(UserPojo user){
		this.user = user;
	}

	public UserPojo getUser(){
		return user;
	}

	public void setAccounts(List<Object> accounts){
		this.accounts = accounts;
	}

	public List<Object> getAccounts(){
		return accounts;
	}

	@Override
 	public String toString(){
		return 
			"CustomerPojo{" + 
			"id = '" + id + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",middleInitial = '" + middleInitial + '\'' + 
			",email = '" + email + '\'' + 
			",mobilePhoneNumber = '" + mobilePhoneNumber + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",zipCode = '" + zipCode + '\'' + 
			",address = '" + address + '\'' + 
			",city = '" + city + '\'' + 
			",ssn = '" + ssn + '\'' + 
			",createDate = '" + createDate + '\'' + 
			",zelleEnrolled = '" + zelleEnrolled + '\'' + 
			",country = '" + country + '\'' + 
			",state = '" + state + '\'' + 
			",user = '" + user + '\'' + 
			",accounts = '" + accounts + '\'' + 
			"}";
		}
}