package model;

import lombok.Getter;
import model.archival.good.*;
import model.uere.okversion.UEREBaseClass;
import model.userposition.UserPosition;

import java.util.List;


@Getter
public class NavICPerformanceDetails {
    private  final long id;
    private final List<BaseStatus> statuses;

    private  final StandardFileStatus standardFileStatus;



    private final String createdAt;
    private final String modifiedAt;
    private final List<ArchivalBaseClass> archivalList;
    private final NSOP2 nsop2;
    private final NSOP4 nsop4;
    private final ArchivalNSDAQ1 archivalNsdaq1;
    private final NSDAQ2 nsdaq2;
    private final UEREBaseClass streamABlr;
    private final UEREBaseClass streamBBlr;
    private final UEREBaseClass streamALck;
    private final UEREBaseClass streamBLck;
    private final UserPosition userPosition;
    public NavICPerformanceDetails(long id, BaseStatus communicationStatus, StandardFileStatus standardFileStatus, BaseStatus storageStatus, List<BaseStatus> statuses, String createdAt, String modifiedAt, List<ArchivalBaseClass> archivalList, NSOP2 nsop2, NSOP4 nsop4, ArchivalNSDAQ1 archivalNsdaq1, NSDAQ2 nsdaq2, UEREBaseClass streamABlr, UEREBaseClass streamBBlr, UEREBaseClass streamALck, UEREBaseClass streamBLck, UserPosition userPosition) {
        this.id = id;
        this.statuses = statuses;
        this.standardFileStatus = standardFileStatus;
//        this.storageStatus = storageStatus;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.archivalList = archivalList;

        this.nsop2 = nsop2;
        this.nsop4 = nsop4;
        this.archivalNsdaq1 = archivalNsdaq1;
        this.nsdaq2 = nsdaq2;
        this.streamABlr = streamABlr;
        this.streamBBlr = streamBBlr;
        this.streamALck = streamALck;
        this.streamBLck = streamBLck;
        this.userPosition = userPosition;
    }
    public String toString() {
        long var10000 = this.getId();
        return "NavICPerformanceDetails(id=" + var10000 + ", communicationStatus=" + "communication-issues :" +", standardFileStatus=" + this.getStandardFileStatus() + ", storageStatus="  +" Storage-Issues : "+ ", createdAt=" + this.getCreatedAt() + ", modifiedAt=" + this.getModifiedAt() + ")";
    }
}
