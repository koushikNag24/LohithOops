package decorator;

import model.BaseStatus;
import org.apache.log4j.Logger;

public class ComStatusFile extends BaseStatus implements BaseEntity {
    final static Logger logger = Logger.getLogger(ComStatusFile.class);
    public ComStatusFile(String issues) {
        super(issues);
    }

    @Override
    public void save() {

        logger.info("......saving into something file....");
    }
}
