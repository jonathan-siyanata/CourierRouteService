package za.co.jaliatechnologies.accessingdatawithmysql.exception;

public class ValidationException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ValidationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public ValidationException(){

    }

}
