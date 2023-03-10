package tutorial.dao.utils.jpahibernate.model;

import org.hibernate.HibernateException;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.Target;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.beans.MethodDescriptor;

public class MySequenceGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return null;
    }

}
