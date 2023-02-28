package model.sections.sectionb;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.sections.base.BaseIssues;
import model.sections.sectionb.archival.good.ArchivalBaseClass;
import model.sections.sectionb.measurements.BaseMeasurement;
import model.sections.sectiong.SyslogStatus;

import java.util.List;
@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
public class SectionB extends BaseIssues {
    public SectionB(StorageIssues storageStatus, StandardFileStatus standardFileStatus, List<ArchivalBaseClass> archivalList, List<BaseMeasurement> uereMeasurements, List<BaseMeasurement> userPositionMeasurements, String issues) {
        super(issues);
        this.storageStatus = storageStatus;
        this.standardFileStatus = standardFileStatus;
        this.archivalList = archivalList;
        this.uereMeasurements = uereMeasurements;
        this.userPositionMeasurements = userPositionMeasurements;
    }

    @OneToOne(mappedBy = "sectionB",cascade = CascadeType.ALL)
    private StorageIssues storageStatus;


    private StandardFileStatus standardFileStatus;
    private List<ArchivalBaseClass> archivalList;
    private List<BaseMeasurement> uereMeasurements;
    private List<BaseMeasurement> userPositionMeasurements;


    public void addStorageStatus(StorageIssues storageStatus){
        this.setStorageStatus(storageStatus);
        storageStatus.setSectionB(this);
    }



}
