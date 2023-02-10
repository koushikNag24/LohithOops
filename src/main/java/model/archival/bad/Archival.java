package model.archival.bad;

public class Archival {

    private final String NSOP2status;
    private final String NSOP2Size;
    private final String NSOP4status;
    private final String NSOP4Size;
    private final String NSDAQ1status;
    private final String NSDAQ1Size;
    private final String NSDAQ2status;
    private final String NSDAQ2Size;


    public Archival(String nsop2status, String nsop2Size, String nsop4status, String nsop4Size, String nsdaq1status, String nsdaq1Size, String nsdaq2status, String nsdaq2Size) {
        this.NSOP2status = nsop2status;
        this.NSOP2Size = nsop2Size;
        this.NSOP4status = nsop4status;
        this.NSOP4Size = nsop4Size;
        this.NSDAQ1status = nsdaq1status;
        this.NSDAQ1Size = nsdaq1Size;
        this.NSDAQ2status = nsdaq2status;
        this.NSDAQ2Size = nsdaq2Size;

    }
}
