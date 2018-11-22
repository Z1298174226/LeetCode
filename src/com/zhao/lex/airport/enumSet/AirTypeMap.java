package com.zhao.lex.airport.enumSet;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qtfs on 2018/9/18.
 */
public class AirTypeMap {
    public static Map<String, AirplaneType> airTypeMap = new HashMap<String, AirplaneType>();
    static {
        airTypeMap.put("332", AirplaneType.W);
        airTypeMap.put("333", AirplaneType.W);
        airTypeMap.put("33E", AirplaneType.W);
        airTypeMap.put("33L", AirplaneType.W);
        airTypeMap.put("773", AirplaneType.W);
        airTypeMap.put("33H", AirplaneType.W);
        airTypeMap.put("319", AirplaneType.N);
        airTypeMap.put("320", AirplaneType.N);
        airTypeMap.put("321", AirplaneType.N);
        airTypeMap.put("323", AirplaneType.N);
        airTypeMap.put("325", AirplaneType.N);
        airTypeMap.put("738", AirplaneType.N);
        airTypeMap.put("73A", AirplaneType.N);
        airTypeMap.put("73E", AirplaneType.N);
        airTypeMap.put("73H", AirplaneType.N);
        airTypeMap.put("73L", AirplaneType.N);
    }

}
