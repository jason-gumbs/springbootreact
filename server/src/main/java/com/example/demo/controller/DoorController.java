package com.example.demo.controller;

import com.example.demo.model.Door;
import com.example.demo.repository.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class DoorController {

    @Autowired
    private DoorRepository repository;

    @GetMapping("/door")
    public List<Door> getDoors() {
        List<Door> myList = new LinkedList<Door>();
        for (Door e : repository.findAll()) {
            myList.add(e);
        }
        return myList;
    }

    @PostMapping("/door/new")
    public Door createDoors(@RequestBody Door door) {

        return repository.save(door);

    }

    @GetMapping("/door/{id}")
    public Optional <Door> getDoorById(@PathVariable("id") Long id){
        Optional<Door> door = this.repository.findById(id);
        return door;
    }

    @DeleteMapping("/door/{id}")
    public void deleteDoor(@PathVariable("id") Long id){
        this.repository.deleteById(id);
    }

    @PutMapping("/door/{id}")
    public Door updateDoor(@PathVariable("id") Long id, @RequestBody Door door) {

    Optional selectDoor = repository.findById(id);
        System.out.println("doorById" + selectDoor.toString());
        door.setId(id);
//        door.setName(door.getName());
        return repository.save( door);



    }
}
