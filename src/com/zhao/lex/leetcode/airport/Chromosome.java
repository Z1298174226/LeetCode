package com.zhao.lex.leetcode.airport;

import com.zhao.lex.leetcode.airport.enumSet.ArriveType;
import com.zhao.lex.leetcode.airport.enumSet.DirectionMap;
import com.zhao.lex.leetcode.airport.enumSet.LeaveType;
import com.zhao.lex.leetcode.airport.enumSet.Type;

import java.util.*;

/**
 * Created by qtfs on 2018/9/18.
 */
public class Chromosome implements Cloneable {

    private BoardingGate boardingGate;
    private Airplane airplane;
    private Transport transport;
    public int[] encode;
    private boolean[] isEncode;
    private int tempNum;
    private int airplaneNum;
    private int gateNum;
    private double fitness;
    private int[][] walkTable = new int[][]{{10, 15, 20, 25, 20, 25, 25}, {15, 10, 15, 20, 15, 20, 20}, {20, 15, 10, 25, 20, 25, 25},
            {25, 20, 25, 10, 15, 20, 10}, {20, 15, 20, 15, 10, 15, 15}, {25, 20, 25, 20, 15, 10, 20},  {25, 20, 25, 20, 15, 20, 10}};

    public Chromosome(BoardingGate boardingGate, Airplane airplane, Transport transport){
        this.boardingGate = boardingGate;
        this.airplane = airplane;
        this.transport = transport;
        airplaneNum = FinalPara.AIRPLANENUM;
        gateNum = FinalPara.GATENUM;
        tempNum = 0;
        encode = new int[airplaneNum];
        isEncode = new boolean[airplaneNum];
    }

    public Chromosome(BoardingGate boardingGate, Airplane airplane, int num, int tempNum){
        this.boardingGate = boardingGate;
        this.airplane = airplane;
        this.airplaneNum = num;
        encode = new int[airplaneNum];
        this.tempNum = tempNum;

    }
    private void init() {
        boardingGate.hasPlane.clear();
    }
    public void randomGeneration() {
        init();
        Random r = new Random();
        for(int i = 0; i < airplaneNum; i++) {
                for (int j = 0; j < 100; j++) {
                    int index = r.nextInt(gateNum);
                    if (!isSuitable(index, i)) continue;
                    else {
                        encode[i] = index;
                        isEncode[i] = true;
                        boardingGate.hasPlane.put(index, i);
                        break;
                    }
                }
            if(!isEncode[i]) {
                encode[i] = 70;
                isEncode[i] = true;
                tempNum++;
            }
        }
    }
//    public void randomGenerations(){
//        Vector<Integer> allowedAirplane = new Vector<Integer>();
//        for (int i = 0; i < airplaneNum; i++) {
//            allowedAirplane.add(Integer.valueOf(i));
//        }
//
//        Random r = new Random(System.currentTimeMillis());
//        for (int i = 0; i < airplaneNum; i++) {
//            int index = r.nextInt(allowedAirplane.size());
//            int selectedCity = allowedAirplane.get(index).intValue();
//            encode[i] = selectedCity;
//            allowedAirplane.remove(index);
//        }
//    }

    public void print(){
        for (int i = 0; i < airplaneNum; i++) {
            System.out.print(encode[i] + ",");
        }
        System.out.println();
        System.out.println("Its fitness measure is: "+ getFitness());
        System.out.println("Used Gate is: " + calculateUsedGate());
        System.out.println(tempNum);
    }
    private int calculateUsedGate() {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : getEncode())
            set.add(i);
        return set.size();
    }
    private double calculatefitness(){
        double fitness = 0.0;
     //   fitness = 1 / (double)(calculateUsedGate() + tempNum * 10);
      //  fitness = 1 / (double)(calculateUsedGate() + tempNum * 10 + calculateWholeTime());
        fitness = 1 / (double)(calculateUsedGate() + tempNum * 10 + calculateWholeTime() + calculationTenseTime() * 2000);
       // System.out.println(calculationTenseTime());
        return fitness;
    }

    private double calculateWholeTime() {
        double sum = 0.0;
        double people = 0.0;
        for(int i = 0; i < transport.numbers.size(); i++) {
            String arriveFlight = transport.arrive.get(i);
            String leaveFlight = transport.leave.get(i);
            ArriveType arriveTypeFlight = airplane.arriveFlightType.get(arriveFlight);
            if(!airplane.arriveFlightType.containsKey(arriveFlight))
                continue;
            LeaveType leaveTypeFlight = airplane.leaveFlightType.get(leaveFlight);
            int arriveIndex = airplane.arriveFlight.get(arriveFlight);
            int leaveIndex = airplane.leaveFlight.get(leaveFlight);
            int arriveGate = encode[arriveIndex];
            if(arriveGate == 70)
                continue;
            int leaveGate = encode[leaveIndex];
            if(leaveGate == 70)
                continue;
            Type arriveType = boardingGate.type.get(arriveGate);
            Type leaveType = boardingGate.type.get(leaveGate);
            sum += transportTime(arriveTypeFlight, leaveTypeFlight, arriveType, leaveType) * transport.numbers.get(i);
            people += transport.numbers.get(i);
        }
        return sum / people;
    }

    private double calculationTenseTime() {
        double tense = 0.0;
        for(int i = 0; i < transport.numbers.size(); i++) {
            String arriveFlight = transport.arrive.get(i);
            String leaveFlight = transport.leave.get(i);
            if(!airplane.arriveFlightType.containsKey(arriveFlight))
                continue;
            String[] arriveTime = airplane.arriveTimeTable.get(arriveFlight).get(0).split(":");
            int time = 0;
            for(int j = 0; j < airplane.leaveTimeTable.get(leaveFlight).size(); j++) {
                String[] leaveTime = airplane.leaveTimeTable.get(leaveFlight).get(j).split(":");
                time = Integer.valueOf(leaveTime[0]) - Integer.valueOf(arriveTime[0]) * 60 + (Integer.valueOf(leaveTime[1]) - Integer.valueOf(arriveTime[1]));
                if(time < 0)
                    continue;
            }
            if(time < 0)
                time += 60 * 24;
            ArriveType arriveTypeFlight = airplane.arriveFlightType.get(arriveFlight);
            LeaveType leaveTypeFlight = airplane.leaveFlightType.get(leaveFlight);
            int arriveIndex = airplane.arriveFlight.get(arriveFlight);
            int leaveIndex = airplane.leaveFlight.get(leaveFlight);
            int arriveGate = encode[arriveIndex];
            if(arriveGate == 70)
                continue;
            int leaveGate = encode[leaveIndex];
            if(leaveGate == 70)
                continue;
            Type arriveType = boardingGate.type.get(arriveGate);
            Type leaveType = boardingGate.type.get(leaveGate);
            String arriveDir = boardingGate.direction.get(arriveGate);
            String leaveDir = boardingGate.direction.get(leaveGate);
            if(arriveType == Type.T)
                arriveDir = "T" + arriveDir;
            else
                arriveDir = "S" + arriveDir;
            if(leaveType == Type.T)
                leaveDir = "T" + leaveDir;
            else
                leaveDir = "S" + leaveDir;
            int mrt = transportTimeMRT(arriveTypeFlight, leaveTypeFlight, arriveType, leaveType);
            int walk = walkTable[DirectionMap.directionMap.get(arriveDir)][DirectionMap.directionMap.get(leaveDir)];
            int wholeTime = mrt + walk;
            if(wholeTime > time) wholeTime = 360;
            tense += (double) wholeTime / time;
        }
        return tense / transport.numbers.size();
    }

    private int transportTime(ArriveType arriveTypeFlight, LeaveType leaveTypeFlight, Type arriveType, Type leaveType) {
        if(arriveTypeFlight == ArriveType.D) {
            if(leaveTypeFlight == LeaveType.D) {
                if(arriveType == Type.T) {
                    if(leaveType == Type.T) {
                        return 15;
                    }else {
                        return 20;
                    }
                }else {
                    if(leaveType == Type.T) {
                        return 20;
                    }else {
                        return 15;
                    }
                }
            }
            else {
                if(arriveType == Type.T) {
                    if(leaveType == Type.T) {
                        return 35;
                    }else {
                        return 40;
                    }
                }else {
                    if(leaveType == Type.T) {
                        return 40;
                    }else {
                        return 35;
                    }
                }
            }
        }else {
            if(leaveTypeFlight == LeaveType.D) {
                if(arriveType == Type.T) {
                    if(leaveType == Type.T) {
                        return 35;
                    }else {
                        return 40;
                    }
                }else {
                    if(leaveType == Type.T) {
                        return 40;
                    }else {
                        return 45;
                    }
                }
            }
            else {
                if(arriveType == Type.T) {
                    if(leaveType == Type.T) {
                        return 20;
                    }else {
                        return 30;
                    }
                }else {
                    if(leaveType == Type.T) {
                        return 30;
                    }else {
                        return 20;
                    }
                }
            }
        }
    }

    private int transportTimeMRT(ArriveType arriveTypeFlight, LeaveType leaveTypeFlight, Type arriveType, Type leaveType) {
        if(arriveTypeFlight == ArriveType.D) {
            if(leaveTypeFlight == LeaveType.D) {
                if(arriveType == Type.T) {
                    if(leaveType == Type.T) {
                        return 15;
                    }else {
                        return 28;
                    }
                }else {
                    if(leaveType == Type.T) {
                        return 28;
                    }else {
                        return 15;
                    }
                }
            }
            else {
                if(arriveType == Type.T) {
                    if(leaveType == Type.T) {
                        return 35;
                    }else {
                        return 48;
                    }
                }else {
                    if(leaveType == Type.T) {
                        return 48;
                    }else {
                        return 35;
                    }
                }
            }
        }else {
            if(leaveTypeFlight == LeaveType.D) {
                if(arriveType == Type.T) {
                    if(leaveType == Type.T) {
                        return 35;
                    }else {
                        return 48;
                    }
                }else {
                    if(leaveType == Type.T) {
                        return 48;
                    }else {
                        return 61;
                    }
                }
            }
            else {
                if(arriveType == Type.T) {
                    if(leaveType == Type.T) {
                        return 20;
                    }else {
                        return 38;
                    }
                }else {
                    if(leaveType == Type.T) {
                        return 38;
                    }else {
                        return 20;
                    }
                }
            }
        }
    }

    public int[] getEncode() {
        return encode;
    }

    public void setEncode(int[] encode) {
        this.encode = encode;
    }

    public int getTempNum() {
        return tempNum;
    }

    public void setTempNum(int tempNum) {
        this.tempNum = tempNum;
    }

    public int getAirplaneNum() {
        return airplaneNum;
    }

    public void setAirplaneNum(int airplaneNum) {
        this.airplaneNum = airplaneNum;
    }

    public double getFitness() {
        this.fitness = calculatefitness();
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Chromosome chromosome = (Chromosome) super.clone();
        chromosome.airplaneNum = this.airplaneNum;
        chromosome.tempNum = this.tempNum;
        chromosome.encode = this.encode.clone();
        chromosome.fitness = this.fitness;
        return chromosome;
    }

    public boolean isBoardngPlane(int gateIndex, int airplaneIndex) {
        if(boardingGate.hasPlane.get(gateIndex) == null) return true;
        String arriveTime = airplane.arriveTime.get(airplaneIndex);
        String[] arrive = arriveTime.split(":");
        String leaveTime = airplane.leaveTime.get(boardingGate.hasPlane.get(gateIndex));
        String[] leave = leaveTime.split(":");
        int time = (Integer.valueOf(arrive[0]) - Integer.valueOf(leave[0])) * 60 + Integer.valueOf(arrive[1]) - Integer.valueOf(leave[1]);
        if(time >= 45) return true;
        else return false;
    }

    public boolean isSuitablePlane(int gateIndex, int airplaneIndex) {
        return boardingGate.arriveType.get(gateIndex).contains(airplane.arriveType.get(airplaneIndex))
                &&boardingGate.leaveType.get(gateIndex).contains(airplane.leaveType.get(airplaneIndex))
                && boardingGate.airplaneType.get(gateIndex).equals(airplane.airplaneType.get(airplaneIndex));
    }

    public boolean isSuitable(int gateIndex, int airplaneIndex) {
        return isBoardngPlane(gateIndex, airplaneIndex) && isSuitablePlane(gateIndex, airplaneIndex);
    }
}
