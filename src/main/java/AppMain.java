import decorator.*;
import model.*;
import model.archival.good.*;
import model.uere.okversion.StreamABLR;
import model.uere.okversion.StreamALCK;
import model.uere.okversion.StreamBBLR;
import model.uere.okversion.StreamBLCK;
import model.userposition.UserPosition;
import org.apache.log4j.Logger;
import workutils.IUtils;
import workutils.UtilsV1;
import workutils.UtilsV2;
import workutils.UtilsV3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AppMain {


    List<String> asd =new LinkedList<>();
    List<String> asd1 =new ArrayList<>();
    final static Logger logger = Logger.getLogger(AppMain.class);
    final static DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ISO_LOCAL_TIME;
    public static void main(String[] args) {

        // data came from frontend//

        String issues="This issue came from frontend";
//        BaseStatus communicationStatus=new CommunicationStatus(issues,"OK","NOT-OK","OK");

        List<String> availableFlies=List.of("Doct1","doc2");
        StandardFileStatus standardFileStatus=new StandardFileStatus(availableFlies);
         issues="This issue came from frontend-2-for storage";
         NsopStorageStatus nsopStorageStatus=new NsopStorageStatus("OK","OK");


        LocalDateTime createdAt=LocalDateTime.now();
        LocalDateTime modifiedAt=LocalDateTime.now().plusHours(2);
        IUtils utils=new UtilsV3();
        CommunicationStatus communicationStatus=new CommunicationStatus("issue1","OK","NOT-OK","OK",utils);


        StorageStatus storageStatus=new StorageStatus(issues,"OK",nsopStorageStatus);

        SchemacsStatus schemacsStatus=new SchemacsStatus("schemacs-issues","schemacs");



        List<BaseStatus> baseStatusList=List.of(communicationStatus,storageStatus,schemacsStatus);

        NSOP2 NSOP2=new NSOP2("OK", "17G");
        NSOP4 NSOP4=new NSOP4("Not Ok", "13G");
        ArchivalNSDAQ1 ArchivalNSDAQ1 =new ArchivalNSDAQ1("OK", "12G");
        NSDAQ2 NSDAQ2=new NSDAQ2("OK", "10G");



        String[][] uereData = {{"15G","12G","12G","12G"}, {"12G","12G","12G","12G"}, {"12G","12G","12G","12G"}, {"12G","12G","12G","12G"}};
        StreamABLR streamABlr=new StreamABLR(uereData);
        StreamBBLR streamBBlr=new StreamBBLR(uereData);
        StreamALCK streamALck=new StreamALCK(uereData);
        StreamBLCK streamBLck=new StreamBLCK(uereData);

        String[][] userPositionArr= {{"15G","12G","12G","12G"}, {"12G","12G","12G","12G"}};
        UserPosition userPosition =new UserPosition(userPositionArr);


        List<ArchivalBaseClass> archivalList=List.of(NSOP2, NSOP4, ArchivalNSDAQ1, NSDAQ2);
        NavICPerformanceDetails navICPerformanceDetails=new NavICPerformanceDetails(100_00,communicationStatus,standardFileStatus,storageStatus, baseStatusList, createdAt.format(DATE_TIME_FORMATTER), modifiedAt.format(DATE_TIME_FORMATTER), archivalList, NSOP2, NSOP4, ArchivalNSDAQ1, NSDAQ2, streamABlr, streamBBlr, streamALck, streamBLck, userPosition);


        logger.info(navICPerformanceDetails.getCreatedAt());
        logger.info(navICPerformanceDetails.getStatuses());
        logger.info(navICPerformanceDetails.getModifiedAt());
        logger.info(navICPerformanceDetails.toString());
        logger.info(navICPerformanceDetails.getStatuses().get(1).getIssues());
        logger.info(navICPerformanceDetails.getNsop2());
        logger.info(navICPerformanceDetails.getNsop4());
        logger.info((navICPerformanceDetails.getArchivalNsdaq1()));
        logger.info((navICPerformanceDetails.getNsdaq2()));
        logger.info(navICPerformanceDetails.getStreamABlr());
        logger.info(navICPerformanceDetails.getStreamBBlr());
        logger.info(navICPerformanceDetails.getStreamALck());
        logger.info(navICPerformanceDetails.getStreamBLck());
        logger.info(navICPerformanceDetails.getUserPosition());
        logger.info(navICPerformanceDetails.getArchivalList());



        int[] arr={100,25,-1,2198,9};
        UtilsV1 utilsV1=new UtilsV1(); // concrete implementation //
        IUtils utility =new UtilsV2(); // abstraction //
        int[] result= utility.sort(arr);
        logger.info(Arrays.toString(result));


        communicationStatus.deductMoney();

        logger.info("-----------------------------------");
        BaseEntity base=new OwnerCheckDecorator((new ComStatusFile("s")));
        base.save();

//        Without SOLID Principle
//        Archival Archival=new Archival("OK", "17G", "OK", "12G", "NotOK", "10G", "OK", "13G");






    }
}
