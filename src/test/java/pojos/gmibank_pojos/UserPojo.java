package pojos.gmibank_pojos;

import java.io.Serializable;

public class UserPojo implements Serializable {
	private int id;
	private String login;
	private String firstName;
	private String lastName;
	private String email;
	private boolean activated;
	private String langKey;
	private Object imageUrl;
	private Object resetDate;

	public UserPojo() {
	}

	public UserPojo(int id, String login, String firstName, String lastName, String email, boolean activated, String langKey, Object imageUrl, Object resetDate) {
		this.id = id;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.activated = activated;
		this.langKey = langKey;
		this.imageUrl = imageUrl;
		this.resetDate = resetDate;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getLogin(){
		return login;
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

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setActivated(boolean activated){
		this.activated = activated;
	}

	public boolean isActivated(){
		return activated;
	}

	public void setLangKey(String langKey){
		this.langKey = langKey;
	}

	public String getLangKey(){
		return langKey;
	}

	public void setImageUrl(Object imageUrl){
		this.imageUrl = imageUrl;
	}

	public Object getImageUrl(){
		return imageUrl;
	}

	public void setResetDate(Object resetDate){
		this.resetDate = resetDate;
	}

	public Object getResetDate(){
		return resetDate;
	}

	@Override
 	public String toString(){
		return 
			"UserPojo{" + 
			"id = '" + id + '\'' + 
			",login = '" + login + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",email = '" + email + '\'' + 
			",activated = '" + activated + '\'' + 
			",langKey = '" + langKey + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",resetDate = '" + resetDate + '\'' + 
			"}";
		}
}