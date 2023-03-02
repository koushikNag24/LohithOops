package model.sections.sectione;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.ToString;
import model.sections.base.BaseMaintenance;


@ToString
@NoArgsConstructor
@Getter
@Entity
public class SectionE extends BaseMaintenance {
/**
 *  The association relating to Section E is completely taken care by its hierarchical parents all the way up !
 *  Hence, we need not give any association mapping for it !!!
 *  Here Station attribute pertaining to Section E has been taken care by Base Maintenance
 *  Here Issue attribute pertaining to Section E has been taken care by Base Issue via Base Maintenance.
 *
 *  So we don't need to provide any association in Section E
 */
}
