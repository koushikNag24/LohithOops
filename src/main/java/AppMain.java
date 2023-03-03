import com.github.javafaker.Faker;
import dao.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.enumer.IrimsChain;
import model.enumer.IrimsMode1Stn;
import model.enumer.StationName;
import model.sections.base.BaseIssues;
import model.sections.base.BaseMaintenance;
import model.sections.sectiona.LinkStatus;
import model.sections.sectionb.*;
import model.*;
import model.sections.sectionb.measurements.BaseMeasurement;
import model.sections.sectionb.measurements.Uere;
import model.sections.sectionb.measurements.UserPosition;
import model.sections.sectiona.CommunicationIssue;
import model.sections.sectiona.SectionA;
import model.sections.sectionb.archival.good.*;
import model.sections.sectionc.GnssOffset;
import model.sections.sectionc.ParallelChain;
import model.sections.sectionc.SectionC;
import model.sections.sectionc.TwstftOffset;
import model.sections.sectiond.SchemacsHealth;
import model.sections.sectiond.SectionD;

import model.sections.sectione.SectionE;
import model.sections.sectione.Station;
import model.sections.sectionf.SectionF;
import model.sections.sectiong.SectionG;
import model.sections.sectiong.SyslogStatus;
import model.sections.sectionh.SectionH;
import model.sections.sectionh.StnLookAngle;
import org.apache.log4j.Logger;
import tutorial.dao.utils.hibernate.IDBUtil;
import tutorial.dao.utils.jdbc.DBUtilv1;
import workutils.IUtils;
import workutils.UtilsV3;

import java.time.LocalDateTime;
import java.util.*;

public class AppMain {

    public static final String SERVER1 = "NSOP1";
    public static final String SERVER2 = "NSOP2";
    public static final String SERVER4 = "NSOP4";


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

    final static Logger logger = Logger.getLogger(AppMain.class);

    public static void main(String[] args) {
        sectionTask();
        Faker faker = new Faker();


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = factory.createEntityManager();

        ISectionGDao sectionGDao = new SectionGDao();
        SectionG sectionG = new SectionG();

        SyslogStatus syslogStatus = new SyslogStatus();
        syslogStatus.setStatus(Status.OK);
        syslogStatus.setName("SysLog");
        ((SectionG) sectionG).addSysLog(syslogStatus);


        ISectionHDao sectionHDao = new SectionHDao();
        Set<StnLookAngle> stnLookAngles = new HashSet<>();
        BaseIssues sectionH = new SectionH();
        sectionH.setIssues("Issues is from section H");
        for (int i = 0; i < 3; i++) {
            StnLookAngle stnLookAngle = new StnLookAngle(faker.gameOfThrones().city(), LocalDateTime.now());
            stnLookAngle.addSectionH((SectionH) sectionH);
            ((SectionH) sectionH).addStnLookAngle(stnLookAngle);
        }

        logger.info(stnLookAngles);

        sectionHDao.save((SectionH) sectionH, entityManager);

        ISectionDDao sectionDDao = new SectionDDao();
        Set<SchemacsHealth> schemacsHealths = new HashSet<>();
        BaseIssues sectionD = new SectionD();
        sectionD.setIssues("Issue is from Section D!!");
        for (int i = 0; i < 9; i++) {
            SchemacsHealth schemacsHealth = new SchemacsHealth( faker.harryPotter().character(), Status.OK, "Issue is from schemacs"+i);
            ((SectionD) sectionD).addSchemacsHealth(schemacsHealth);
        }
//        logger.info(schemacsHealths);
        sectionDDao.save((SectionD) sectionD, entityManager);



        ISectionADao sectionADao = new SectionADao();
        Set<LinkStatus> baseHealths = new HashSet<>();
        CommunicationIssue communicationIssue = new CommunicationIssue();
        for(int i=0; i<3; i++) {
            LinkStatus baseHealth = new LinkStatus(faker.book().author(), Status.OK, "issue from SectionA_"+i);
            communicationIssue.addLinkStatus(baseHealth);
        }
        logger.info(baseHealths);
        SectionA sectionA = new SectionA();
        sectionA.addCommunicationStatus(communicationIssue);
        sectionADao.save(sectionA, entityManager);


        ISectionBDao sectionBDao = new SectionBDao();
        SectionB sectionB = new SectionB();
        StorageIssues storageStatus = new StorageIssues();
        storageStatus.setIssues("Issue is from Storage ");
        for(int i=0; i<3; i++) {
            NsopStorageStatus nsopStorageStatus = new NsopStorageStatus("NSOP" + i, Status.NOT_OK);
            storageStatus.addNsopStorageStatus(nsopStorageStatus);
        }
        sectionB.addStorageStatus(storageStatus);

        NavigationArchival nsop2 = new NSOP2(Status.OK, "10G");
        NavigationArchival nsop4 = new NSOP4(Status.OK, "10G");
        NavigationArchival nsdaq1 = new NSDAQ1(Status.OK, "10G");
        NavigationArchival nsdaq2 = new NSDAQ2(Status.OK, "10G");

        Set<NavigationArchival> archivalList = Set.of(nsop2, nsop4, nsdaq1, nsdaq2);

        sectionB.addNavigationArchival(nsop2);
        sectionB.addNavigationArchival(nsop4);
        sectionB.addNavigationArchival(nsdaq1);
        sectionB.addNavigationArchival(nsdaq2);

        for(int i=0; i<16; i++){
            Measurement measurement = new Measurement("inc1nsop", IrimsMode1Stn.BLR, 12.00, IrimsChain.B);
            sectionB.addMeasurements(measurement);
        }

        StandardFileStatus standardFileStatus = new StandardFileStatus();
        StandardFile doc1 = new StandardFile("Doc1");
        StandardFile doc2 = new StandardFile("Doc2");
        StandardFile doc3 = new StandardFile("Doc3");
        StandardFile doc5 = new StandardFile("Doc5");
        StandardFile doc4 = new StandardFile("Doc4");
        standardFileStatus.addStandardFile(doc1);
        standardFileStatus.addStandardFile(doc2);
        standardFileStatus.addStandardFile(doc3);
        standardFileStatus.addStandardFile(doc4);
        standardFileStatus.addStandardFile(doc5);

        sectionB.addStandardFilesStatus(standardFileStatus);
        sectionBDao.save(sectionB, entityManager);

        ISectionEDao sectionEDao = new SectionEDao();

        Station blrStation=new Station();
        blrStation.setName(StationName.Bengaluru);
        Station dhlStation=new Station();
        dhlStation.setName(StationName.Delhi);

        SectionE sectionE=new SectionE();
        sectionE.setIssues("Issues is from Base Maintenance");
        sectionE.addStation(blrStation);
        sectionE.addStation(dhlStation);


        sectionEDao.save(sectionE, entityManager);

        ISectionFDao sectionFDao = new SectionFDao();
        SectionF sectionF = new SectionF();
        sectionF.setIssues("Issues is from Base Maintenance");
        sectionF.addStation(blrStation);
        sectionF.addStation(dhlStation);

        sectionFDao.save(sectionF, entityManager);




        ISectionCDao sectionCDao= new SectionCDao();
        SectionC sectionC = new SectionC();
        ParallelChain inc1server1 = new ParallelChain("inc1server1", Status.OK, "This ISsue is from C (parallel Chain)");
        sectionC.addParallelChain(inc1server1);
        ParallelChain inc2server1 = new ParallelChain("inc2server1", Status.OK, "This ISsue is from C (parallel Chain)");
        sectionC.addParallelChain(inc2server1);

        GnssOffset itsaGnss =  new GnssOffset("itsaGnss", 12.00, "This ISsue is from C (Gnss offset)");
        GnssOffset itsbGnss =  new GnssOffset("itsbGnss", 12.00, "This ISsue is from C (gnss Offset)");
        sectionC.addGnssOffset(itsaGnss);
        sectionC.addGnssOffset(itsbGnss);
        TwstftOffset itsA = new TwstftOffset("itsa", 12.00, "This ISsue is from C (twstft)");
        TwstftOffset itsb = new TwstftOffset("itsb", 12.00, "This ISsue is from C (twstft)");
        sectionC.addTwstftOffset(itsA);
        sectionC.addTwstftOffset(itsb);






        sectionCDao.save(sectionC, entityManager);






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

        CommunicationIssue communicationStatus = getCommunicationIssues();

        SectionA sectionA=new SectionA(communicationStatus);

        SectionB sectionB = getSectionB(faker, standardFileStatus, storageStatus);

        SectionC sectionC = getSectionC();

        SectionD sectionD = getSectionD();
//        Station Bengaluru = new Station(StationName.Bengaluru);
//        Station Lucknow = new Station(StationName.Lucknow);
//        Station PortBlair = new Station(StationName.PortBlair);
//        Station Hassan = new Station(StationName.Hassan);
//
//        SectionE sectionE=new SectionE("Irms Issues", Set.of(Bengaluru, Hassan));

//
//        SectionF sectionF = new SectionF("Issues in sectionF", Set.of(Bengaluru, Lucknow));

//        List<BaseStatus> baseStatusList=List.of(communicationStatus,storageStatus,schemacsStatus);

        SectionG sectionG = getSectionG();

        SectionH sectionH = getSectionH();


//        NavICPerformanceDetails performanceDetails=new NavICPerformanceDetails(1000,sectionA,sectionB, sectionC, sectionD, sectionE, sectionF, sectionG, sectionH, createdAt,modifiedAt);


//        Set<NavigationArchival> archivals=performanceDetails.getSectionB().getArchivalList();


//        logger.info(performanceDetails.getSectionB().getIssues());
//        logger.info(performanceDetails.getSectionD().getSchemacsHealths());
//        logger.info(performanceDetails.getSectionE().getStationNames());
//        logger.info(performanceDetails.getSectionH().getStnLookAngles());
        Uere sat10Uere = null;


//        try {
//            showSectionB(performanceDetails, sat10Uere);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
    private  static <T> void handleNullException(T t) throws Exception {
        if(t==null){
            throw  new Exception(t + " is null ");
        }
    }

//    private static void showSectionB(NavICPerformanceDetails performanceDetails, Uere sat10Uere) throws Exception {
//        SectionB retrievedSectionB= performanceDetails.getSectionB();
//        handleNullException(retrievedSectionB);
//
//        List<Measurements> measurements=retrievedSectionB.getUereMeasurements();
//        if(measurements==null && measurements.isEmpty()){
//            throw new Exception("Section B Measurement is null or No Measurements");
//        }
//
//        BaseMeasurement baseMeasurement=measurements.get(measurements.size()-1);
//        if(baseMeasurement instanceof  Uere){
//            sat10Uere =((Uere)baseMeasurement);
//        }
//
//
//        if(sat10Uere !=null){
////            logger.info(sat10Uere + " - "+ sat10Uere.getSatellite());
//        }
//    }

    private static SectionH getSectionH() {
        StnLookAngle stnLookAngleBPL= new StnLookAngle("BPL", LocalDateTime.now().plusHours(1));
        StnLookAngle stnLookAngleJDH= new StnLookAngle("JDH", LocalDateTime.now().plusHours(2));
        StnLookAngle stnLookAngleHSN= new StnLookAngle("HSN", LocalDateTime.now().minusMinutes(30));
        StnLookAngle stnLookAnglePBR= new StnLookAngle("PBR", LocalDateTime.now().plusHours(4));
        SectionH sectionH=new SectionH("Issues from Section H", Set.of(stnLookAngleBPL,stnLookAngleHSN,stnLookAnglePBR,stnLookAngleJDH));
        return sectionH;
    }

    private static SectionG getSectionG() {
        SyslogStatus syslogStatus = new SyslogStatus("syslogStatus", Status.OK, "Issue is from syslog d");
        SectionG sectionG = new SectionG(syslogStatus);
        return sectionG;
    }

    private static SectionB getSectionB(Faker faker, StandardFileStatus standardFileStatus, StorageIssues storageStatus) {
        NavigationArchival nsop2 = new NSOP2(Status.OK, "10G");
        NavigationArchival nsop4 = new NSOP4(Status.OK, "10G");
        NavigationArchival nsdaq1 = new NSDAQ1(Status.OK, "10G");
        NavigationArchival nsdaq2 = new NSDAQ2(Status.OK, "10G");
        Set<NavigationArchival> archivalList = Set.of(nsop2, nsop4, nsdaq1, nsdaq2);

        Set<Measurement> uereMeasurements = getBaseMeasurements(faker);

        Set<Measurement> userPositionMeasurements = getBaseMeasurements(faker);


        SectionB sectionB=new SectionB(storageStatus, standardFileStatus,archivalList,uereMeasurements,userPositionMeasurements,"issue in sectoin B");
        return sectionB;
    }

    private static List<BaseMeasurement> getMeasurements(Faker faker) {
        UserPosition userPosBlrServer1 = new UserPosition(SERVER1, IrimsMode1Stn.BLR, faker.number().randomDouble(4,6,7), IrimsChain.A);
        UserPosition userPosBlrServer4 = new UserPosition(SERVER4, IrimsMode1Stn.BLR, faker.number().randomDouble(4,6,7), IrimsChain.B);
        UserPosition userPosLckServer1 = new UserPosition(SERVER1, IrimsMode1Stn.LCK, faker.number().randomDouble(4,6,7), IrimsChain.B);
        UserPosition userPosLckServer2 = new UserPosition(SERVER2, IrimsMode1Stn.LCK, faker.number().randomDouble(4,6,7), IrimsChain.B);

        List<BaseMeasurement> userPositionMeasurements=new ArrayList<>();
        userPositionMeasurements.add(userPosBlrServer1);
        userPositionMeasurements.add(userPosBlrServer4);
        userPositionMeasurements.add(userPosLckServer1);
        userPositionMeasurements.add(userPosLckServer2);
        return userPositionMeasurements;
    }

    private static Set<Measurement> getBaseMeasurements(Faker faker) {
        Uere sat02UereA=new Uere(SERVER1,IrimsMode1Stn.BLR, faker.number().randomDouble(4,6,7), IrimsChain.A,satellite_02);
        Uere sat03UereA=new Uere(SERVER1,IrimsMode1Stn.BLR, faker.number().randomDouble(4,6,7),IrimsChain.A,satellite_03);
        Uere sat02UereB=new Uere(SERVER1,IrimsMode1Stn.BLR, faker.number().randomDouble(6,6,7),IrimsChain.B,satellite_02);
        Uere sat03UereB=new Uere(SERVER2,IrimsMode1Stn.LCK, faker.number().randomDouble(6,20,30),IrimsChain.B,satellite_06);
        Uere sat10UereB=new Uere(SERVER2,IrimsMode1Stn.LCK, faker.number().randomDouble(6,20,30),IrimsChain.A,satellite_10);
        Set<Measurement> uereMeasurements=new HashSet<>();
//        uereMeasurements.add(sat02UereA);
//        uereMeasurements.add(sat03UereA);
//        uereMeasurements.add(sat02UereB);
//        uereMeasurements.add(sat03UereB);
//        uereMeasurements.add(sat10UereB);
        return uereMeasurements;
    }

    private static List<NavigationArchival> getArchivalBaseClasses(Faker faker) {
        NSOP2 NSOP2=new NSOP2(Status.OK, faker.number().numberBetween(10,18)+ STORAGE_UNIT);
        NSOP4 NSOP4=new NSOP4(Status.NOT_OK, faker.number().numberBetween(10,18)+STORAGE_UNIT);
        NSDAQ1 NSDAQ1 =new NSDAQ1(Status.NOT_OK, faker.number().numberBetween(2,10)+"G");
        NSDAQ2 NSDAQ2=new NSDAQ2(Status.OK, "10G");

        List<NavigationArchival> archivalList=new ArrayList<>();
        archivalList.add(NSOP2);
        archivalList.add(NSOP4);
        archivalList.add(NSDAQ1);
        archivalList.add(NSDAQ2);
        return archivalList;
    }

    private static SectionD getSectionD() {
        SchemacsHealth monitStatus=new SchemacsHealth("monitStatus", Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc1Cs5=new SchemacsHealth("inc1Cs5", Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc1Cs6=new SchemacsHealth("inc1Cs6", Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc1Cs7=new SchemacsHealth("inc1Cs7", Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc1Cs8=new SchemacsHealth("inc1Cs8", Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc2Cs5=new SchemacsHealth("inc2Cs5", Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc2Cs6=new SchemacsHealth("inc2Cs6", Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc2Cs7=new SchemacsHealth("inc2Cs7", Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc2Cs8=new SchemacsHealth("inc2Cs8", Status.OK, "issues is from schemacsHealth");

        Set<SchemacsHealth> schemacsHealths=new HashSet<>();
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
        Set<ParallelChain> parallelChains = getParallelChains();

        Set<TwstftOffset> twstftOffsets = getTwstftOffsets();

        Set<GnssOffset> gnssOffsets = getGnssOffsets();

        SectionC sectionC = new SectionC(parallelChains, twstftOffsets, gnssOffsets);
        return sectionC;
    }

    private static Set<GnssOffset> getGnssOffsets() {
        GnssOffset gnssItsA=new GnssOffset("itsA", 10.00, "itsA issues");
        GnssOffset gnssItsB=new GnssOffset("itsB", 10.00, "itsB issues");
        GnssOffset gnssItsC=new GnssOffset("itsC", 10.00, "itsC issues");
        GnssOffset vremyaA=new GnssOffset("vremyaA", 10.00, "vremyaA issues");
        GnssOffset vremyaB=new GnssOffset("vremyaB", 10.00, "vremyaB issues");
        GnssOffset itsInc2=new GnssOffset("itsInc2", 10.00, "itsInc2 issues");
        Set<GnssOffset> gnssOffsets=new HashSet<>();
        gnssOffsets.add(gnssItsA);
        gnssOffsets.add(gnssItsB);
        gnssOffsets.add(gnssItsC);
        gnssOffsets.add(vremyaA);
        gnssOffsets.add(vremyaB);
        gnssOffsets.add(itsInc2);
        return gnssOffsets;
    }

    public static Set<TwstftOffset> getTwstftOffsets() {
        TwstftOffset itsA=new TwstftOffset("itsA", 10.00, "itsA issues");
        TwstftOffset itsB=new TwstftOffset("itsB", 10.00, "itsB issues");
        TwstftOffset itsC=new TwstftOffset("itsC", 10.00, "itsC issues");
        Set<TwstftOffset> twstftOffsets=new HashSet<>();
        twstftOffsets.add(itsA);
        twstftOffsets.add(itsB);
        twstftOffsets.add(itsC);
        return twstftOffsets;
    }

     public static Set<ParallelChain> getParallelChains() {
        ParallelChain inc1Server1=new ParallelChain("inc1Server1", Status.OK, "Issues in parallelChain" );
        ParallelChain inc1Server2=new ParallelChain("inc1Server2", Status.OK, "Issues in parallelChain");
        ParallelChain inc2Server1=new ParallelChain("inc2Server1", Status.OK, "Issues in parallelChain");
        ParallelChain inc2Server2=new ParallelChain("inc2Server2", Status.OK, "Issues in parallelChain");

         Set<ParallelChain> parallelChains=new HashSet<>();
        parallelChains.add(inc1Server1);
        parallelChains.add(inc1Server2);
        parallelChains.add(inc2Server1);
        parallelChains.add(inc2Server2);
        return parallelChains;
    }

    private static CommunicationIssue getCommunicationIssues() {
        LinkStatus terrestrialBaseHealth =new LinkStatus();
        LinkStatus satelliteBaseHealth =new LinkStatus();
        LinkStatus inc1Inc2BaseHealth =new LinkStatus();
        Set<LinkStatus> baseHealths =new HashSet<>();
        baseHealths.add(terrestrialBaseHealth);
        baseHealths.add(satelliteBaseHealth);
        baseHealths.add(inc1Inc2BaseHealth);
        CommunicationIssue communicationStatus=new CommunicationIssue(baseHealths);
        return communicationStatus;
    }

    private static StorageIssues getStorageIssues(String issues) {
       NsopStorageStatus shiftOps = new NsopStorageStatus("172.19.2.145(ShiftOps)", Status.OK );
        NsopStorageStatus nsop1 = new NsopStorageStatus("172.19.4.15(NSOP-1)", Status.OK );
        NsopStorageStatus nsop2 = new NsopStorageStatus("172.19.7.15(NSOP-2", Status.OK );
        Set<NsopStorageStatus> storages = Set.of(shiftOps, nsop1, nsop2);
        StorageIssues storageIssues = new StorageIssues(storages, "Everything is fine");
        return storageIssues;

    }

    private static StandardFileStatus getStandardFileStatus() {

        StandardFile doc1 = new StandardFile("Doc1");
        StandardFile doc2 = new StandardFile("Doc2");

        Set<StandardFile> availableFiles=Set.of(doc1, doc2);
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


