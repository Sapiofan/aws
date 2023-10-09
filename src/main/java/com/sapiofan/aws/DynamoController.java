package com.sapiofan.aws;

import com.sapiofan.aws.entities.Person;
import com.sapiofan.aws.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DynamoController {
    @Autowired
    private PersonRepo personRepo;

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person) {
        return personRepo.addPerson(person);
    }

    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable String personId) {
        return personRepo.findPerson(personId);
    }

    @DeleteMapping("/person")
    public String getPerson(@RequestBody Person person) {
        return personRepo.removePerson(person);
    }

    @PutMapping("/person")
    public String updatePerson(@RequestBody Person person) {
        return personRepo.editPerson(person);
    }
}
