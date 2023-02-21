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
    private String city;
    private String state;
    private String email;
    private int pocketMoney;


    public Student(String name, String city, String state, String email, int pocketMoney) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.email = email;
        this.pocketMoney = pocketMoney;
    }
}
