package model.sections.sectiona;


import lombok.Getter;
import lombok.ToString;
import model.sections.base.BaseHealth;
import model.sections.base.BaseIssues;

import java.util.List;

@ToString
@Getter
public class CommunicationIssues extends BaseIssues {

   


 private final List<BaseHealth> baseHealths;



    public CommunicationIssues(String issues, List<BaseHealth> baseHealths) {
        super(issues);
        this.baseHealths = baseHealths;


    }



}
