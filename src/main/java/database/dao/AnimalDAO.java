package database.dao;

import database.exception.DAOException;
import database.exception.DBConnectionException;
import database.model.Animal;
import database.model.AnimalClass;
import database.model.Zoo;

import java.util.List;
import java.util.Set;

public interface AnimalDAO extends DataCRUD<Animal> {

    List<Animal> getAllByZooAndClass(Zoo zoo, AnimalClass animalClass) throws DBConnectionException, DAOException;

    Set<Long> getAllClassIdByZoo(Zoo zoo) throws DBConnectionException, DAOException;

    void deleteAllByZoo(Zoo zoo) throws DBConnectionException, DAOException;

    void deleteAllByClass(AnimalClass animalClass) throws DBConnectionException, DAOException;

    void deleteByClassAndZoo(Zoo zoo, AnimalClass animalClass) throws DBConnectionException, DAOException;
}
