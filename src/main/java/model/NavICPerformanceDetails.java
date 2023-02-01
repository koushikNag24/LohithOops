package model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
public class NavICPerformanceDetails {
    private  final long id;
    private final  BaseStatus communicationStatus;

    private  final StandardFileStatus standardFileStatus;

    private final BaseStatus storageStatus;

    private final String createdAt;
    private final String modifiedAt;

    public NavICPerformanceDetails(long id, BaseStatus communicationStatus, StandardFileStatus standardFileStatus, BaseStatus storageStatus, String createdAt, String modifiedAt) {
        this.id = id;
        this.communicationStatus = communicationStatus;
        this.standardFileStatus = standardFileStatus;
        this.storageStatus = storageStatus;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public String toString() {
        long var10000 = this.getId();
        return "NavICPerformanceDetails(id=" + var10000 + ", communicationStatus=" + this.getCommunicationStatus()+ "communication-issues :" + this.communicationStatus.getIssues()+", standardFileStatus=" + this.getStandardFileStatus() + ", storageStatus=" + this.getStorageStatus() +" Storage-Issues : "+this.storageStatus.getIssues()+ ", createdAt=" + this.getCreatedAt() + ", modifiedAt=" + this.getModifiedAt() + ")";
    }
}
