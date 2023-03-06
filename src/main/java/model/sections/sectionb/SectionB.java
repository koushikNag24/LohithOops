package model.sections.sectionb;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.NavicPerformanceDetails;
import model.sections.base.BaseIssues;
import model.sections.sectionb.archival.good.NavigationArchival;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
public class SectionB extends BaseIssues {
    public SectionB(StorageIssues storageStatus, StandardFileStatus standardFileStatus, Set<NavigationArchival> navigationArchivals, Set<Measurement> uereMeasurements, Set<Measurement> userPositionMeasurements, String issues) {
        super(issues);
        this.storageStatus = storageStatus;
        this.standardFileStatus = standardFileStatus;
        this.archivalList = navigationArchivals;
        this.uereMeasurements = uereMeasurements;
        this.userPositionMeasurements = userPositionMeasurements;
    }

    @OneToOne(mappedBy = "sectionB",cascade = CascadeType.ALL)
    private StorageIssues storageStatus;

    @OneToOne(mappedBy = "sectionB", cascade = CascadeType.ALL)
    private StandardFileStatus standardFileStatus;

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private Set<NavigationArchival> archivalList=new HashSet<>();

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private Set<Measurement> uereMeasurements=new HashSet<>();

    @OneToMany(mappedBy="sectionB", cascade = CascadeType.ALL)
    private Set<Measurement> userPositionMeasurements=new HashSet<>();

    @OneToOne(mappedBy = "sectionB",cascade = CascadeType.ALL)
    private NavicPerformanceDetails navicPerformanceDetails;


    public void addStorageStatus(StorageIssues storageStatus){
        this.setStorageStatus(storageStatus);
        storageStatus.setSectionB(this);
    }


    public void addNavigationArchival(NavigationArchival navigationArchival) {
        this.archivalList.add(navigationArchival);
        navigationArchival.setSectionB(this);
    }

    public void addMeasurements(Measurement measurement){
        this.uereMeasurements.add(measurement);
        measurement.setSectionB(this);
    }

    public void addStandardFilesStatus(StandardFileStatus standardFileStatus){
        this.setStandardFileStatus(standardFileStatus);
        standardFileStatus.setSectionB(this);
    }







}
