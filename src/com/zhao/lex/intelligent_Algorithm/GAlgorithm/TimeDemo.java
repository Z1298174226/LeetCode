package com.zhao.lex.intelligent_Algorithm.GAlgorithm;

/**
 * Created by qtfs on 2018/9/17.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class TimeDemo {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("hh:mm");//如2016-08-10 20:40
        String fromDate = simpleFormat.format("12:00");
        String toDate = simpleFormat.format("12:50");
        long from = simpleFormat.parse(fromDate).getTime();
        long to = simpleFormat.parse(toDate).getTime();
        int minutes = (int) ((to - from)/(1000 * 60));
    }
}
