package tutorial.dao.utils.jpahibernate.model.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class StudentWrapper {
    private final Long id;
    private final String city;
    private final String state;
}
