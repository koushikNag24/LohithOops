package decorator;

import org.apache.log4j.Logger;

public class OwnerCheckDecorator extends  ComStatusDecorator{
    final static Logger logger = Logger.getLogger(OwnerCheckDecorator.class);
    public OwnerCheckDecorator(BaseEntity baseEntity) {
        super(baseEntity);
    }

    @Override
    public void save() {
        checkFileSize();
        baseEntity.save();
    }
    public void checkFileSize(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("....owner checking..");
    }
}
