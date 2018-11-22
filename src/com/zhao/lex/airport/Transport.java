package com.zhao.lex.airport;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qtfs on 2018/9/18.
 */
public class Transport {

    public Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
    public Map<Integer, String> arrive = new HashMap<Integer, String>();
    public Map<Integer, String> leave = new HashMap<Integer, String>();


    public void readAirplane(String filename) {
        try{
            BufferedReader data = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            int index = 0;
            while(true) {
                String contentData = data.readLine();
                if (contentData == null)
                    break;
                String[] content = contentData.split(" ");
                numbers.put(index, Integer.valueOf(content[1]));
                arrive.put(index, content[2]);
                leave.put(index, content[4]);
                index++;
            }
        }catch(FileNotFoundException ex) {
            System.out.println("Can't find this file!");
        }catch(IOException ex) {

        }
    }

//    public int calculateTime() {
//
//    }

    public static void main(String[] args) {
        String filename = "src\\com\\zhao\\lex\\leetcode\\airport\\data\\transport.txt";
        Transport transport = new Transport();
        transport.readAirplane(filename);
        System.out.println(transport.arrive);
//        System.out.println(airplane.arriveType);
//        System.out.println(airplane.leaveTime);
//        System.out.println(airplane.arriveTime);
        //   System.out.println();
    }
}
