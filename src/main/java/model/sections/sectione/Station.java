//package model.sections.sectione;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import model.enumer.StationName;
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@ToString
//
//
//public class Station {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EmbeddableStnNamesIdSeq")
//    @SequenceGenerator(name = "EmbeddableStnNamesIdSeq",sequenceName = "EmbeddableStnNamesIdlearn",allocationSize = 1)
//    @Column(name = "EmbeddableStnNameId",updatable = false, nullable = false)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name="sectionEStationName")
//    private SectionE sectionE;
//
//
//
//    private StationName name;
//
//    public Station(StationName name) {
//        this.name = name;
//    }
//
//    public void addSectionE(SectionE sectionE){
//        this.setSectionE(sectionE);
////        sectionE.addEmbeddableStationName(this);
//    }
//
//}
