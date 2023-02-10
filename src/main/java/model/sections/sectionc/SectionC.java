package model.sections.sectionc;

import java.util.List;

public class SectionC {
    private final List<ParallelChain> parallelChains;
    private final List<TwstftOffset> twstftOffsets;
    private final List<GnssOffset> gnssOffsets;

    public SectionC(List<ParallelChain> parallelChains, List<TwstftOffset> twstftOffsets, List<GnssOffset> gnssOffsets) {
        this.parallelChains = parallelChains;
        this.twstftOffsets = twstftOffsets;
        this.gnssOffsets = gnssOffsets;
    }
}
