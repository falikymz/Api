package pojos;

import java.util.List;

public class CountryPojo {
    /*
    {
    "id": 195233,
    "name": "Banana",
    "states": [
        {
            "id": 0,
            "name": "Apple",
            "tpcountry": null
        },
        {
            "id": 1,
            "name": "Orange",
            "tpcountry": null
        },
        {
            "id": 2,
            "name": "Peach",
            "tpcountry": null
        }
    ]
}
     */
    private Integer id;
    private String name;
    private List<StatePojo> states;

    public CountryPojo() {
    }

    public CountryPojo(Integer id, String name, List<StatePojo> states) {
        this.id = id;
        this.name = name;
        this.states = states;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatePojo> getStates() {
        return states;
    }

    public void setStates(List<StatePojo> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "CountryPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}
