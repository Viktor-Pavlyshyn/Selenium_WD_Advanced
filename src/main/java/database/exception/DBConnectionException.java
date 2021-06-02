package database.exception;

public class DBConnectionException extends Exception {

    public DBConnectionException(String description, Exception e) {
        super(description, e);
    }
}
