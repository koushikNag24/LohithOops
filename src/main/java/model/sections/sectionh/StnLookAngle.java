package model.sections.sectionh;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
@ToString
@Getter
public class StnLookAngle {
    private final String location;
    private final LocalDateTime availableTill;

    public StnLookAngle(String location, LocalDateTime availableTill) {
        this.location = location;
        this.availableTill = availableTill;
    }
}
