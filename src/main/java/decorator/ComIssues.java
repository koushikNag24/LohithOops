package decorator;

import model.sections.base.BaseIssues;
import org.apache.log4j.Logger;

public class ComIssues extends BaseIssues implements BaseEntity {
    final static Logger logger = Logger.getLogger(ComIssues.class);
    public ComIssues(String issues) {
        super(issues);
    }

    @Override
    public void save() {

        logger.info("......saving into something database....");
    }
}
