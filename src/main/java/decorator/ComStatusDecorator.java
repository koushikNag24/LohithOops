package decorator;

public abstract class ComStatusDecorator implements BaseEntity{
    protected BaseEntity baseEntity;

    public ComStatusDecorator(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }

    @Override
    public void save() {
        baseEntity.save();
    }
}
