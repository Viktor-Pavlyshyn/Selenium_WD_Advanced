package database.dao.daoimpl;

import database.connection.DBConnection;
import database.dao.ZooDAO;
import database.exception.DAOException;
import database.exception.DBConnectionException;
import database.model.Zoo;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static database.config.SQLProp.*;

@Log4j2
public class ZooDAOImpl implements ZooDAO {

    private DBConnection dbConnection;

    public ZooDAOImpl() {
        this(DBConnection.getInstance());
    }

    public ZooDAOImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void insert(Zoo zoo) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ZOO.QUERY)) {

            statement.setString(1, zoo.getNameZoo());
            statement.executeUpdate();
            log.debug("The zoo with id - {} has been added to the database.", zoo.getId());

        } catch (SQLException e) {
            log.error(String.format("Can't add the zoo with id - %s to database.", zoo.getId()), e);
            throw new DAOException("Can't add the zoo to database.", e);
        }
    }

    @Override
    public Zoo getById(Long id) throws DBConnectionException, DAOException {
        PreparedStatement prStatement = null;
        Zoo zoo = new Zoo();
        zoo.setId((long) -1);

        try (Connection connection = dbConnection.getConnection()) {

            prStatement = connection.prepareStatement(SELECT_BY_ID_ZOO.QUERY);
            prStatement.setLong(1, id);

            try (ResultSet resultSet = prStatement.executeQuery()) {
                if (resultSet.next()) {
                    zoo.setId(resultSet.getLong(1));
                    zoo.setNameZoo(resultSet.getString(2));
                }
            } catch (SQLException e) {
                log.error(String.format("Can't get the %s from ResultSet.", zoo.toString()), e);
                throw new DAOException("Can't get the zoo by id from database.", e);
            }
        } catch (SQLException e) {
            log.error(String.format("Can't get zoo with id - %s.", id), e);
            throw new DAOException("Can't get the zoo by id from database.", e);
        } finally {
            if (prStatement != null) {
                try {
                    prStatement.close();
                    log.debug("Connection to the PreparedStatement is closed.");
                } catch (SQLException e) {
                    log.error("Can't close the PreparedStatement.", e);
                }
            }
        }
        log.info("Get the {}.", zoo.toString());
        return zoo;
    }

    @Override
    public void update(Zoo zoo) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ZOO.QUERY)) {

            statement.setString(1, zoo.getNameZoo());
            statement.setLong(2, zoo.getId());

            statement.executeUpdate();

            log.info("Update the {}.", zoo.toString());
        } catch (SQLException e) {
            log.error(String.format("Can't update the %s.", zoo.toString()), e);
            throw new DAOException("Can't update the zoo from database.", e);
        }
    }

    @Override
    public void delete(Zoo zoo) throws DBConnectionException, DAOException {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ZOO.QUERY)) {

            statement.setLong(1, zoo.getId());

            statement.executeUpdate();

            log.info("Delete the zoo with id - {}.", zoo.getId());
        } catch (SQLException e) {
            log.error(String.format("Can't delete the zoo with id - %s.", zoo.getId()), e);
            throw new DAOException("Can't delete the zoo from database.", e);
        }
    }

    @Override
    public List<Zoo> getAll() throws DBConnectionException, DAOException {
        List<Zoo> zooList = new LinkedList<>();

        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_ZOO.QUERY)) {

            while (resultSet.next()) {
                Zoo zoo = new Zoo();
                zoo.setId(resultSet.getLong(1));
                zoo.setNameZoo(resultSet.getString(2));

                zooList.add(zoo);
            }
        } catch (SQLException e) {
            log.error("Can't get all zoo by.", e);
            throw new DAOException("Can't get all zoos from database.", e);
        }
        log.info("Get the list of the zoos with size - {}.", zooList.size());
        return zooList;
    }
}
