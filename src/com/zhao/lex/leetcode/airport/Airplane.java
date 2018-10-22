package com.zhao.lex.leetcode.airport;

import com.zhao.lex.leetcode.airport.enumSet.AirTypeMap;
import com.zhao.lex.leetcode.airport.enumSet.AirplaneType;
import com.zhao.lex.leetcode.airport.enumSet.ArriveType;
import com.zhao.lex.leetcode.airport.enumSet.LeaveType;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by qtfs on 2018/9/18.
 */
public class Airplane {

    public Map<Integer, String> indexMap = new HashMap<Integer, String>();
    public Map<Integer, String> arriveTime = new HashMap<Integer, String>();
    public Map<Integer, ArriveType> arriveType = new HashMap<Integer, ArriveType>();
    public Map<Integer, String> leaveTime = new HashMap<Integer, String>();
    public Map<Integer, LeaveType> leaveType = new HashMap<Integer, LeaveType>();
    public Map<Integer, AirplaneType> airplaneType = new HashMap<Integer, AirplaneType>();
    public Map<String, Integer> arriveFlight = new HashMap<String, Integer>();
    public Map<String, Integer> leaveFlight = new HashMap<String, Integer>();
    public Map<String, ArriveType> arriveFlightType = new HashMap<String, ArriveType>();
    public Map<String, LeaveType> leaveFlightType = new HashMap<String, LeaveType>();

    public Map<String, List<String>> arriveTimeTable = new HashMap<String, List<String>>();
    public Map<String, List<String>> leaveTimeTable = new HashMap<String, List<String>>();

    public void readAirplane(String filename) {
        try{
            BufferedReader data = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            int index = 0;
            while(true) {
                String contentData = data.readLine();
                if (contentData == null)
                    break;
                String[] content = contentData.split(" ");
                indexMap.put(index, content[0]);
                arriveTime.put(index, content[2]);
                arriveType.put(index, content[4].equals("D") ? ArriveType.D : ArriveType.I);
                leaveTime.put(index, content[7]);
                leaveType.put(index, content[9].equals("D") ? LeaveType.D : LeaveType.I);
                airplaneType.put(index, AirTypeMap.airTypeMap.get(content[5]));
                arriveFlight.put(content[3], index);
                leaveFlight.put(content[8], index);
                arriveFlightType.put(content[3], content[4].equals("D") ? ArriveType.D : ArriveType.I);
                leaveFlightType.put(content[8], content[9].equals("D") ? LeaveType.D : LeaveType.I);

                if(arriveTimeTable.containsKey(content[3]))
                    arriveTimeTable.get(content[3]).add(content[2]);
                else {
                    List<String> arriveTimeList = new ArrayList<String>();
                    arriveTimeList.add(content[2]);
                    arriveTimeTable.put(content[3], arriveTimeList);
                }

                if(leaveTimeTable.containsKey(content[8]))
                    leaveTimeTable.get(content[8]).add(content[7]);
                else {
                    List<String> leaveTimeList = new ArrayList<String>();
                    leaveTimeList.add(content[7]);
                    leaveTimeTable.put(content[8], leaveTimeList);
                }

                index++;
            }
        }catch(FileNotFoundException ex) {
            System.out.println("Can't find this file!");
        }catch(IOException ex) {

        }
    }

    public static void main(String[] args) {
        String filename = "src\\com\\zhao\\lex\\leetcode\\airport\\data\\airplaneData";
        Airplane airplane = new Airplane();
        airplane.readAirplane(filename);
//        System.out.println(airplane.leaveType);
//        System.out.println(airplane.arriveType);
//        System.out.println(airplane.leaveTime);
//        System.out.println(airplane.arriveTime);
     //   System.out.println();
    }

}
