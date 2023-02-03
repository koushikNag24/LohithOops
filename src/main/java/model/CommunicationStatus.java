package model;


import lombok.Getter;
import lombok.ToString;
import workutils.IUtils;
import workutils.UtilsV1;
import workutils.UtilsV2;

@ToString
@Getter
public class CommunicationStatus extends BaseStatus{
    IUtils utilsV1;
   
//    private String submarineLink;

    private final String terrestrialLink;
    private final String satelliteLink;
    private final String inc1Inc2;




    public CommunicationStatus(String issues, String terrestrialLink, String satelliteLink, String inc1Inc2,IUtils utils) {
        super(issues);
        this.utilsV1=utils;
        this.terrestrialLink = terrestrialLink;
        this.satelliteLink = satelliteLink;
        this.inc1Inc2 = inc1Inc2;
    }
    public void deductMoney(){
//        IUtils utilsV1=new UtilsV2();
//        IUtils utils=new UtilsV1();
        utilsV1.shout();
    }


}
