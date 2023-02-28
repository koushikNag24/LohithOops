package model.sections.sectiona;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.Status;
import model.sections.base.BaseHealth;


@Entity
@ToString
@Getter
@NoArgsConstructor
@Setter
public class LinkStatus extends BaseHealth {
    @ManyToOne
    @JoinColumn(name = "communicationId")
    private CommunicationIssue communicationIssue;
    public LinkStatus(String name, Status status, String issue) {
        super(name, status, issue);
    }

    public void addCommunicationIssue(CommunicationIssue communicationIssue){
        this.setCommunicationIssue(communicationIssue);
        communicationIssue.addLinkStatus(this);
    }


}
