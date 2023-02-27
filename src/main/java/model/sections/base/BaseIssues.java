package model.sections.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseIssues {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "baseIssueId")
    @SequenceGenerator(name = "base_issue_seq",sequenceName = "base_issue_learn",allocationSize = 1)
    @Column(name = "base_issue_id",updatable = false, nullable = false)
    private Long id;
    private  String issues;

    public BaseIssues(String issues) {
        this.issues=issues;
    }
}
