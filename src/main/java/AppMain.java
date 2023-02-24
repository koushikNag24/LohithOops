import com.github.javafaker.Faker;
import dao.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.sections.base.BaseIssues;
import tutorial.dao.utils.jpahibernate.model.Course;
import tutorial.dao.utils.jpahibernate.model.Department;
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
import tutorial.dao.utils.jpahibernate.model.Student;
import tutorial.dao.utils.hibernate.IDBUtil;
import tutorial.dao.utils.jdbc.DBUtilv1;
import tutorial.dao.utils.jpahibernate.IJpaHibernateUtil;
import tutorial.dao.utils.jpahibernate.JpaHibernateUtilv1;
import tutorial.dao.utils.jpahibernate.model.inheritance.BaseHealthNew;
import tutorial.dao.utils.jpahibernate.model.inheritance.NewHealth;
import tutorial.dao.utils.jpahibernate.model.inheritance.SchemacsHealthNew;
import workutils.IUtils;
import workutils.UtilsV3;

import javax.swing.plaf.basic.BasicBorders;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AppMain {



    public static final String SERVER1 = "NSOP1";
    public static final String SERVER2 = "NSOP2";
    public static final String SERVER4 = "NSOP4";

    public static final char CHAIN_A = 'A';
    public static final char CHAIN_B = 'B';
    static final String BLR = "BLR";
    public static final String LCK = "LCK";
    public static final String STORAGE_UNIT = "G";
    public static final String satellite_02 = "SAT02";
    public static final String satellite_03 = "SAT03";
    public static final String satellite_10 = "SAT10";
    public static final String satellite_06 = "SAT06";
    public static final String satellite_09 = "SAT09";
    public static final String Document_1 = "Doct1";
    public static final String document_2 = "doc2";
    List<String> asd =new LinkedList<>();
    List<String> asd1 =new ArrayList<>();
    final static Logger logger = Logger.getLogger(AppMain.class);
    final static DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ISO_LOCAL_TIME;
    public static void main(String[] args) {
        sectionTask();
        Faker faker=new Faker();
        List<Course> courses=new ArrayList<>();

        IJpaHibernateUtil jpaHibernateUtil = new JpaHibernateUtilv1();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = factory.createEntityManager();

        ISectionGDao sectionGDao = new SectionGDao();
        BaseIssues sectionG=new SectionG();
        sectionG.setIssues(faker.weather().description());
        SyslogStatus syslogStatus=new SyslogStatus();
        syslogStatus.setStatus(Status.OK);
        syslogStatus.setName("SysLog");
        ((SectionG) sectionG).addSysLog(syslogStatus);
        sectionGDao.save(sectionG, entityManager);

        ISectionHDao sectionHDao = new SectionHDao();
        List<StnLookAngle> stnLookAngles =new ArrayList<>();
        SectionH sectionH = new SectionH();
        sectionH.setIssues("Issues is from section H");
        sectionH.setStnLookAngles(stnLookAngles);
        for(int i=0; i<3; i++) {
            StnLookAngle stnLookAngle = new StnLookAngle(faker.gameOfThrones().city(), LocalDateTime.now());
            stnLookAngles.add(stnLookAngle);
        }
        logger.info(stnLookAngles);
        sectionH.setStnLookAngles(stnLookAngles);

        sectionHDao.save(sectionH, entityManager);






        entityManager.close();






    }


    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void sectionTask() {
        IDBUtil idbUtil=new DBUtilv1();
        Faker  faker=new Faker();
        // data came from frontend//

        String issues="This issue came from frontend";
//        BaseStatus communicationStatus=new CommunicationStatus(issues,"OK","NOT-OK","OK");

        StandardFileStatus standardFileStatus = getStandardFileStatus();
        issues=faker.shakespeare().romeoAndJulietQuote();
        StorageIssues storageStatus = getStorageIssues(issues);


        LocalDateTime createdAt=LocalDateTime.now();
        LocalDateTime modifiedAt=LocalDateTime.now().plusHours(2);
        IUtils utils=new UtilsV3();

        CommunicationIssues communicationStatus = getCommunicationIssues();

        SectionA sectionA=new SectionA(communicationStatus);

        SectionB sectionB = getSectionB(faker, standardFileStatus, storageStatus);

        SectionC sectionC = getSectionC();

        SectionD sectionD = getSectionD();

        SectionE sectionE=new SectionE("Irms Issues", List.of("BLR", "MGH"));

        SectionF sectionF = new SectionF("Issues in sectionF", List.of("BLR", "DDN"));

//        List<BaseStatus> baseStatusList=List.of(communicationStatus,storageStatus,schemacsStatus);

        SectionG sectionG = getSectionG();

        SectionH sectionH = getSectionH();


        NavICPerformanceDetails performanceDetails=new NavICPerformanceDetails(1000,sectionA,sectionB, sectionC, sectionD, sectionE, sectionF, sectionG, sectionH, createdAt,modifiedAt);


        List<ArchivalBaseClass> archivals=performanceDetails.getSectionB().getArchivalList();


//        logger.info(performanceDetails.getSectionB().getIssues());
//        logger.info(performanceDetails.getSectionD().getSchemacsHealths());
//        logger.info(performanceDetails.getSectionE().getStationNames());
//        logger.info(performanceDetails.getSectionH().getStnLookAngles());
        Uere sat10Uere = null;


        showSectionB(performanceDetails, sat10Uere);
    }

    private static void showSectionB(NavICPerformanceDetails performanceDetails, Uere sat10Uere) {
        SectionB retrievedSectionB= performanceDetails.getSectionB();
        if(retrievedSectionB!=null){
            List<BaseMeasurement> measurements=retrievedSectionB.getUereMeasurements();
            if(measurements!=null && !measurements.isEmpty()){
                BaseMeasurement baseMeasurement=measurements.get(measurements.size()-1);
                if(baseMeasurement instanceof  Uere){
                    sat10Uere =((Uere)baseMeasurement);
                }
            }
        }

        if(sat10Uere !=null){
//            logger.info(sat10Uere + " - "+ sat10Uere.getSatellite());
        }
    }

    private static SectionH getSectionH() {
        StnLookAngle stnLookAngleBPL= new StnLookAngle("BPL", LocalDateTime.now().plusHours(1));
        StnLookAngle stnLookAngleJDH= new StnLookAngle("JDH", LocalDateTime.now().plusHours(2));
        StnLookAngle stnLookAngleHSN= new StnLookAngle("HSN", LocalDateTime.now().minusMinutes(30));
        StnLookAngle stnLookAnglePBR= new StnLookAngle("PBR", LocalDateTime.now().plusHours(4));
        SectionH sectionH=new SectionH("Issues from Section H", List.of(stnLookAngleBPL,stnLookAngleHSN,stnLookAnglePBR,stnLookAngleJDH));
        return sectionH;
    }

    private static SectionG getSectionG() {
        SyslogStatus syslogStatus = new SyslogStatus("syslogStatus", Status.OK);
        SectionG sectionG = new SectionG(syslogStatus, "Issues in Section G");
        return sectionG;
    }

    private static SectionB getSectionB(Faker faker, StandardFileStatus standardFileStatus, StorageIssues storageStatus) {
        List<ArchivalBaseClass> archivalList = getArchivalBaseClasses(faker);

        List<BaseMeasurement> uereMeasurements = getBaseMeasurements(faker);

        List<BaseMeasurement> userPositionMeasurements = getMeasurements(faker);


        SectionB sectionB=new SectionB(storageStatus, standardFileStatus,archivalList,uereMeasurements,userPositionMeasurements,"issue in sectoin B");
        return sectionB;
    }

    private static List<BaseMeasurement> getMeasurements(Faker faker) {
        UserPosition userPosBlrServer1 = new UserPosition(SERVER1, BLR, faker.number().randomDouble(4,6,7), CHAIN_B,"a");
        UserPosition userPosBlrServer4 = new UserPosition(SERVER4, BLR, faker.number().randomDouble(4,6,7), CHAIN_B,"s");
        UserPosition userPosLckServer1 = new UserPosition(SERVER1, LCK, faker.number().randomDouble(4,6,7), CHAIN_B,"s");
        UserPosition userPosLckServer2 = new UserPosition(SERVER2, LCK, faker.number().randomDouble(4,6,7), CHAIN_B,"e");

        List<BaseMeasurement> userPositionMeasurements=new ArrayList<>();
        userPositionMeasurements.add(userPosBlrServer1);
        userPositionMeasurements.add(userPosBlrServer4);
        userPositionMeasurements.add(userPosLckServer1);
        userPositionMeasurements.add(userPosLckServer2);
        return userPositionMeasurements;
    }

    private static List<BaseMeasurement> getBaseMeasurements(Faker faker) {
        Uere sat02UereA=new Uere(SERVER1,BLR, faker.number().randomDouble(4,6,7),CHAIN_A,satellite_02);
        Uere sat03UereA=new Uere(SERVER1,BLR, faker.number().randomDouble(4,6,7),CHAIN_A,satellite_03);
        Uere sat02UereB=new Uere(SERVER1,BLR, faker.number().randomDouble(6,6,7),CHAIN_B,satellite_02);
        Uere sat03UereB=new Uere(SERVER2,LCK, faker.number().randomDouble(6,20,30),CHAIN_B,satellite_06);
        Uere sat10UereB=new Uere(SERVER2,LCK, faker.number().randomDouble(6,20,30),CHAIN_B,satellite_10);
        List<BaseMeasurement> uereMeasurements=new ArrayList<>();
        uereMeasurements.add(sat02UereA);
        uereMeasurements.add(sat03UereA);
        uereMeasurements.add(sat02UereB);
        uereMeasurements.add(sat03UereB);
        uereMeasurements.add(sat10UereB);
        return uereMeasurements;
    }

    private static List<ArchivalBaseClass> getArchivalBaseClasses(Faker faker) {
        NSOP2 NSOP2=new NSOP2(Status.OK, faker.number().numberBetween(10,18)+ STORAGE_UNIT);
        NSOP4 NSOP4=new NSOP4(Status.NOTOK, faker.number().numberBetween(10,18)+STORAGE_UNIT);
        NSDAQ1 NSDAQ1 =new NSDAQ1(Status.NOTOK, faker.number().numberBetween(2,10)+"G");
        NSDAQ2 NSDAQ2=new NSDAQ2(Status.OK, "10G");

        List<ArchivalBaseClass> archivalList=new ArrayList<>();
        archivalList.add(NSOP2);
        archivalList.add(NSOP4);
        archivalList.add(NSDAQ1);
        archivalList.add(NSDAQ2);
        return archivalList;
    }

    private static SectionD getSectionD() {
        SchemacsHealth monitStatus=new SchemacsHealth("monitStatus", Status.OK, "Issues in monit status");
        SchemacsHealth inc1Cs5=new SchemacsHealth("inc1Cs5", Status.OK, "Issues in inc1Cs5");
        SchemacsHealth inc1Cs6=new SchemacsHealth("inc1Cs6", Status.OK, "Issues in inc1Cs6");
        SchemacsHealth inc1Cs7=new SchemacsHealth("inc1Cs7", Status.OK, "Issues in inc1Cs7");
        SchemacsHealth inc1Cs8=new SchemacsHealth("inc1Cs8", Status.OK, "Issues in inc1Cs8");
        SchemacsHealth inc2Cs5=new SchemacsHealth("inc2Cs5", Status.OK, "Issues in inc2Cs5");
        SchemacsHealth inc2Cs6=new SchemacsHealth("inc2Cs6", Status.OK, "Issues in inc2Cs6");
        SchemacsHealth inc2Cs7=new SchemacsHealth("inc2Cs7", Status.OK, "Issues in inc2Cs7");
        SchemacsHealth inc2Cs8=new SchemacsHealth("inc2Cs8", Status.OK, "Issues in inc2Cs8");

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
        return sectionD;
    }

    private static SectionC getSectionC() {
        List<ParallelChain> parallelChains = getParallelChains();

        List<TwstftOffset> twstftOffsets = getTwstftOffsets();

        List<GnssOffset> gnssOffsets = getGnssOffsets();

        SectionC sectionC = new SectionC(parallelChains, twstftOffsets, gnssOffsets);
        return sectionC;
    }

    private static List<GnssOffset> getGnssOffsets() {
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
        return gnssOffsets;
    }

    public static List<TwstftOffset> getTwstftOffsets() {
        TwstftOffset itsA=new TwstftOffset("itsA", 10.00, "itsA issues");
        TwstftOffset itsB=new TwstftOffset("itsB", 10.00, "itsB issues");
        TwstftOffset itsC=new TwstftOffset("itsC", 10.00, "itsC issues");
        List<TwstftOffset> twstftOffsets=new ArrayList<>();
        twstftOffsets.add(itsA);
        twstftOffsets.add(itsB);
        twstftOffsets.add(itsC);
        return twstftOffsets;
    }

     public static List<ParallelChain> getParallelChains() {
        ParallelChain inc1Server1=new ParallelChain("inc1Server1", Status.OK, "Issues from inc1Ser1_Parallel Chain");
        ParallelChain inc1Server2=new ParallelChain("inc1Server2", Status.OK, "Issues from inc1Ser2_Parallel Chain");
        ParallelChain inc2Server1=new ParallelChain("inc2Server1", Status.OK, "Issues from inc2Ser1_Parallel Chain");
        ParallelChain inc2Server2=new ParallelChain("inc2Server2", Status.OK, "Issues from inc2Ser2_Parallel Chain");

        List<ParallelChain> parallelChains=new ArrayList<>();
        parallelChains.add(inc1Server1);
        parallelChains.add(inc1Server2);
        parallelChains.add(inc2Server1);
        parallelChains.add(inc2Server2);
        return parallelChains;
    }

    private static CommunicationIssues getCommunicationIssues() {
        BaseHealth terrestrialBaseHealth =new BaseHealth("terrestrial", Status.OK);
        BaseHealth satelliteBaseHealth =new BaseHealth("satellite", Status.OK);
        BaseHealth inc1Inc2BaseHealth =new BaseHealth("inc1-inc2", Status.OK);
        List<BaseHealth> baseHealths =new ArrayList<>();
        baseHealths.add(terrestrialBaseHealth);
        baseHealths.add(satelliteBaseHealth);
        baseHealths.add(inc1Inc2BaseHealth);
        CommunicationIssues communicationStatus=new CommunicationIssues("issue1", baseHealths);
        return communicationStatus;
    }

    private static StorageIssues getStorageIssues(String issues) {
       NsopStorageStatus shiftOps = new NsopStorageStatus("172.19.2.145(ShiftOps)", Status.OK );
        NsopStorageStatus nsop1 = new NsopStorageStatus("172.19.4.15(NSOP-1)", Status.OK );
        NsopStorageStatus nsop2 = new NsopStorageStatus("172.19.7.15(NSOP-2", Status.OK );
        List<NsopStorageStatus> storages = List.of(shiftOps, nsop1, nsop2);
        StorageIssues storageIssues = new StorageIssues(storages, "Everything is fine");
        return storageIssues;

    }

    private static StandardFileStatus getStandardFileStatus() {
        List<String> availableFiles=List.of(Document_1, document_2);
        StandardFileStatus standardFileStatus=new StandardFileStatus(availableFiles);
        return standardFileStatus;
    }

    private static Uere castToUere(BaseMeasurement measurement){
        return (Uere)measurement;
    }
    private static boolean isInstanceOfUere(BaseMeasurement measurement){
        return measurement instanceof  Uere;
    }
}


