package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Door {

    @Id
    @GeneratedValue
    public Integer id;
    public String name;

    public Door(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.example.demo.model.Door door = (com.example.demo.model.Door) o;
        return Objects.equals(id, door.id) &&
                Objects.equals(name, door.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Door{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
