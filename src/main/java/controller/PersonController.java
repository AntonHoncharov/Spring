package controller;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.PersonService;


@RestController()
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id) {
        Person person = personService.getPerson(id);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return person;
    }

    @PostMapping
    public Person updatePerson(@RequestBody Person person) {
        Person person1 = personService.updatePerson(person);
        if (person1 == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return person1;
    }

    @PutMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public Person removePerson(@PathVariable int id) {
        Person person = personService.removePerson(id);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return person;
    }

}
