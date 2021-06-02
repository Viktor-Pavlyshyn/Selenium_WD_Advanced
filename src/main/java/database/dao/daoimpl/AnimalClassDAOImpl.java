package database.dao.daoimpl;

import database.connection.DBConnection;
import database.dao.AnimalClassDAO;
import database.exception.DAOException;
import database.exception.DBConnectionException;
import database.model.AnimalClass;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static database.config.SQLProp.*;


@Log4j2
public class AnimalClassDAOImpl implements AnimalClassDAO {

    private DBConnection dbConnection;

    public AnimalClassDAOImpl() {
        this(DBConnection.getInstance());
    }

    public AnimalClassDAOImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void insert(AnimalClass animalClass) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ANIMAL_CLASS.QUERY)) {

            statement.setString(1, animalClass.getType());

            statement.executeUpdate();

            log.info("The animal class with id - {} has been added to the database.", animalClass.getId());
        } catch (SQLException e) {
            log.error(String.format("Can't add the animal class with id - %s to database.", animalClass.getId()), e);
            throw new DAOException("Can't add the animal class to database.", e);
        }
    }

    @Override
    public AnimalClass getById(Long id) throws DBConnectionException, DAOException {
        PreparedStatement prStatement = null;
        AnimalClass animalClass = new AnimalClass();
        animalClass.setId((long) -1);

        try (Connection connection = dbConnection.getConnection()) {

            prStatement = connection.prepareStatement(SELECT_BY_ID_ANIMAL_CLASS.QUERY);
            prStatement.setLong(1, id);

            try (ResultSet resultSet = prStatement.executeQuery()) {
                if (resultSet.next()) {
                    animalClass.setId(resultSet.getLong(1));
                    animalClass.setType(resultSet.getString(2));
                }
            } catch (SQLException e) {
                log.error("Can't get the animal class from ResultSet.", e);
                throw new DAOException("Can't to get the animal class to database.", e);
            }
        } catch (SQLException e) {
            log.error(String.format("Can't get the animal class with id - %s.", id), e);
            throw new DAOException("Can't get the animal class from database.", e);
        } finally {
            if (prStatement != null) {
                try {
                    prStatement.close();
                    log.debug("Connection to the PreparedStatement is closed.");
                } catch (SQLException e) {
                    log.error("Can't close connection to the PreparedStatement.", e);
                }
            }
        }
        log.info("Get an animal class with id - {}.", animalClass.getId());
        return animalClass;
    }

    @Override
    public void update(AnimalClass animalClass) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ANIMAL_CLASS.QUERY)) {

            statement.setString(1, animalClass.getType());
            statement.setLong(2, animalClass.getId());

            statement.executeUpdate();
            log.info("Update the {}.", animalClass.toString());
        } catch (SQLException e) {
            log.error(String.format("Can't update the %s.", animalClass.toString()), e);
            throw new DAOException("Can't update the animal class from database.", e);
        }
    }

    @Override
    public void delete(AnimalClass animalClass) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ANIMAL_CLASS.QUERY)) {

            statement.setLong(1, animalClass.getId());

            statement.executeUpdate();
            log.info("Delete the animal class with id - {}.", animalClass.getId());
        } catch (SQLException e) {
            log.error(String.format("Can't delete the animal class with id - %s.", animalClass.getId()), e);
            throw new DAOException("Can't delete the animal class from database.", e);
        }
    }

    @Override
    public List<AnimalClass> getAll() throws DBConnectionException, DAOException {

        List<AnimalClass> animalClassList = new LinkedList<>();

        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_ANIMAL_CLASS.QUERY)) {

            while (resultSet.next()) {
                AnimalClass animalClass = new AnimalClass();
                animalClass.setId(resultSet.getLong(1));
                animalClass.setType(resultSet.getString(2));

                animalClassList.add(animalClass);
            }

        } catch (SQLException e) {
            log.error("Can't  get all animal class .", e);
            throw new DAOException("Can't get all animal class from database.", e);
        }
        log.info("Get the list of the animal class with the size - {}.", animalClassList.size());
        return animalClassList;
    }
}
