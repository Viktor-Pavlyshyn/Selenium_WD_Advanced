package database.dao.daoimpl;

import database.connection.DBConnection;
import database.dao.AnimalDAO;
import database.exception.DAOException;
import database.exception.DBConnectionException;
import database.model.Animal;
import database.model.AnimalClass;
import database.model.Zoo;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static database.config.SQLProp.*;

@Log4j2
public class AnimalDAOImpl implements AnimalDAO {

    private DBConnection dbConnection;

    public AnimalDAOImpl() {
        this(DBConnection.getInstance());
    }

    public AnimalDAOImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void insert(Animal animal) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ANIMAL.QUERY)) {

            statement.setLong(1, animal.getNameZoo().getId());
            statement.setLong(2, animal.getAnimalClass().getId());
            statement.setString(3, animal.getAnimalName());
            statement.setString(4, animal.getAnimalAppearance());

            statement.executeUpdate();

            log.info("The {} has been added to the database.", animal.toString());
        } catch (SQLException e) {
            log.error(String.format("Can't add the %s to database.", animal.toString()), e);
            throw new DAOException("Can't add animal to database.", e);
        }
    }

    @Override
    public Animal getById(Long id) throws DBConnectionException, DAOException {
        PreparedStatement prStatement = null;
        Animal animal = new Animal();
        animal.setId((long) -1);

        try (Connection connection = dbConnection.getConnection()) {

            prStatement = connection.prepareStatement(SELECT_BY_ID_ANIMAL.QUERY);
            prStatement.setLong(1, id);

            try (ResultSet resultSet = prStatement.executeQuery()) {
                if (resultSet.next()) {
                    animal.setId(resultSet.getLong(1));
                    animal.setNameZoo(new Zoo(resultSet.getLong(2)));
                    animal.setAnimalClass(new AnimalClass(resultSet.getLong(3)));
                    animal.setAnimalName(resultSet.getString(4));
                    animal.setAnimalAppearance(resultSet.getString(5));
                }
            } catch (SQLException e) {
                log.error("Can't get the animal from ResultSet.", e);
                throw new DAOException("Can't get the animal by id from database.", e);
            }
        } catch (SQLException e) {
            log.error(String.format("Can't get the animal with id - %d.", id), e);
            throw new DAOException("Can't get the animal by id from database.", e);
        } finally {
            if (prStatement != null) {
                try {
                    prStatement.close();
                    log.debug("Connection to the PreparedStatement is closed.");
                } catch (SQLException e) {
                    log.error("Can't close the connection to the PreparedStatement is not closed.", e);
                }
            }
        }
        log.info("Get an animal with id - {}.", animal.getId());
        return animal;
    }

    @Override
    public void update(Animal animal) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ANIMAL.QUERY)) {

            statement.setLong(1, animal.getNameZoo().getId());
            statement.setLong(2, animal.getAnimalClass().getId());
            statement.setString(3, animal.getAnimalName());
            statement.setString(4, animal.getAnimalAppearance());
            statement.setLong(5, animal.getId());

            statement.executeUpdate();
            log.info("Update the {}.", animal.toString());
        } catch (SQLException e) {
            log.error(String.format("Can't update the %s.", animal.toString()), e);
            throw new DAOException("Can't update the animal from database.", e);
        }
    }

    @Override
    public void delete(Animal animal) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ANIMAL.QUERY)) {

            statement.setLong(1, animal.getId());

            statement.executeUpdate();

            log.info("Delete the animal with id - {}.", animal.getId());
        } catch (SQLException e) {
            log.error(String.format("Can't delete the animal with id - %d.", animal.getId()), e);
            throw new DAOException("Can't delete animal from database.", e);
        }
    }

    @Override
    public List<Animal> getAllByZooAndClass(Zoo zoo, AnimalClass animalClass) throws DBConnectionException, DAOException {
        PreparedStatement prStatement = null;
        List<Animal> animalList = new LinkedList<>();

        try (Connection connection = dbConnection.getConnection()) {

            prStatement = connection.prepareStatement(SELECT_ALL_ANIMAL_BY_ZOO_AND_CLASS.QUERY);
            prStatement.setLong(1, zoo.getId());
            prStatement.setLong(2, animalClass.getId());

            try (ResultSet resultSet = prStatement.executeQuery()) {

                while (resultSet.next()) {
                    Animal animal = new Animal();

                    animal.setId(resultSet.getLong(1));
                    animal.setNameZoo(new Zoo(resultSet.getString(2)));
                    animal.setAnimalClass(new AnimalClass(resultSet.getString(3)));
                    animal.setAnimalName(resultSet.getString(4));
                    animal.setAnimalAppearance(resultSet.getString(5));

                    animalList.add(animal);
                }
            } catch (SQLException e) {
                log.error("Can't get all animal from database.", e);
                throw new DAOException("Can't get all animals by class and zoo from database.", e);
            }
        } catch (SQLException e) {
            log.error(String.format("The animal with zoo with id - %d and an animal class with id - %d.", zoo.getId(), animalClass.getId()), e);
            throw new DAOException("Can't get all animals by class and zoo from database.", e);
        } finally {
            if (prStatement != null) {
                try {
                    prStatement.close();
                    log.debug("Connection to the PreparedStatement is closed.");
                } catch (SQLException e) {
                    log.error("Can't close the connection to the PreparedStatement.", e);
                }
            }
        }
        log.info("Get the list of the animal by zoo with id - {} and an animal class with id - {} with the size - {}.", zoo.getId(), animalClass.getId(), animalList.size());
        return animalList;
    }

    @Override
    public Set<Long> getAllClassIdByZoo(Zoo zoo) throws DBConnectionException, DAOException {
        PreparedStatement prStatement = null;
        Set<Long> classId = new HashSet<>();

        try (Connection connection = dbConnection.getConnection()) {

            prStatement = connection.prepareStatement(SELECT_ALL_CLASS_BY_ZOO.QUERY);
            prStatement.setLong(1, zoo.getId());

            try (ResultSet resultSet = prStatement.executeQuery()) {

                while (resultSet.next()) {

                    classId.add(resultSet.getLong(1));
                }
            } catch (SQLException e) {
                log.error("Can't get all animal classes from ResultSet.", e);
                throw new DAOException("Can't get all animal classes by zoo from database.", e);
            }
        } catch (SQLException e) {
            log.error(String.format("Can't get all animals by zoo id - %d from database.", zoo.getId()), e);
            throw new DAOException("Can't get all animal classes by zoo from database.", e);
        } finally {
            if (prStatement != null) {
                try {
                    prStatement.close();
                    log.debug("Connection to the PreparedStatement is closed.");
                } catch (SQLException e) {
                    log.error("Can't close the connection to the PreparedStatement", e);
                }
            }
        }
        log.info("Get the list of the animal classes with id by zoo with id - {} with the size - {}.", zoo.getId(), classId.size());
        return classId;
    }

    @Override
    public void deleteAllByZoo(Zoo zoo) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ANIMAL_BY_ZOO.QUERY)) {

            statement.setLong(1, zoo.getId());

            statement.executeUpdate();
            log.info("Delete the all animal by zoo wit id - {}.", zoo.getId());
        } catch (SQLException e) {
            log.error(String.format("Can't delete all animals by zoo id - %d form database.", zoo.getId()), e);
            throw new DAOException("Can't delete all animals by zoo from database.", e);
        }
    }

    @Override
    public void deleteAllByClass(AnimalClass animalClass) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ANIMAL_BY_ANIMAL_ClASS.QUERY)) {

            statement.setLong(1, animalClass.getId());

            statement.executeUpdate();

            log.info("Delete the all animals by animal class with id - {}.", animalClass.getId());
        } catch (SQLException e) {
            log.error(String.format("Can't delete all animals by the animal class with id - %d from database.", animalClass.getId()), e);
            throw new DAOException("Can't delete all animal by class from database.", e);
        }
    }

    @Override
    public void deleteByClassAndZoo(Zoo zoo, AnimalClass animalClass) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ANIMAL_BY_ANIMAL_ClASS_AND_ZOO.QUERY)) {

            statement.setLong(1, animalClass.getId());
            statement.setLong(2, zoo.getId());

            statement.executeUpdate();

            log.info("Delete the all animal by the animal class with id - {} and the zoo with id - {} from the database.", animalClass.getId(), zoo.getId());
        } catch (SQLException e) {
            log.error(String.format("Can't delete all animals by the animal class with id - %d and the zoo with id - %d from the database.", animalClass.getId(), zoo.getId()), e);
            throw new DAOException("Can't delete the animal by class and zoo from database.", e);
        }
    }
}
