package pojos.gmibank_pojos;

import java.io.Serializable;

public class CountryPojo implements Serializable {
	private int id;
	private String name;
	private Object states;

    public CountryPojo() {
    }

    public CountryPojo(int id, String name, Object states) {
        this.id = id;
        this.name = name;
        this.states = states;
    }

    public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setStates(Object states){
		this.states = states;
	}

	public Object getStates(){
		return states;
	}

	@Override
 	public String toString(){
		return 
			"CountryPojo{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",states = '" + states + '\'' + 
			"}";
		}
}