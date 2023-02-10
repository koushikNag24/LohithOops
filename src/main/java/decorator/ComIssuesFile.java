package decorator;

import model.sections.base.BaseIssues;
import org.apache.log4j.Logger;

public class ComIssuesFile extends BaseIssues implements BaseEntity {
    final static Logger logger = Logger.getLogger(ComIssuesFile.class);
    public ComIssuesFile(String issues) {
        super(issues);
    }

    @Override
    public void save() {

        logger.info("......saving into something file....");
    }
}
