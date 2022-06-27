package service;

import model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import repository.AnimalRepository;

public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimal(int id) {
        return animalRepository.getAnimal(id);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.addAnimal(animal);
    }

    public Animal updateAnimal(Animal animal) {
        return animalRepository.updateAnimal(animal);
    }

    public Animal removeAnimal(int id) {
        return animalRepository.removeAnimal(id);
    }
}
