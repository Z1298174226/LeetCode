package com.zhao.lex.airport.enumSet;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qtfs on 2018/9/19.
 */
public class DirectionMap {
    public static Map<String, Integer> directionMap = new HashMap<String, Integer>();
    static {
        directionMap.put("TNorth", 0);
        directionMap.put("TCenter", 1);
        directionMap.put("TSouth", 2);
        directionMap.put("SNorth", 3);
        directionMap.put("SCenter", 4);
        directionMap.put("SSouth", 5);
        directionMap.put("SEast", 6);
    }
}
