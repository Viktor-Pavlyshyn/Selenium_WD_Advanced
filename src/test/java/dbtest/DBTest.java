package dbtest;

import database.dao.AnimalDAO;
import database.dao.ZooDAO;
import database.dao.daoimpl.AnimalDAOImpl;
import database.dao.daoimpl.ZooDAOImpl;
import database.model.Animal;
import database.model.AnimalClass;
import database.model.Zoo;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DBTest {
    ZooDAO zooDAO = new ZooDAOImpl();
    AnimalDAO animalDAO = new AnimalDAOImpl();

    Zoo zoo = new Zoo(1L, "Test zoo");
    AnimalClass animalClass = new AnimalClass(1L, "Test type");
    Animal animal = new Animal(1L, new Zoo("Test zoo"), new AnimalClass( " Test type"), "test Name", "test appearance");


    @SneakyThrows
    @Test
    public void readSimpleValue() {
        List<Zoo> zoos = zooDAO.getAll();
        assertThat(zoos.contains(zoo))
                .as("'dbzoo' doesn't contain zoo - {}", zoo)
                .isTrue();
    }

    @SneakyThrows
    @Test
    public void readComplicationValue() {
        List<Animal> animals = animalDAO.getAllByZooAndClass(zoo, animalClass);

        assertThat(animals.get(0).toString())
                .as("'dbzoo' doesn't contain animal - %s", animal)
                .isEqualTo(animal.toString());
    }
}
