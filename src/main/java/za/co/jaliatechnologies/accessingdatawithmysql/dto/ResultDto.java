package za.co.jaliatechnologies.accessingdatawithmysql.dto;

public class ResultDto {
    private String message;

    public ResultDto() {
    }

    public ResultDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
