package com.zhao.lex.airport;


import com.zhao.lex.airport.enumSet.AirplaneType;
import com.zhao.lex.airport.enumSet.ArriveType;
import com.zhao.lex.airport.enumSet.LeaveType;
import com.zhao.lex.airport.enumSet.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by qtfs on 2018/9/17.
 */
public class BoardingGate {

    public Map<Integer, Type> type = new HashMap<Integer, Type>();
    public Map<Integer, String> indexMap = new HashMap<Integer, String>();
    public Map<Integer, List<ArriveType>> arriveType = new HashMap<Integer, List<ArriveType>>();
    public Map<Integer, List<LeaveType>> leaveType = new HashMap<Integer, List<LeaveType>>();
    public Map<Integer, AirplaneType> airplaneType = new HashMap<Integer, AirplaneType>();
    public Map<Integer, Integer> hasPlane = new HashMap<Integer, Integer>();
    public Map<Integer, String> direction = new HashMap<Integer, String>();
    public void readGate(String filename) {
        try {
            BufferedReader data = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            int index = 0;
            while(true) {
                String content = data.readLine();
                if(content == null)
                    break;
                String[] dataContent = content.split(" ");
                indexMap.put(index, dataContent[0]);
                type.put(index, (dataContent[1].equals("T") ? Type.T : Type.S));
                List<ArriveType> arrive = new ArrayList<ArriveType>();
                for(String arrOrlea : dataContent[3].split(",")) {
                    arrive.add(arrOrlea.equals("D") ? ArriveType.D : ArriveType.I);
                }
                arriveType.put(index, arrive);
                List<LeaveType> leave = new ArrayList<LeaveType>();
                for(String arrOrlea : dataContent[4].split(",")) {
                    leave.add(arrOrlea.equals("D") ? LeaveType.D : LeaveType.I);
                }
                leaveType.put(index, leave);
                airplaneType.put(index, dataContent[5].equals("W") ? AirplaneType.W : AirplaneType.N);

                direction.put(index, dataContent[2]);
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't find this file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "src\\com\\zhao\\lex\\leetcode\\airport\\data\\airGate.txt";
        BoardingGate boardingGate = new BoardingGate();
        boardingGate.readGate(filename);
        String ss = "67,55,14,64,4,32,65,22,3,68,6,15,27,63,48,21,0,29,35,20,38,19,23,43,70,26,70,28,9,47,18,33,46,70,8,12,45,50,11,70,41,70,70,30,51,70,70,42,53,34,31,17,16,52,44,36,13,7,5,49,54,10,2,0,70,22,65,61,39,58,25,1,70,3,63,70,59,62,38,27,70,66,70,40,24,70,51,19,70,12,18,13,54,46,70,53,22,11,70,9,70,36,35,49,30,70,15,50,7,37,48,47,70,42,17,70,45,70,43,70,19,12,39,40,70,20,41,70,18,13,8,70,6,70,11,28,38,21,35,48,7,15,23,20,28,42,18,8,6,39,54,19,70,17,0,43,13,70,70,35,47,9,51,70,38,70,68,34,48,45,2,16,42,8,31,6,70,36,65,7,39,19,12,70,70,50,40,41,54,20,3,70,70,5,70,27,0,33,60,70,58,43,23,70,34,70,70,45,10,64,44,66,70,8,22,6,70,55,13,43,40,7,12,0,35,63,49,19,70,33,21,9,68,39,70,67,4,70,17,26,20,70,47,36,61,50,70,31,70,15,37,48,55,38,16,8,30,18,32,6,28,52,24,53,19,44,7,70,14,54,51,40,42,62,12,45,11,41,35,17,29,21,20,0,10,33,32,49,19,70,18,13,31,36,70,9,70,44,70,45,11,28,47";
        String[] s = ss.split(",");
        for(String str : s)
            System.out.println(Integer.valueOf(str) == 70 ? "临时停机口" : boardingGate.indexMap.get(Integer.valueOf(str)));
        //        System.out.println(boardingGate.type);
//        System.out.println(boardingGate.airplaneType);
//        System.out.println(boardingGate.arriveType);
//        System.out.println(boardingGate.leaveType);
    }
}
