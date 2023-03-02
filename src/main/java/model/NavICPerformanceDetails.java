package model;

import lombok.Getter;
import model.sections.sectiona.SectionA;
import model.sections.sectionb.SectionB;
import model.sections.sectionc.SectionC;
import model.sections.sectiond.SectionD;
//import model.sections.sectione.SectionE;
//import model.sections.sectionf.SectionF;
import model.sections.sectiong.SectionG;
import model.sections.sectionh.SectionH;

import java.time.LocalDateTime;


@Getter
public class NavICPerformanceDetails {
    private  final long id;
    private final SectionA sectionA;
    private final SectionB sectionB;
    private final SectionC sectionC;

    private final SectionD sectionD;
//    private final SectionE sectionE;
//    private final SectionF sectionF;
    private final SectionG sectionG;
    private final SectionH sectionH;



    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;


    public NavICPerformanceDetails(long id, SectionA sectionA, SectionB sectionB, SectionC sectionC, SectionD sectionD, SectionG sectionG, SectionH sectionH, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.sectionA = sectionA;
        this.sectionB = sectionB;
        this.sectionC = sectionC;
        this.sectionD = sectionD;
//        this.sectionE = sectionE;
//        this.sectionF = sectionF;
        this.sectionG = sectionG;
        this.sectionH = sectionH;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

