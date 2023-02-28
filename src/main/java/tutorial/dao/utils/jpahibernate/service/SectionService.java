package tutorial.dao.utils.jpahibernate.service;

import com.github.javafaker.Faker;
import model.NavICPerformanceDetails;
import model.Status;
import model.sections.base.BaseHealth;
import model.sections.sectiona.CommunicationIssues;
import model.sections.sectiona.SectionA;
import model.sections.sectionb.NsopStorageStatus;
import model.sections.sectionb.SectionB;
import model.sections.sectionb.StandardFileStatus;
import model.sections.sectionb.StorageIssues;
import model.sections.sectionb.archival.good.*;
import model.sections.sectionb.measurements.BaseMeasurement;
import model.sections.sectionb.measurements.Uere;
import model.sections.sectionb.measurements.UserPosition;
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
import tutorial.dao.utils.jpahibernate.exception.ArgumentNullException;
import tutorial.dao.utils.jpahibernate.exception.NoMeasurementException;
import tutorial.dao.utils.jpahibernate.model.enumer.IrimsChain;
import tutorial.dao.utils.jpahibernate.model.enumer.IrimsMode1;
import tutorial.dao.utils.jpahibernate.model.enumer.NavIC_Satellite;
import tutorial.dao.utils.jpahibernate.model.enumer.NavigationServer;
import workutils.IUtils;
import workutils.UtilsV3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SectionService {
    public static final String STORAGE_UNIT = "G";
    public static final String Document_1 = "Doct1";
    public static final String document_2 = "doc2";
    public  SectionH getSectionH() {
        StnLookAngle stnLookAngleBPL= new StnLookAngle("BPL", LocalDateTime.now().plusHours(1));
        StnLookAngle stnLookAngleJDH= new StnLookAngle("JDH", LocalDateTime.now().plusHours(2));
        StnLookAngle stnLookAngleHSN= new StnLookAngle("HSN", LocalDateTime.now().minusMinutes(30));
        StnLookAngle stnLookAnglePBR= new StnLookAngle("PBR", LocalDateTime.now().plusHours(4));
        SectionH sectionH=new SectionH("Issues from Section H", List.of(stnLookAngleBPL,stnLookAngleHSN,stnLookAnglePBR,stnLookAngleJDH));
        return sectionH;
    }
    public   SectionG getSectionG() {
        SyslogStatus syslogStatus = new SyslogStatus("syslogStatus", Status.OK);
        SectionG sectionG = new SectionG(syslogStatus, "Issues in Section G");
        return sectionG;
    }
    public SectionB getSectionB(Faker faker, StandardFileStatus standardFileStatus, StorageIssues storageStatus) {
        List<ArchivalBaseClass> archivalList =getArchivalBaseClasses(faker);

        List<BaseMeasurement> uereMeasurements = getBaseMeasurements(faker);

        List<BaseMeasurement> userPositionMeasurements = getMeasurements(faker);


        SectionB sectionB=new SectionB(storageStatus, standardFileStatus,archivalList,uereMeasurements,userPositionMeasurements,"issue in sectoin B");
        return sectionB;
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
    public List<BaseMeasurement> getMeasurements(Faker faker) {
        UserPosition userPosBlrServer1 = new UserPosition(NavigationServer.NSOP1, IrimsMode1.BLR, faker.number().randomDouble(4,6,7), IrimsChain.CHAIN_B,"a");
        UserPosition userPosBlrServer4 = new UserPosition(NavigationServer.NSOP1, IrimsMode1.BLR, faker.number().randomDouble(4,6,7), IrimsChain.CHAIN_B,"s");
        UserPosition userPosLckServer1 = new UserPosition(NavigationServer.NSOP2, IrimsMode1.LCK, faker.number().randomDouble(4,6,7), IrimsChain.CHAIN_B,"s");
        UserPosition userPosLckServer2 = new UserPosition(NavigationServer.NSOP2, IrimsMode1.LCK, faker.number().randomDouble(4,6,7), IrimsChain.CHAIN_B,"e");

        List<BaseMeasurement> userPositionMeasurements=new ArrayList<>();
        userPositionMeasurements.add(userPosBlrServer1);
        userPositionMeasurements.add(userPosBlrServer4);
        userPositionMeasurements.add(userPosLckServer1);
        userPositionMeasurements.add(userPosLckServer2);
        return userPositionMeasurements;
    }

    private static List<BaseMeasurement> getBaseMeasurements(Faker faker) {
        Uere sat02UereA=new Uere(NavigationServer.NSOP2,IrimsMode1.BLR, faker.number().randomDouble(4,6,7), IrimsChain.CHAIN_A, NavIC_Satellite.SAT02);
        Uere sat03UereA=new Uere(NavigationServer.NSOP2,IrimsMode1.BLR, faker.number().randomDouble(4,6,7),IrimsChain.CHAIN_A,NavIC_Satellite.SAT03);
        Uere sat02UereB=new Uere(NavigationServer.NSOP1,IrimsMode1.BLR, faker.number().randomDouble(6,6,7),IrimsChain.CHAIN_B,NavIC_Satellite.SAT04);
        Uere sat03UereB=new Uere(NavigationServer.NSOP1,IrimsMode1.BLR, faker.number().randomDouble(6,20,30),IrimsChain.CHAIN_A,NavIC_Satellite.SAT05);
        Uere sat10UereB=new Uere(NavigationServer.NSOP1,IrimsMode1.BLR, faker.number().randomDouble(6,20,30),IrimsChain.CHAIN_A,NavIC_Satellite.SAT10);
        List<BaseMeasurement> uereMeasurements=new ArrayList<>();
        uereMeasurements.add(sat02UereA);
        uereMeasurements.add(sat03UereA);
        uereMeasurements.add(sat02UereB);
        uereMeasurements.add(sat03UereB);
        uereMeasurements.add(sat10UereB);
        return uereMeasurements;
    }


    public SectionD getSectionD() {
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

   public SectionC getSectionC() {
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
    private static void sectionTask() {

        Faker  faker=new Faker();
        // data came from frontend//
        SectionService sectionService=new SectionService();

        StandardFileStatus standardFileStatus = sectionService.getStandardFileStatus();
        String issues=faker.shakespeare().romeoAndJulietQuote();
        StorageIssues storageStatus = sectionService.getStorageIssues(issues);


        LocalDateTime createdAt=LocalDateTime.now();
        LocalDateTime modifiedAt=LocalDateTime.now().plusHours(2);
        IUtils utils=new UtilsV3();

        CommunicationIssues communicationStatus = sectionService.getCommunicationIssues();

        SectionA sectionA=new SectionA(communicationStatus);

        SectionB sectionB = sectionService.getSectionB(faker, standardFileStatus, storageStatus);

        SectionC sectionC = sectionService.getSectionC();

        SectionD sectionD = sectionService.getSectionD();

        SectionE sectionE=new SectionE("Irms Issues", List.of("BLR", "MGH"));

        SectionF sectionF = new SectionF("Issues in sectionF", List.of("BLR", "DDN"));

//        List<BaseStatus> baseStatusList=List.of(communicationStatus,storageStatus,schemacsStatus);

        SectionG sectionG = sectionService.getSectionG();

        SectionH sectionH = sectionService.getSectionH();


        NavICPerformanceDetails performanceDetails=new NavICPerformanceDetails(1000,sectionA,sectionB, sectionC, sectionD, sectionE, sectionF, sectionG, sectionH, createdAt,modifiedAt);


        List<ArchivalBaseClass> archivals=performanceDetails.getSectionB().getArchivalList();


        Uere sat10Uere = null;


        try {
            showSectionB(performanceDetails, sat10Uere);
        } catch (ArgumentNullException e) {
            throw new RuntimeException(e);
        } catch (NoMeasurementException e) {
            throw new RuntimeException(e);
        }
    }
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private static void showSectionB(NavICPerformanceDetails performanceDetails, Uere sat10Uere) throws ArgumentNullException, NoMeasurementException {
        SectionB retrievedSectionB= performanceDetails.getSectionB();
        GuardAgainstNull(retrievedSectionB,"Section B");
        List<BaseMeasurement> measurements=retrievedSectionB.getUereMeasurements();
        GuardCollectionAgainstNullEmpty(measurements);
        BaseMeasurement baseMeasurement=measurements.get(measurements.size()-1);
        if(baseMeasurement instanceof  Uere){
            sat10Uere =((Uere)baseMeasurement);
        }
        GuardAgainstNull(sat10Uere,"Sat10 Uere");

//            logger.info(sat10Uere + " - "+ sat10Uere.getSatellite());

    }
    public static  void GuardAgainstNull(Object argument,String argumentName) throws ArgumentNullException {
        if (argument == null)
        {
            throw new ArgumentNullException(argumentName,"1");
        }
    }

    public static <T> void GuardCollectionAgainstNullEmpty(T argument) throws NoMeasurementException, ArgumentNullException {
        GuardAgainstNull(argument,argument.toString());
        if((argument instanceof Collection)){
            if(((Collection<Object>)argument).isEmpty()){
                throw new NoMeasurementException("measurements is blank/null","2");
            }
        }

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


    public CommunicationIssues getCommunicationIssues() {
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

    public StorageIssues getStorageIssues(String issues) {
        NsopStorageStatus shiftOps = new NsopStorageStatus("172.19.2.145(ShiftOps)", Status.OK );
        NsopStorageStatus nsop1 = new NsopStorageStatus("172.19.4.15(NSOP-1)", Status.OK );
        NsopStorageStatus nsop2 = new NsopStorageStatus("172.19.7.15(NSOP-2", Status.OK );
        List<NsopStorageStatus> storages = List.of(shiftOps, nsop1, nsop2);
        StorageIssues storageIssues = new StorageIssues(storages, "Everything is fine");
        return storageIssues;

    }

   public StandardFileStatus getStandardFileStatus() {
        List<String> availableFiles=List.of(Document_1, document_2);
        StandardFileStatus standardFileStatus=new StandardFileStatus(availableFiles);
        return standardFileStatus;
    }

}
