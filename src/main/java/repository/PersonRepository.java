package repository;

import com.sun.istack.NotNull;
import model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> people = new ArrayList<>();

    public PersonRepository() {

        people.add(new Person(1, "Oleg"));
        people.add(new Person(2, "Vlad"));
        people.add(new Person(3, "Misha"));
    }

    public Person getPerson(int id) {
        try {
            return people.get(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Person addPerson(@NotNull Person person) {
        int index = getPerson(people.size() - 1).getId() + 1;
        person.setId(index);
        people.add(person);
        return getPerson(people.size() - 1);
    }

    public Person updatePerson(@NotNull Person person) {
        int index = person.getId();
        try {
            return people.set(index, person);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Person removePerson(int id) {
        try {
            return people.remove(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
