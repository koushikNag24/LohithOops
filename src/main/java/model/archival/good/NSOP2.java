package model.archival.good;

import model.archival.good.ArchivalBaseClass;

public class NSOP2 extends ArchivalBaseClass {


    public NSOP2(String status, String size) {
        super(status, size);
    }

    @Override
    public String toString() {
        return "NSOP2{ " + super.toString()+"}";
    }
}
