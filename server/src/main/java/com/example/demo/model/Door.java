package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Door {

    @Id
    @GeneratedValue
    private Long id;
    private String name;



    protected Door() {}

    public Door(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Door{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
