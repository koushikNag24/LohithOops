import com.github.javafaker.Faker;
import dao.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.enumer.*;
import model.sections.sectiona.LinkStatus;
import model.sections.sectionb.*;
import model.*;
import model.sections.sectionb.measurements.BaseMeasurement;
import model.sections.sectionb.measurements.Uere;
import model.sections.sectionb.measurements.UserPosition;
import model.sections.sectiona.CommunicationIssue;
import model.sections.sectiona.SectionA;
import model.sections.sectionb.archival.good.*;
import model.sections.sectionc.*;
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




    public static final String STORAGE_UNIT = "G";

    final static Logger logger = Logger.getLogger(AppMain.class);

    public static void main(String[] args) {
        sectionTask();
        Faker faker = new Faker();


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");

        EntityManager entityManager = factory.createEntityManager();





        LocalDateTime createdAt=LocalDateTime.now();
        LocalDateTime modifiedAt=LocalDateTime.now().plusHours(2);



        ISectionADao sectionADao = new SectionADao();
        Set<LinkStatus> baseHealths = new HashSet<>();
        CommunicationIssue communicationIssue = new CommunicationIssue();
        LinkStatus terrestrialLink = new LinkStatus(Names.TerrestrialLink, Status.OK, "issue from Terrestrial Link");
        communicationIssue.addLinkStatus(terrestrialLink);
        LinkStatus satelliteLink = new LinkStatus(Names.SatelliteLink, Status.OK, "issue from Satellite Link");
        communicationIssue.addLinkStatus(satelliteLink);
        LinkStatus inc1inc2 = new LinkStatus(Names.INC1INC2, Status.NOT_OK, "issue from INC1-INC2");
        communicationIssue.addLinkStatus(inc1inc2);
        logger.info(baseHealths);
        SectionA sectionA = new SectionA();
        sectionA.addCommunicationStatus(communicationIssue);

        sectionADao.save(sectionA, entityManager);



        ISectionBDao sectionBDao = new SectionBDao();
        SectionB sectionB = new SectionB();
        sectionB.setIssues("Issue is from Section B!!");
        StorageIssues storageStatus = new StorageIssues();
        storageStatus.setIssues("Issue is from Storage ");
        NsopStorageStatus shiftOps = new NsopStorageStatus(StorageNames.ShiftOPs, Status.NOT_OK);
        storageStatus.addNsopStorageStatus(shiftOps);
        NsopStorageStatus storageNsop1= new NsopStorageStatus(StorageNames.NSOP1, Status.NOT_OK);
        storageStatus.addNsopStorageStatus(storageNsop1);
        NsopStorageStatus storageNsop2 = new NsopStorageStatus(StorageNames.NSOP2, Status.NOT_OK);
        storageStatus.addNsopStorageStatus(storageNsop2);
        sectionB.addStorageStatus(storageStatus);
        NavigationArchival nsop2 = new NSOP2(ArchivalName.NSOP2 ,Status.OK, "10G");
        NavigationArchival nsop4 = new NSOP4(ArchivalName.NSOP4,Status.OK, "10G");
        NavigationArchival nsdaq1 = new NSDAQ1(ArchivalName.NSDAQ1,Status.OK, "10G");
        NavigationArchival nsdaq2 = new NSDAQ2(ArchivalName.NSDAQ2,Status.OK, "10G");
        Set<NavigationArchival> archivalList = Set.of(nsop2, nsop4, nsdaq1, nsdaq2);
        sectionB.addNavigationArchival(nsop2);
        sectionB.addNavigationArchival(nsop4);
        sectionB.addNavigationArchival(nsdaq1);
        sectionB.addNavigationArchival(nsdaq2);

//        UERE StreamA BLR
        Uere field1 = new Uere( Servers.INC1NSOP2, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT02);
        sectionB.addMeasurements(field1);
        Uere field2 = new Uere(Servers.INC1NSOP4, IrimsMode1Stn.BLR,   12.00, IrimsChain.A, Satellite.SAT02);
        sectionB.addMeasurements(field2);
        Uere field3 = new Uere(Servers.INC2NSOP1, IrimsMode1Stn.BLR,  12.00, IrimsChain.A, Satellite.SAT02);
        sectionB.addMeasurements(field3);
        Uere field4 = new Uere(Servers.INC2NSOP2, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT02);
        sectionB.addMeasurements(field4);
        Uere field5 = new Uere(Servers.INC1NSOP2, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT03);
        sectionB.addMeasurements(field5);
        Uere field6 = new Uere(Servers.INC1NSOP4, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT03);
        sectionB.addMeasurements(field6);
        Uere field7 = new Uere(Servers.INC2NSOP1, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT03);
        sectionB.addMeasurements(field7);
        Uere field8 = new Uere(Servers.INC2NSOP2, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT03);
        sectionB.addMeasurements(field8);
        Uere field9 = new Uere(Servers.INC1NSOP2, IrimsMode1Stn.BLR,  12.00, IrimsChain.A, Satellite.SAT06);
        sectionB.addMeasurements(field9);
        Uere field10 = new Uere(Servers.INC1NSOP4, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT06);
        sectionB.addMeasurements(field10);
        Uere field11 = new Uere(Servers.INC2NSOP1, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT06);
        sectionB.addMeasurements(field11);
        Uere field12 = new Uere(Servers.INC2NSOP2, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT06);
        sectionB.addMeasurements(field12);
        Uere field13 = new Uere(Servers.INC1NSOP2, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT09);
        sectionB.addMeasurements(field13);
        Uere field14 = new Uere(Servers.INC1NSOP4, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT09);
        sectionB.addMeasurements(field14);
        Uere field15 = new Uere(Servers.INC2NSOP1, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT09);
        sectionB.addMeasurements(field15);
        Uere field16 = new Uere(Servers.INC2NSOP2, IrimsMode1Stn.BLR, 12.00, IrimsChain.A, Satellite.SAT09);
        sectionB.addMeasurements(field16);

//        UserPosition
        UserPosition field65 = new UserPosition(Servers.INC1NSOP2, IrimsMode1Stn.LCK, 12.00);
        sectionB.addMeasurements(field65);
        UserPosition field66 = new UserPosition(Servers.INC1NSOP4, IrimsMode1Stn.LCK, 12.00);
        sectionB.addMeasurements(field66);
        UserPosition field67 = new UserPosition(Servers.INC2NSOP1, IrimsMode1Stn.LCK, 12.00);
        sectionB.addMeasurements(field67);
        UserPosition field68 = new UserPosition(Servers.INC2NSOP2, IrimsMode1Stn.LCK, 12.00);
        sectionB.addMeasurements(field68);
        UserPosition field69 = new UserPosition(Servers.INC1NSOP2, IrimsMode1Stn.BLR, 12.00);
        sectionB.addMeasurements(field69);
        UserPosition field70 = new UserPosition(Servers.INC1NSOP4, IrimsMode1Stn.BLR, 12.00);
        sectionB.addMeasurements(field70);
        UserPosition field71 = new UserPosition(Servers.INC2NSOP1, IrimsMode1Stn.BLR, 12.00);
        sectionB.addMeasurements(field71);
        UserPosition field72 = new UserPosition(Servers.INC2NSOP2, IrimsMode1Stn.BLR, 12.00);
        sectionB.addMeasurements(field72);

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



        ISectionCDao sectionCDao= new SectionCDao();
        SectionC sectionC = new SectionC();
        ParallelChain inc1server1 = new ParallelChain(Names.Inc1Server1, Status.OK, "This Issue is from C (parallel Chain Inc1Server1)");
        sectionC.addParallelChain(inc1server1);
        ParallelChain inc1server2 = new ParallelChain(Names.Inc1Server2, Status.OK, "This Issue is from C (parallel Chain Inc1Server2)");
        sectionC.addParallelChain(inc1server2);
        ParallelChain inc2server1 = new ParallelChain(Names.Inc2Server1, Status.OK, "This Issue is from C (parallel Chain Inc2Server1)");
        sectionC.addParallelChain(inc1server1);
        ParallelChain inc2server2 = new ParallelChain(Names.Inc2Server2, Status.OK, "This Issue is from C (parallel Chain Inc2Server2)");
        sectionC.addParallelChain(inc2server1);

        Irnwt irnwtChainA = new Irnwt(Names.IrnwtChainA, Status.OK, "Issue is from Irnwt Chain A");
        sectionC.addIrnwt(irnwtChainA);
        Irnwt irnwtChainB = new Irnwt(Names.IrnwtChainB, Status.NOT_OK, "Issue is from Irnwt Chain B");
        sectionC.addIrnwt(irnwtChainB);

        GnssOffset itsaGnss =  new GnssOffset(Names.ItsAGnss, 12.00, "This Issue is from C (ItsA Gnss offset)");
        GnssOffset itsbGnss =  new GnssOffset(Names.ItsBGnss, 12.00, "This ISsue is from C (gnss Offset)");
        GnssOffset ItscGnss =  new GnssOffset(Names.ItsCGnss, 10.00, "itsC issues");
        GnssOffset vremyaA=new GnssOffset(Names.VremyaA, 10.00, "vremyaA issues");
        GnssOffset vremyaB=new GnssOffset(Names.VremyaB, 10.00, "vremyaB issues");
        GnssOffset itsInc2=new GnssOffset(Names.ItsInc2, 10.00, "itsInc2 issues");
        sectionC.addGnssOffset(itsaGnss);
        sectionC.addGnssOffset(itsbGnss);
        sectionC.addGnssOffset(ItscGnss);
        sectionC.addGnssOffset(vremyaA);
        sectionC.addGnssOffset(vremyaB);
        sectionC.addGnssOffset(itsInc2);

        TwstftOffset itsA = new TwstftOffset(Names.TwstftOffsetItsA, 12.00, "This Issue is from C (twstft ITS-A)");
        TwstftOffset itsb = new TwstftOffset(Names.TwstftOffsetItsB, 12.00, "This Issue is from C (twstft ITS-B)");
        TwstftOffset itsc = new TwstftOffset(Names.TwstftOffsetItsC, 12.00, "This Issue is from C (twstft ITS-C)");
        sectionC.addTwstftOffset(itsA);
        sectionC.addTwstftOffset(itsb);
        sectionCDao.save(sectionC, entityManager);



        ISectionDDao sectionDDao = new SectionDDao();
        Set<SchemacsHealth> schemacsHealths = new HashSet<>();
        SectionD sectionD = new SectionD();
        sectionD.setIssues("Issue is from Section D!!");
        SchemacsHealth monitStatus = new SchemacsHealth( Names.MonitStatus, Status.OK, "Issue is from schemacs Monit Status");
        sectionD.addSchemacsHealth(monitStatus);
        SchemacsHealth inc1cs5 = new SchemacsHealth( Names.Inc1Cs5, Status.OK, "Issue is from schemacs Inc1Cs5");
        sectionD.addSchemacsHealth(inc1cs5);
        SchemacsHealth inc1cs6 = new SchemacsHealth( Names.Inc1Cs6, Status.OK, "Issue is from schemacs Inc1Cs6");
        sectionD.addSchemacsHealth(inc1cs6);
        SchemacsHealth inc1cs7 = new SchemacsHealth( Names.Inc1Cs7, Status.OK, "Issue is from schemacs Inc1Cs7");
        sectionD.addSchemacsHealth(inc1cs7);
        SchemacsHealth inc1cs8 = new SchemacsHealth( Names.Inc1Cs8, Status.OK, "Issue is from schemacs Inc1Cs8");
        sectionD.addSchemacsHealth(inc1cs8);
        SchemacsHealth inc2cs5 = new SchemacsHealth( Names.Inc2Cs5, Status.OK, "Issue is from schemacs Inc2Cs5");
        sectionD.addSchemacsHealth(inc2cs5);
        SchemacsHealth inc2cs6 = new SchemacsHealth( Names.Inc2Cs6, Status.OK, "Issue is from schemacs Inc2Cs6");
        sectionD.addSchemacsHealth(inc2cs6);
        SchemacsHealth inc2cs7 = new SchemacsHealth( Names.Inc2Cs7, Status.OK, "Issue is from schemacs Inc2Cs7");
        sectionD.addSchemacsHealth(inc2cs7);
        SchemacsHealth inc2cs8 = new SchemacsHealth( Names.Inc2Cs8, Status.OK, "Issue is from schemacs Inc2Cs8");
        sectionD.addSchemacsHealth(inc2cs8);
        sectionDDao.save(sectionD, entityManager);



        ISectionEDao sectionEDao = new SectionEDao();
        Station blrStation=new Station();
        blrStation.setName(StationName.Bengaluru);
        Station dhlStation=new Station();
        dhlStation.setName(StationName.Delhi);
        SectionE sectionE=new SectionE();
        sectionE.setIssues("Issues is from Base Maintenance Section E");
        sectionE.addStation(blrStation);
        sectionE.addStation(dhlStation);
        sectionEDao.save(sectionE, entityManager);



        ISectionFDao sectionFDao = new SectionFDao();
        SectionF sectionF = new SectionF();
        sectionF.setIssues("Issues is from Base Maintenance SectionF");
        sectionF.addStation(blrStation);
        sectionF.addStation(dhlStation);
        sectionFDao.save(sectionF, entityManager);



        ISectionGDao sectionGDao = new SectionGDao();
        SectionG sectionG = new SectionG();
        SyslogStatus syslogStatus = new SyslogStatus();
        syslogStatus.setStatus(Status.OK);
        syslogStatus.setName(Names.SyslogStatus);
        syslogStatus.setIssue("Issue is from syslog status");
        sectionG.addSysLog(syslogStatus);
        sectionGDao.save(sectionG, entityManager);



        ISectionHDao sectionHDao = new SectionHDao();
        Set<StnLookAngle> stnLookAngles = new HashSet<>();
        SectionH sectionH = new SectionH();
        sectionH.setIssues("Issues is from section H");
        StnLookAngle stnLookAngle1 = new StnLookAngle(StationName.Bengaluru, LocalDateTime.now());
        stnLookAngle1.addSectionH(sectionH);
        StnLookAngle stnLookAngle2 = new StnLookAngle(StationName.Lucknow, LocalDateTime.now());
        stnLookAngle2.addSectionH(sectionH);
        StnLookAngle stnLookAngle3 = new StnLookAngle(StationName.PortBlair, LocalDateTime.now());
        stnLookAngle3.addSectionH(sectionH);
        sectionH.addStnLookAngle(stnLookAngle1);
        sectionH.addStnLookAngle(stnLookAngle2);
        sectionH.addStnLookAngle(stnLookAngle3);
        logger.info(stnLookAngles);
        sectionHDao.save(sectionH, entityManager);




        INavicPerformanceDao navicPerformanceDao = new NavicPerformanceDao();
        NavicPerformanceDetails navicPerformanceDetails = new NavicPerformanceDetails();

        navicPerformanceDetails.setSectionA(sectionA);
        navicPerformanceDetails.setSectionB(sectionB);
        navicPerformanceDetails.setSectionC(sectionC);
        navicPerformanceDetails.setSectionD(sectionD);
        navicPerformanceDetails.setSectionE(sectionE);
        navicPerformanceDetails.setSectionF(sectionF);
        navicPerformanceDetails.setSectionG(sectionG);
        navicPerformanceDetails.setSectionH(sectionH);
        navicPerformanceDetails.setCreatedAt(LocalDateTime.now());
        navicPerformanceDetails.setModifiedAt(LocalDateTime.now().plusHours(5));

//        NavicPerformanceDetails performanceDetails=new NavicPerformanceDetails(sectionA, sectionB, sectionC, sectionD, sectionE, sectionF, sectionG, sectionH, createdAt,modifiedAt);

        navicPerformanceDao.save(navicPerformanceDetails, entityManager);
        entityManager.close();

    }


    //        NavICPerformanceDetails navICPerformanceDetails=getFromFrontend();//spring boot


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
        StnLookAngle stnLookAngleBPL= new StnLookAngle(StationName.PortBlair, LocalDateTime.now().plusHours(1));
        StnLookAngle stnLookAngleJDH= new StnLookAngle(StationName.PortBlair, LocalDateTime.now().plusHours(2));
        StnLookAngle stnLookAngleHSN= new StnLookAngle(StationName.PortBlair, LocalDateTime.now().minusMinutes(30));
        StnLookAngle stnLookAnglePBR= new StnLookAngle(StationName.PortBlair, LocalDateTime.now().plusHours(4));
        SectionH sectionH=new SectionH("Issues from Section H", Set.of(stnLookAngleBPL,stnLookAngleHSN,stnLookAnglePBR,stnLookAngleJDH));
        return sectionH;
    }

    private static SectionG getSectionG() {
        SyslogStatus syslogStatus = new SyslogStatus(Names.SyslogStatus, Status.OK, "Issue is from syslog d");
        SectionG sectionG = new SectionG(syslogStatus);
        return sectionG;
    }

    private static SectionB getSectionB(Faker faker, StandardFileStatus standardFileStatus, StorageIssues storageStatus) {
        NavigationArchival nsop2 = new NSOP2(ArchivalName.NSOP2, Status.OK, "10G");
        NavigationArchival nsop4 = new NSOP4(ArchivalName.NSOP4, Status.OK, "10G");
        NavigationArchival nsdaq1 = new NSDAQ1(ArchivalName.NSDAQ1, Status.OK, "10G");
        NavigationArchival nsdaq2 = new NSDAQ2(ArchivalName.NSDAQ2, Status.OK, "10G");
        Set<NavigationArchival> archivalList = Set.of(nsop2, nsop4, nsdaq1, nsdaq2);

        Set<Measurement> uereMeasurements = getBaseMeasurements(faker);

        Set<Measurement> userPositionMeasurements = getBaseMeasurements(faker);


        SectionB sectionB=new SectionB(storageStatus, standardFileStatus,archivalList,uereMeasurements,userPositionMeasurements,"issue in sectoin B");
        return sectionB;
    }

    private static List<BaseMeasurement> getMeasurements(Faker faker) {
        UserPosition userPosBlrServer1 = new UserPosition(Servers.INC1NSOP4, IrimsMode1Stn.BLR, faker.number().randomDouble(4,6,7));
        UserPosition userPosBlrServer4 = new UserPosition(Servers.INC1NSOP4, IrimsMode1Stn.BLR, faker.number().randomDouble(4,6,7));
        UserPosition userPosLckServer1 = new UserPosition(Servers.INC1NSOP4, IrimsMode1Stn.LCK, faker.number().randomDouble(4,6,7));
        UserPosition userPosLckServer2 = new UserPosition(Servers.INC1NSOP4, IrimsMode1Stn.LCK, faker.number().randomDouble(4,6,7));

        List<BaseMeasurement> userPositionMeasurements=new ArrayList<>();
        userPositionMeasurements.add(userPosBlrServer1);
        userPositionMeasurements.add(userPosBlrServer4);
        userPositionMeasurements.add(userPosLckServer1);
        userPositionMeasurements.add(userPosLckServer2);
        return userPositionMeasurements;
    }

    private static Set<Measurement> getBaseMeasurements(Faker faker) {
        Uere sat02UereA=new Uere(Servers.INC1NSOP4,IrimsMode1Stn.BLR, faker.number().randomDouble(4,6,7), IrimsChain.A, Satellite.SAT03);
        Uere sat03UereA=new Uere(Servers.INC1NSOP4,IrimsMode1Stn.BLR, faker.number().randomDouble(4,6,7),IrimsChain.A,Satellite.SAT03);
        Uere sat02UereB=new Uere(Servers.INC1NSOP4,IrimsMode1Stn.BLR, faker.number().randomDouble(6,6,7),IrimsChain.B,Satellite.SAT03);
        Uere sat03UereB=new Uere(Servers.INC1NSOP4,IrimsMode1Stn.LCK, faker.number().randomDouble(6,20,30),IrimsChain.B,Satellite.SAT03);
        Uere sat10UereB=new Uere(Servers.INC1NSOP4,IrimsMode1Stn.LCK, faker.number().randomDouble(6,20,30),IrimsChain.A,Satellite.SAT03);
        Set<Measurement> uereMeasurements=new HashSet<>();
//        uereMeasurements.add(sat02UereA);
//        uereMeasurements.add(sat03UereA);
//        uereMeasurements.add(sat02UereB);
//        uereMeasurements.add(sat03UereB);
//        uereMeasurements.add(sat10UereB);
        return uereMeasurements;
    }

    private static List<NavigationArchival> getArchivalBaseClasses(Faker faker) {
        NSOP2 NSOP2=new NSOP2(ArchivalName.NSOP2, Status.OK, faker.number().numberBetween(10,18)+ STORAGE_UNIT);
        NSOP4 NSOP4=new NSOP4(ArchivalName.NSOP4, Status.NOT_OK, faker.number().numberBetween(10,18)+STORAGE_UNIT);
        NSDAQ1 NSDAQ1 =new NSDAQ1(ArchivalName.NSDAQ1, Status.NOT_OK, faker.number().numberBetween(2,10)+"G");
        NSDAQ2 NSDAQ2=new NSDAQ2(ArchivalName.NSDAQ2, Status.OK, "10G");

        List<NavigationArchival> archivalList=new ArrayList<>();
        archivalList.add(NSOP2);
        archivalList.add(NSOP4);
        archivalList.add(NSDAQ1);
        archivalList.add(NSDAQ2);
        return archivalList;
    }

    private static SectionD getSectionD() {
        SchemacsHealth monitStatus=new SchemacsHealth(Names.MonitStatus, Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc1Cs5=new SchemacsHealth(Names.Inc1Cs5, Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc1Cs6=new SchemacsHealth(Names.Inc1Cs6, Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc1Cs7=new SchemacsHealth(Names.Inc1Cs7, Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc1Cs8=new SchemacsHealth(Names.Inc1Cs8, Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc2Cs5=new SchemacsHealth(Names.Inc2Cs5, Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc2Cs6=new SchemacsHealth(Names.Inc2Cs6, Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc2Cs7=new SchemacsHealth(Names.Inc2Cs7, Status.OK, "issues is from schemacsHealth");
        SchemacsHealth inc2Cs8=new SchemacsHealth(Names.Inc2Cs8, Status.OK, "issues is from schemacsHealth");

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
        GnssOffset gnssItsA=new GnssOffset(Names.ItsAGnss, 10.00, "itsA issues");
        GnssOffset gnssItsB=new GnssOffset(Names.ItsBGnss, 10.00, "itsB issues");
        GnssOffset gnssItsC=new GnssOffset(Names.ItsCGnss, 10.00, "itsC issues");
        GnssOffset vremyaA=new GnssOffset(Names.VremyaA, 10.00, "vremyaA issues");
        GnssOffset vremyaB=new GnssOffset(Names.VremyaB, 10.00, "vremyaB issues");
        GnssOffset itsInc2=new GnssOffset(Names.ItsInc2, 10.00, "itsInc2 issues");
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
        TwstftOffset itsA=new TwstftOffset(Names.TwstftOffsetItsA, 10.00, "itsA issues");
        TwstftOffset itsB=new TwstftOffset(Names.TwstftOffsetItsB, 10.00, "itsB issues");
        TwstftOffset itsC=new TwstftOffset(Names.TwstftOffsetItsC, 10.00, "itsC issues");
        Set<TwstftOffset> twstftOffsets=new HashSet<>();
        twstftOffsets.add(itsA);
        twstftOffsets.add(itsB);
        twstftOffsets.add(itsC);
        return twstftOffsets;
    }

     public static Set<ParallelChain> getParallelChains() {
        ParallelChain inc1Server1=new ParallelChain(Names.Inc1Server1, Status.OK, "Issues in parallelChain" );
        ParallelChain inc1Server2=new ParallelChain(Names.Inc1Server2, Status.OK, "Issues in parallelChain");
        ParallelChain inc2Server1=new ParallelChain(Names.Inc2Server1, Status.OK, "Issues in parallelChain");
        ParallelChain inc2Server2=new ParallelChain(Names.Inc2Server2, Status.OK, "Issues in parallelChain");

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
       NsopStorageStatus shiftOps = new NsopStorageStatus(StorageNames.ShiftOPs, Status.OK );
        NsopStorageStatus nsop1 = new NsopStorageStatus(StorageNames.NSOP1, Status.OK );
        NsopStorageStatus nsop2 = new NsopStorageStatus(StorageNames.NSOP2, Status.OK );
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


