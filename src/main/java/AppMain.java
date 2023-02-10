import com.github.javafaker.Faker;
import model.*;
import model.sections.base.BaseHealth;
import model.sections.sectionb.measurements.BaseMeasurement;
import model.sections.sectionb.measurements.Uere;
import model.sections.sectionb.measurements.UserPosition;
import model.sections.sectiona.CommunicationIssues;
import model.sections.sectiona.SectionA;
import model.sections.sectionb.NsopStorageStatus;
import model.sections.sectionb.SectionB;
import model.sections.sectionb.StandardFileStatus;
import model.sections.sectionb.StorageIssues;
import model.sections.sectionb.archival.good.*;
import model.sections.sectionc.GnssOffset;
import model.sections.sectionc.ParallelChain;
import model.sections.sectionc.SectionC;
import model.sections.sectionc.TwstftOffset;
import model.sections.sectiond.SchemacsHealth;
import model.sections.sectiond.SectionD;
import model.sections.sectione.SectionE;
import model.sections.sectionf.SectionF;
import model.sections.sectiong.SectionG;
import model.sections.sectiong.SyslogStatus;
import model.sections.sectionh.SectionH;
import model.sections.sectionh.StnLookAngle;
import org.apache.log4j.Logger;
import workutils.IUtils;
import workutils.UtilsV3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class AppMain {


    public static final String HEALTHY = "FINE";
    public static final String SERVER1 = "NSOP1";
    public static final String SERVER2 = "NSOP2";
    public static final String SERVER4 = "NSOP4";
    public static final String UNHEALTHY = "NOT-OK";
    public static final char CHAIN_A = 'A';
    public static final char CHAIN_B = 'B';
    static final String BLR = "BLR";
    public static final String LCK = "LCK";
    public static final String STORAGE_UNIT = "G";
    public static final String satellite_02 = "SAT02";
    public static final String satellite_03 = "SAT03";
    public static final String satellite_06 = "SAT06";
    public static final String satellite_09 = "SAT09";
    public static final String Document_1 = "Doct1";
    public static final String document_2 = "doc2";
    List<String> asd =new LinkedList<>();
    List<String> asd1 =new ArrayList<>();
    final static Logger logger = Logger.getLogger(AppMain.class);
    final static DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ISO_LOCAL_TIME;
    public static void main(String[] args) {
        Faker  faker=new Faker();
        // data came from frontend//

        String issues="This issue came from frontend";
//        BaseStatus communicationStatus=new CommunicationStatus(issues,"OK","NOT-OK","OK");

        List<String> availableFlies=List.of(Document_1, document_2);
        StandardFileStatus standardFileStatus=new StandardFileStatus(availableFlies);
         issues=faker.shakespeare().romeoAndJulietQuote();
         NsopStorageStatus nsopStorageStatus=new NsopStorageStatus(HEALTHY, HEALTHY);

        StorageIssues storageStatus=new StorageIssues(issues,HEALTHY,nsopStorageStatus);

        LocalDateTime createdAt=LocalDateTime.now();
        LocalDateTime modifiedAt=LocalDateTime.now().plusHours(2);
        IUtils utils=new UtilsV3();

        BaseHealth terrestrialBaseHealth =new BaseHealth("terrestrial", HEALTHY);
        BaseHealth satelliteBaseHealth =new BaseHealth("satellite", HEALTHY);
        BaseHealth inc1Inc2BaseHealth =new BaseHealth("inc1-inc2", HEALTHY);
        List<BaseHealth> baseHealths =new ArrayList<>();
        baseHealths.add(terrestrialBaseHealth);
        baseHealths.add(satelliteBaseHealth);
        baseHealths.add(inc1Inc2BaseHealth);

        ParallelChain inc1Server1=new ParallelChain("inc1Server1", HEALTHY, "Issues from inc1Ser1_Parallel Chain");
        ParallelChain inc1Server2=new ParallelChain("inc1Server2", HEALTHY, "Issues from inc1Ser2_Parallel Chain");
        ParallelChain inc2Server1=new ParallelChain("inc2Server1", HEALTHY, "Issues from inc2Ser1_Parallel Chain");
        ParallelChain inc2Server2=new ParallelChain("inc2Server2", HEALTHY, "Issues from inc2Ser2_Parallel Chain");

        List<ParallelChain> parallelChains=new ArrayList<>();
        parallelChains.add(inc1Server1);
        parallelChains.add(inc1Server2);
        parallelChains.add(inc2Server1);
        parallelChains.add(inc2Server2);

        TwstftOffset itsA=new TwstftOffset("itsA", 10.00, "itsA issues");
        TwstftOffset itsB=new TwstftOffset("itsB", 10.00, "itsB issues");
        TwstftOffset itsC=new TwstftOffset("itsC", 10.00, "itsC issues");
        List<TwstftOffset> twstftOffsets=new ArrayList<>();
        twstftOffsets.add(itsA);
        twstftOffsets.add(itsB);
        twstftOffsets.add(itsC);

        GnssOffset gnssItsA=new GnssOffset("itsA", 10.00, "itsA issues");
        GnssOffset gnssItsB=new GnssOffset("itsB", 10.00, "itsB issues");
        GnssOffset gnssItsC=new GnssOffset("itsC", 10.00, "itsC issues");
        GnssOffset vremyaA=new GnssOffset("vremyaA", 10.00, "vremyaA issues");
        GnssOffset vremyaB=new GnssOffset("vremyaB", 10.00, "vremyaB issues");
        GnssOffset itsInc2=new GnssOffset("itsInc2", 10.00, "itsInc2 issues");
        List<GnssOffset> gnssOffsets=new ArrayList<>();
        gnssOffsets.add(gnssItsA);
        gnssOffsets.add(gnssItsB);
        gnssOffsets.add(gnssItsC);
        gnssOffsets.add(vremyaA);
        gnssOffsets.add(vremyaB);
        gnssOffsets.add(itsInc2);

        SectionC sectionC = new SectionC(parallelChains, twstftOffsets, gnssOffsets);

        SchemacsHealth monitStatus=new SchemacsHealth("monitStatus", HEALTHY, "Issues in monit status");
        SchemacsHealth inc1Cs5=new SchemacsHealth("inc1Cs5", HEALTHY, "Issues in inc1Cs5");
        SchemacsHealth inc1Cs6=new SchemacsHealth("inc1Cs6", HEALTHY, "Issues in inc1Cs6");
        SchemacsHealth inc1Cs7=new SchemacsHealth("inc1Cs7", HEALTHY, "Issues in inc1Cs7");
        SchemacsHealth inc1Cs8=new SchemacsHealth("inc1Cs8", HEALTHY, "Issues in inc1Cs8");
        SchemacsHealth inc2Cs5=new SchemacsHealth("inc2Cs5", HEALTHY, "Issues in inc2Cs5");
        SchemacsHealth inc2Cs6=new SchemacsHealth("inc2Cs6", HEALTHY, "Issues in inc2Cs6");
        SchemacsHealth inc2Cs7=new SchemacsHealth("inc2Cs7", HEALTHY, "Issues in inc2Cs7");
        SchemacsHealth inc2Cs8=new SchemacsHealth("inc2Cs8", HEALTHY, "Issues in inc2Cs8");

        List<SchemacsHealth> schemacsHealths=new ArrayList<>();
        schemacsHealths.add(monitStatus);
        schemacsHealths.add(inc1Cs5);
        schemacsHealths.add(inc1Cs6);
        schemacsHealths.add(inc1Cs7);
        schemacsHealths.add(inc1Cs8);
        schemacsHealths.add(inc2Cs5);
        schemacsHealths.add(inc2Cs6);
        schemacsHealths.add(inc2Cs7);
        schemacsHealths.add(inc2Cs8);

        SectionD sectionD=new SectionD(schemacsHealths,"secttion D issue");


        CommunicationIssues communicationStatus=new CommunicationIssues("issue1", baseHealths);

        SectionA sectionA=new SectionA(communicationStatus);







//        List<BaseStatus> baseStatusList=List.of(communicationStatus,storageStatus,schemacsStatus);

        NSOP2 NSOP2=new NSOP2(HEALTHY, faker.number().numberBetween(10,18)+ STORAGE_UNIT);
        NSOP4 NSOP4=new NSOP4(UNHEALTHY, "13"+STORAGE_UNIT);
        NSDAQ1 NSDAQ1 =new NSDAQ1(HEALTHY, faker.number().numberBetween(2,10)+"G");
        NSDAQ2 NSDAQ2=new NSDAQ2(HEALTHY, "10G");





        List<ArchivalBaseClass> archivalList=new ArrayList<>();
        archivalList.add(NSOP2);
        archivalList.add(NSOP4);
        archivalList.add(NSDAQ1);
        archivalList.add(NSDAQ2);

        Uere sat02UereA=new Uere(SERVER1,BLR,faker.number().randomDouble(4,6,7),CHAIN_A,satellite_02);
        Uere sat03UereA=new Uere(SERVER1,BLR,faker.number().randomDouble(4,6,7),CHAIN_A,satellite_03);
        Uere sat02UereB=new Uere(SERVER1,BLR,faker.number().randomDouble(4,6,7),CHAIN_B,satellite_02);
        Uere sat03UereB=new Uere(SERVER1,BLR,faker.number().randomDouble(4,6,7),CHAIN_B,satellite_03);

        UserPosition userPosBlrServer1 = new UserPosition(SERVER1, BLR, faker.number().randomDouble(4,6,7), CHAIN_B,"a");
        UserPosition userPosBlrServer4 = new UserPosition(SERVER4, BLR, faker.number().randomDouble(4,6,7), CHAIN_B,"s");
        UserPosition userPosLckServer1 = new UserPosition(SERVER1, LCK, faker.number().randomDouble(4,6,7), CHAIN_B,"s");
        UserPosition userPosLckServer2 = new UserPosition(SERVER2, LCK, faker.number().randomDouble(4,6,7), CHAIN_B,"e");

        List<BaseMeasurement> userPositionMeasurements=new ArrayList<>();
        userPositionMeasurements.add(userPosBlrServer1);
        userPositionMeasurements.add(userPosBlrServer4);
        userPositionMeasurements.add(userPosLckServer1);
        userPositionMeasurements.add(userPosLckServer2);




         List<BaseMeasurement> uereMeasurements=new ArrayList<>();
         uereMeasurements.add(sat02UereA);
         uereMeasurements.add(sat03UereA);
         uereMeasurements.add(sat02UereB);
         uereMeasurements.add(sat03UereB);

        SectionE sectionE=new SectionE("Irms Issues", List.of("BLR", "MGH"));
        SectionF sectionF = new SectionF("Issues in sectionF", List.of("BLR", "DDN"));

        SyslogStatus syslogStatus = new SyslogStatus("syslogStatus", "Issues in Syslog status");
        SectionG sectionG = new SectionG(syslogStatus, "Issues in Section G");

        StnLookAngle stnLookAngleBPL= new StnLookAngle("BPL", LocalDateTime.now().plusHours(1));
        StnLookAngle stnLookAngleJDH= new StnLookAngle("JDH", LocalDateTime.now().plusHours(2));
        StnLookAngle stnLookAngleHSN= new StnLookAngle("HSN", LocalDateTime.now().minusMinutes(30));
        StnLookAngle stnLookAnglePBR= new StnLookAngle("PBR", LocalDateTime.now().plusHours(4));
        SectionH sectionH=new SectionH("Issues from Section H", List.of(stnLookAngleBPL,stnLookAngleHSN,stnLookAnglePBR,stnLookAngleJDH));

        SectionB sectionB=new SectionB(storageStatus, standardFileStatus,archivalList,uereMeasurements,userPositionMeasurements,"issue in sectoin B");
        NavICPerformanceDetails performanceDetails=new NavICPerformanceDetails(1000,sectionA,sectionB, sectionC, sectionD, sectionE, sectionF, sectionG, sectionH, createdAt,modifiedAt);



        List<ArchivalBaseClass> archivals=performanceDetails.getSectionB().getArchivalList();
        archivals.stream()
                .filter(theObj->theObj instanceof NSOP2)
                .map(theObj->(NSOP2)theObj)
                .forEach(logger::info);


        archivals.stream()
                .filter(theObj->theObj instanceof NSOP4)
                .map(theObj->(NSOP4)theObj)
                .forEach(logger::info);
        archivals.stream()
                .filter(theObj->theObj instanceof NSDAQ2)
                .map(theObj->(NSDAQ2)theObj)
                .forEach(logger::info);

        archivals.stream()
                .filter(theObj->theObj instanceof NSDAQ1)
                .map(theObj->(NSDAQ1)theObj)
                .forEach(logger::info);

        List<BaseMeasurement> retrievedUereMeasurements=performanceDetails.getSectionB().getUereMeasurements();

        retrievedUereMeasurements
                .stream()
                .filter(retrievedUereMeasurement -> retrievedUereMeasurement instanceof Uere)
                .map(retrievedUereMeasurement -> ((Uere) retrievedUereMeasurement))
                .forEach(logger::info);

        List<BaseMeasurement> retrievedUserPositionMeasurements=performanceDetails.getSectionB().getUserPositionMeasurements();

        retrievedUserPositionMeasurements.stream()
                .filter(theObj->theObj instanceof UserPosition)
                .map(theObj->(UserPosition)theObj)
                .forEach(logger::info);



        logger.info(performanceDetails.getSectionB().getIssues());
        logger.info(performanceDetails.getSectionD().getSchemacsHealths());
        logger.info(performanceDetails.getSectionE().getStationNames());
        logger.info(performanceDetails.getSectionF().getStationNames());
        logger.info(performanceDetails.getSectionH().getStnLookAngles());








    }
    private static Uere castToUere(BaseMeasurement measurement){
        return (Uere)measurement;
    }
    private static boolean isInstanceOfUere(BaseMeasurement measurement){
        return measurement instanceof  Uere;
    }
}


