package model.sections.sectiond;

import lombok.Getter;
import model.sections.base.BaseIssues;

import java.util.List;
@Getter
public class SectionD extends BaseIssues {
    private final List<SchemacsHealth> schemacsHealths;

    public SectionD(List<SchemacsHealth> schemacsHealths,String issues) {
        super(issues);
        this.schemacsHealths = schemacsHealths;
    }
}
