import model.*;
import org.apache.log4j.Logger;

import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AppMain {
    final static Logger logger = Logger.getLogger(AppMain.class);
    final static DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ISO_LOCAL_TIME;
    public static void main(String[] args) {

        // data came from frontend//

        String issues="This issue came from frontend";
        BaseStatus communicationStatus=new CommunicationStatus(issues,"OK","NOT-OK","OK");


//        BaseStatus baseStatus=new BaseStatus("asd");
        List<String> availableFlies=List.of("Doct1","doc2");
        StandardFileStatus standardFileStatus=new StandardFileStatus(availableFlies);
         issues="This issue came from frontend-2-for storage";
         NsopStorageStatus nsopStorageStatus=new NsopStorageStatus("OK","OK");
        BaseStatus storageStatus=new StorageStatus(issues,"OK",nsopStorageStatus);

        LocalDateTime createdAt=LocalDateTime.now();
        LocalDateTime modifiedAt=LocalDateTime.now().plusHours(2);
        NavICPerformanceDetails navICPerformanceDetails=new NavICPerformanceDetails(1000L,communicationStatus,standardFileStatus,storageStatus, createdAt.format(DATE_TIME_FORMATTER), modifiedAt.format(DATE_TIME_FORMATTER));

        logger.info(navICPerformanceDetails.getCommunicationStatus().getIssues());
        logger.info(navICPerformanceDetails.getStorageStatus().getIssues());

        logger.info(navICPerformanceDetails.getCreatedAt());
        logger.info(navICPerformanceDetails.getModifiedAt());
        logger.info(navICPerformanceDetails.toString());




    }
}
