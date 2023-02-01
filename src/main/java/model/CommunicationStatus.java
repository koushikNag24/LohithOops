package model;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CommunicationStatus extends BaseStatus{
//    private String submarineLink;
    
    private final String terrestrialLink;
    private final String satelliteLink;
    private final String inc1Inc2;




    public CommunicationStatus(String issues, String terrestrialLink, String satelliteLink, String inc1Inc2) {
        super(issues);
        this.terrestrialLink = terrestrialLink;
        this.satelliteLink = satelliteLink;
        this.inc1Inc2 = inc1Inc2;
    }
}
