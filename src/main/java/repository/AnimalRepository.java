package repository;

import com.sun.istack.NotNull;
import model.Animal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {

    private List<Animal> animals = new ArrayList<>();

    public AnimalRepository() {

        animals.add(new Animal(1, "Tuzik", 3, "Poodle", "Dog"));
        animals.add(new Animal(1, "Sharik", 3, "Pug", "Dog"));
        animals.add(new Animal(1, "Bobik", 3, "Alabai", "Dog"));
        animals.add(new Animal(1, "Barsik", 3, "Persian", "Cat"));
        animals.add(new Animal(1, "Murka", 3, "Sphinx", "Cat"));
        animals.add(new Animal(1, "Pipi", 3, "Laboratory", "Mouse"));
    }

    public Animal getAnimal(int id) {
        try {
            return animals.get(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Animal addAnimal(@NotNull Animal animal) {
        int index = getAnimal(animals.size() - 1).getId() + 1;
        animal.setId(index);
        animals.add(animal);
        return getAnimal(animals.size() - 1);
    }

    public Animal updateAnimal(@NotNull Animal animal) {
        int index = animal.getId();
        try {
            return animals.set(index, animal);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Animal removeAnimal(int id) {
        try {
            return animals.remove(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
