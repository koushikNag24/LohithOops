package model;

import lombok.Getter;

import java.util.List;


@Getter
public class NavICPerformanceDetails {
    private  final long id;
    private final List<BaseStatus> statuses;

    private  final StandardFileStatus standardFileStatus;



    private final String createdAt;
    private final String modifiedAt;

    public NavICPerformanceDetails(long id, BaseStatus communicationStatus, StandardFileStatus standardFileStatus, BaseStatus storageStatus, List<BaseStatus> statuses, String createdAt, String modifiedAt) {
        this.id = id;
        this.statuses = statuses;
        this.standardFileStatus = standardFileStatus;
//        this.storageStatus = storageStatus;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public String toString() {
        long var10000 = this.getId();
        return "NavICPerformanceDetails(id=" + var10000 + ", communicationStatus=" + "communication-issues :" +", standardFileStatus=" + this.getStandardFileStatus() + ", storageStatus="  +" Storage-Issues : "+ ", createdAt=" + this.getCreatedAt() + ", modifiedAt=" + this.getModifiedAt() + ")";
    }
}
