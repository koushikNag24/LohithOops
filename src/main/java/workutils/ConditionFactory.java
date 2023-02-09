package workutils;

import workutils.trigger.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConditionFactory {
    private Map<String, ITrigger> conditions = new HashMap<>();

    public ConditionFactory() {
        conditions.put("twoSecond", new TwoSecondTrigger());
        conditions.put("sevenSecond", new SevenSecondTrigger());
        conditions.put("tenSecond", new TenSecondTrigger());
        conditions.put("thirtyFiveSecond", new ThirtyFiveSecondTrigger());

//        conditions.put("conditionElse", new ElseCommand("elseParameter"));
    }
    public Optional<ITrigger> getCommand(String condition) {
        return Optional.ofNullable(conditions.get(condition));
    }
}
