package model.sections.sectionb;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@ToString
@Getter
public class StandardFileStatus {
    private final  List<String> availableDocuments;

    public StandardFileStatus(List<String> availableDocuments) {
        this.availableDocuments = availableDocuments;
    }
}
