import decorator.*;
import model.*;
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


        NavICPerformanceDetails navICPerformanceDetails=new NavICPerformanceDetails(100_00,communicationStatus,standardFileStatus,storageStatus, baseStatusList, createdAt.format(DATE_TIME_FORMATTER), modifiedAt.format(DATE_TIME_FORMATTER));


        logger.info(navICPerformanceDetails.getCreatedAt());
        logger.info(navICPerformanceDetails.getStatuses());
        logger.info(navICPerformanceDetails.getModifiedAt());
        logger.info(navICPerformanceDetails.toString());
        logger.info(navICPerformanceDetails.getStatuses().get(1).getIssues());



        int[] arr={100,25,-1,2198,9};
        UtilsV1 utilsV1=new UtilsV1(); // concrete implementation //
        IUtils utility =new UtilsV2(); // abstraction //
        int[] result= utility.sort(arr);
        logger.info(Arrays.toString(result));


        communicationStatus.deductMoney();

        logger.info("-----------------------------------");
        BaseEntity base=new OwnerCheckDecorator((new ComStatusFile("s")));
        base.save();


    }
}
