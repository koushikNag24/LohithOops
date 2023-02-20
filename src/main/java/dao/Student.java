package dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int id;
    private String address;
    private String email;
    private int departFKId;
}
