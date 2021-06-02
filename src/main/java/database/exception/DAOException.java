package database.exception;

public class DAOException extends RuntimeException {

    public DAOException(String description, Exception e) {
        super(description, e);
    }

    public DAOException() {
    }
}
