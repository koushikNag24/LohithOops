package model.sections.sectiona;

import lombok.Getter;

@Getter
public class SectionA {
    private final CommunicationIssues communicationStatus;

    public SectionA(CommunicationIssues communicationStatus) {
        this.communicationStatus = communicationStatus;
    }
}
