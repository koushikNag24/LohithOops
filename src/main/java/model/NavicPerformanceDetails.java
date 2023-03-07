package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.sectiona.SectionA;
import model.sections.sectionb.SectionB;
import model.sections.sectionc.SectionC;
import model.sections.sectiond.SectionD;
//import model.sections.sectione.SectionE;
//import model.sections.sectionf.SectionF;
import model.sections.sectione.SectionE;
import model.sections.sectionf.SectionF;
import model.sections.sectiong.SectionG;
import model.sections.sectionh.SectionH;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity


public class NavicPerformanceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "navicPerformenceDetailsIdSeq")
    @SequenceGenerator(name = "navicPerformenceDetailsId",sequenceName = "navicPerformenceDetailsIdSeq",allocationSize = 1)
    private  Long id;
    
    @OneToOne
    private  SectionA sectionA;

    @OneToOne
    private SectionB sectionB;
    
    @OneToOne
    private SectionC sectionC;
    
    @OneToOne
    private SectionD sectionD;
    
    @OneToOne
    private SectionE sectionE;
    
    @OneToOne
    private SectionF sectionF;
    
    @OneToOne
    private SectionG sectionG;
    
    @OneToOne
    private SectionH sectionH;
    
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public NavicPerformanceDetails(SectionA sectionA, SectionB sectionB, SectionC sectionC, SectionD sectionD, SectionE sectionE, SectionF sectionF, SectionG sectionG, SectionH sectionH, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.sectionA = sectionA;
        this.sectionB = sectionB;
        this.sectionC = sectionC;
        this.sectionD = sectionD;
        this.sectionE = sectionE;
        this.sectionF = sectionF;
        this.sectionG = sectionG;
        this.sectionH = sectionH;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void addSectionA(SectionA sectionA){
        this.setSectionA(sectionA);
        sectionA.setNavicPerformanceDetails(this);
    }
    public void addSectionB(SectionB sectionB){
        this.setSectionB(sectionB);
        sectionB.setNavicPerformanceDetails(this);
    }
    public void addSectionC(SectionC sectionC){
        this.setSectionC(sectionC);
        sectionC.setNavicPerformanceDetails(this);
    }
    public void addSectionD(SectionD sectionD){
        this.setSectionD(sectionD);
        sectionD.setNavicPerformanceDetails(this);
    }
    public void addSectionE(SectionE sectionE){
        this.setSectionE(sectionE);
        sectionE.setNavicPerformanceDetails(this);
    }
    public void addSectionF(SectionF sectionF){
        this.setSectionF(sectionF);
        sectionF.setNavicPerformanceDetails(this);
    }
    public void addSectionG(SectionG sectionG){
        this.setSectionG(sectionG);
        sectionG.setNavicPerformanceDetails(this);
    }
    public void addSectionH(SectionH sectionH){
        this.setSectionH(sectionH);
        sectionH.setNavicPerformanceDetails(this);
    }
}

