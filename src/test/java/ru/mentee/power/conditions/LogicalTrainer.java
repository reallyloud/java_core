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
        logicValues.put(0,likeMath&&likeProgramming); //Любит программирование и математику;
        logicValues.put(1,likeMath&&likeReading); //Любит математику и читать;
        logicValues.put(2,!likeMath&& likeProgramming); //Любит программирование, но не любит математику;
        logicValues.put(3,!likeReading&&likeProgramming); //Любит программирование, но не любит читать;
        logicValues.put(4,likeMath&&likeProgramming&&likeReading); //Любит всё вместе;
        logicValues.put(5,!likeMath&&!likeProgramming&&!likeReading); //Не любит ничего;
        logicValues.put(6,likes == 1); //Любит что-то одно;
        logicValues.put(7,likeMath || likeProgramming || likeReading); //Любит хоть что-то;
        return logicValues;
    }
}