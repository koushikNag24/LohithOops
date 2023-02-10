package model.sections.sectionb;

import lombok.Getter;
import model.sections.base.BaseIssues;
import model.sections.sectionb.archival.good.ArchivalBaseClass;
import model.sections.sectionb.measurements.BaseMeasurement;

import java.util.List;
@Getter
public class SectionB extends BaseIssues {
    public SectionB(StorageIssues storageStatus, StandardFileStatus standardFileStatus, List<ArchivalBaseClass> archivalList, List<BaseMeasurement> uereMeasurements, List<BaseMeasurement> userPositionMeasurements, String issues) {
        super(issues);
        this.storageStatus = storageStatus;
        this.standardFileStatus = standardFileStatus;
        this.archivalList = archivalList;
        this.uereMeasurements = uereMeasurements;
        this.userPositionMeasurements = userPositionMeasurements;
    }

    private final StorageIssues storageStatus;
    private  final StandardFileStatus standardFileStatus;
    private final List<ArchivalBaseClass> archivalList;
    private final List<BaseMeasurement> uereMeasurements;
    private final List<BaseMeasurement> userPositionMeasurements;
}
