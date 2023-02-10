package model.userposition;

import lombok.ToString;

@ToString

public class UserPosition {
    private final String[][] userPos;

    public UserPosition(String[][] userPos) {
        this.userPos = userPos;
    }
}
