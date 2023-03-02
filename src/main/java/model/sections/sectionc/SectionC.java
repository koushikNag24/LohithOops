package model.sections.sectionc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
@Setter
@Getter

public class SectionC {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sectionCIdSeq")
    @SequenceGenerator(name = "sectionCIdSeq",sequenceName = "sectionCIdSeq",allocationSize = 1)
    @Column(name = "sectionCId",updatable = false, nullable = false)
    private Long id;


    @OneToMany(mappedBy = "sectionC", cascade = CascadeType.ALL)
    private Set<ParallelChain> parallelChains=new HashSet<>();

    @OneToMany(mappedBy = "sectionC", cascade = CascadeType.ALL)
    private Set<TwstftOffset> twstftOffsets=new HashSet<>();

    @OneToMany(mappedBy = "sectionC", cascade = CascadeType.ALL)
    private Set<GnssOffset> gnssOffsets=new HashSet<>();

    public SectionC(Set<ParallelChain> parallelChains, Set<TwstftOffset> twstftOffsets, Set<GnssOffset> gnssOffsets) {
        this.parallelChains = parallelChains;
        this.twstftOffsets = twstftOffsets;
        this.gnssOffsets = gnssOffsets;
    }

    public void addParallelChain(ParallelChain parallelChain){
        this.parallelChains.add(parallelChain);
        parallelChain.setSectionC(this);
    }
    public void addTwstftOffset(TwstftOffset twstftOffset){
        this.twstftOffsets.add(twstftOffset);
        twstftOffset.setSectionC(this);
    }
    public void addGnssOffset(GnssOffset gnssOffset){
        this.gnssOffsets.add(gnssOffset);
        gnssOffset.setSectionC(this);
    }

}
