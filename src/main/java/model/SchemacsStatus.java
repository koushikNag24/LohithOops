package model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SchemacsStatus extends  BaseStatus {
    private String name;

    public SchemacsStatus(String issues, String name) {
        super(issues);
        this.name = name;
    }


}
