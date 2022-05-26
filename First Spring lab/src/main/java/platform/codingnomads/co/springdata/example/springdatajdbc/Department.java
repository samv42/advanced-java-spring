package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Department {
    private long id;
    private String name;
    private int floor;

    public Department(long id, String name, int floor){
        this.id = id;
        this.name = name;
        this.floor = floor;
    }
}
