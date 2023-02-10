package model.archival.good;

import model.archival.good.ArchivalBaseClass;

public class NSOP4 extends ArchivalBaseClass {
    public NSOP4(String status, String size) {
        super(status, size);
    }
    @Override
    public String toString() {
        return "NSOP4{ " + super.toString()+"}";
    }
}
