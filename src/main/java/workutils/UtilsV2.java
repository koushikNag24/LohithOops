package workutils;

import workutils.trigger.*;

import java.time.LocalDateTime;

public class UtilsV2 implements IUtils, IUtilityV2 {
    ConditionFactory commandConditionFactory = new ConditionFactory();
    @Override
    public int[] sort(int[] arr) {
        System.out.println("--doing some magical sort--");
        return new int[0];
    }

    @Override
    public void shout() {
        System.out.println("--shouting from v2--");
    }
    @Override
    public void v2Method() {

    }


    @Override
    public void v3Method() {
        System.out.println("Current Second : "+LocalDateTime.now().getSecond());
        int currentSecond= LocalDateTime.now().getSecond();
        ITrigger trigger=null;
        if(currentSecond>2 && currentSecond<7){
            trigger = commandConditionFactory.getCommand("twoSecond")
                    .orElseThrow(() -> new IllegalArgumentException("Wrong condition"));
            // highly coupled
        } else if(currentSecond==10){

            trigger = commandConditionFactory.getCommand("tenSecond")
                    .orElseThrow(() -> new IllegalArgumentException("Wrong condition"));

//            triggerAction(trigger);
        }else if(currentSecond>7 && currentSecond<35){

            trigger = commandConditionFactory.getCommand("sevenSecond")
                    .orElseThrow(() -> new IllegalArgumentException("Wrong condition"));
//            triggerAction(trigger);
        }else if(currentSecond>35){

            trigger = commandConditionFactory.getCommand("thirtyFiveSecond")
                    .orElseThrow(() -> new IllegalArgumentException("Wrong condition"));

//            triggerAction(trigger);
        }
        triggerAction(trigger);
    }
    public void triggerAction(ITrigger trigger){
        trigger.triggerAction();
    }
}
