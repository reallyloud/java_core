package ru.mentee.power.conditions;
import net.bytebuddy.jar.asm.commons.SimpleRemapper;

import java.util.HashMap;
import java.util.Map;

public class LogicalTrainer {
    public Map<Integer,Boolean> logicValues(boolean likeProgramming, boolean likeMath, boolean likeReading) {
        Map logicValues = new HashMap<Integer,Boolean>();
        int likes = 0;
        if (likeMath) likes++;
        if (likeProgramming) likes++;
        if (likeReading) likes++;
        logicValues.put(0,likeMath&&likeProgramming);
        logicValues.put(1,likeMath&&likeReading);
        logicValues.put(2,!likeMath&& likeProgramming);
        logicValues.put(3,!likeReading&&likeProgramming);
        logicValues.put(4,likeMath&&likeProgramming&&likeReading);
        logicValues.put(5,!likeMath&&!likeProgramming&&!likeReading);
        logicValues.put(6,likes == 1);
        logicValues.put(7,likeMath || likeProgramming || likeReading);
        return logicValues;
    }
}