package workutils;

import workutils.trigger.*;

import java.time.LocalDateTime;

public class UtilsV2 implements IUtils, IUtilityV2 {
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
        if(currentSecond>2 && currentSecond<7){
            triggerAction(new TwoSecondTrigger());
        } else if(currentSecond==10){
            triggerAction(new TenSecondTrigger());
        }else if(currentSecond>7 && currentSecond<35){
            triggerAction(new SevenSecondTrigger());
        }else if(currentSecond>35){
            triggerAction(new ThirtyFiveSecondTrigger());
        }
    }
    public void triggerAction(ITrigger trigger){
        trigger.triggerAction();
    }
}
