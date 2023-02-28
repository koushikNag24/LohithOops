package tutorial.dao.utils.jpahibernate.exception;

import lombok.Getter;
import lombok.ToString;
@Getter
public class ArgumentNullException extends Exception {
    private String errorCode="Unknown";
    public ArgumentNullException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }

}
