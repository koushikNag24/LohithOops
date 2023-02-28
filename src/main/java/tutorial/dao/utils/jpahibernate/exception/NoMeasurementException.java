package tutorial.dao.utils.jpahibernate.exception;

import lombok.Getter;

@Getter
public class NoMeasurementException extends Exception {
    private String errorCode="Unknown";
    public NoMeasurementException(String message, String errorCode){
        super(message);
        this.errorCode=errorCode;
    }

}
