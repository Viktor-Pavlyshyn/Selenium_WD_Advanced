package database.dao;

import database.exception.DAOException;
import database.exception.DBConnectionException;

public interface DataCRUD<T> {

    void insert(T t) throws DBConnectionException, DAOException;

    T getById(Long id) throws DBConnectionException, DAOException;

    void update(T t) throws DBConnectionException, DAOException;

    void delete(T t) throws DBConnectionException, DAOException;
}
