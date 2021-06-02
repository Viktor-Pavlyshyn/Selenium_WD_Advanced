package database.dao;

import database.exception.DAOException;
import database.exception.DBConnectionException;

import java.util.List;

public interface RepositoryData<T> {

    List<T> getAll() throws DBConnectionException, DAOException;
}
