package decorator;

import model.BaseStatus;
import org.apache.log4j.Logger;

public class ComStatus extends BaseStatus implements BaseEntity {
    final static Logger logger = Logger.getLogger(ComStatus.class);
    public ComStatus(String issues) {
        super(issues);
    }

    @Override
    public void save() {

        logger.info("......saving into something database....");
    }
}
