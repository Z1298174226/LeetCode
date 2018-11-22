package com.zhao.lex.airport;



import java.io.*;
import java.util.Random;
/**
 * Created by qtfs on 2018/9/18.
 */
public class GA {
    private Chromosome[] chromosomes;
    private Chromosome[] nextGeneration;
    private int N;
    private int airplaneNum;
    private double p_c_t;
    private double p_m_t;
    private int MAX_GEN;
    private int[] bestEncode;
    private Chromosome bestChromosome;
    private double bestFitness;
    private double[] averageFitness;
    private double[][] distance;

    public GA(){
        N = 5000;
        airplaneNum = FinalPara.AIRPLANENUM;
        p_c_t = 0.9;
        p_m_t = 0.7;
        MAX_GEN = 1;
        bestEncode = new int [airplaneNum];
        bestFitness = 0.0;
        averageFitness = new double[MAX_GEN];
        chromosomes = new Chromosome[N];
        nextGeneration = new Chromosome[N];
        distance = new double[airplaneNum][airplaneNum];
    }

    /**
     * Constructor of GA class
     * @param n 种群规模
     * @param num 城市规模
     * @param g 运行代数
     * @param p_c 交叉率
     * @param p_m 变异率
     */
    public GA(int n, int num, int g, double p_c, double p_m, String filename){
        this();
        this.N = n;
        this.airplaneNum = num;
        this.MAX_GEN = g;
        this.p_c_t = p_c;
        this.p_m_t = p_m;
        bestEncode = new int [airplaneNum];
        averageFitness = new double[MAX_GEN];
        bestFitness = 0.0;
        chromosomes = new Chromosome[N];
        nextGeneration = new Chromosome[N];
        distance = new double[airplaneNum][airplaneNum];
    }

    public void solve() {
        System.out.println("---------------------Start initilization---------------------");
        init();
        System.out.println("---------------------End initilization---------------------");
        System.out.println("---------------------Start evolution---------------------");
        for (int i = 0; i < MAX_GEN; i++) {
            System.out.println("-----------Start generation "+ i+"----------");
            evolve(i);
            System.out.println("-----------End generation "+ i+"----------");
        }
        System.out.println("---------------------End evolution---------------------");
        printOptimal();
        outputResults();

    }
    /**
     * 初始化GA
     * @throws IOException
     */
    @SuppressWarnings("resource")
    private void init() {
        BoardingGate boardingGate = new BoardingGate();
        boardingGate.readGate("src\\com\\zhao\\lex\\leetcode\\airport\\data\\airGate.txt");
        Airplane airplane = new Airplane();
        airplane.readAirplane("src\\com\\zhao\\lex\\leetcode\\airport\\data\\airplaneData");
        Transport transport = new Transport();
        transport.readAirplane("src\\com\\zhao\\lex\\leetcode\\airport\\data\\transport.txt");
        for (int i = 0; i < N; i++) {
            Chromosome chromosome = new Chromosome(boardingGate, airplane, transport);
            chromosome.randomGeneration();
            chromosomes[i] = chromosome;
           // chromosome.print();
        }
    }

    private void evolve(int g){
        double[] selectionP = new double[N];//选择概率
        double sum = 0.0;
        double tmp = 0.0;

        for (int i = 0; i < N; i++) {
            sum += chromosomes[i].getFitness();
            if (chromosomes[i].getFitness() > bestFitness) {
                bestFitness = chromosomes[i].getFitness();
                for (int j = 0; j < airplaneNum; j++) {
                    bestEncode[j] = chromosomes[i].getEncode()[j];
                }
                bestChromosome = chromosomes[i];
            }
        }
        averageFitness[g] = sum / N;

        System.out.println("The average fitness in "+g+ " generation is: "+averageFitness[g]+ ", and the best fitness is: "+ bestFitness);
        for (int i = 0; i < N; i++) {
            tmp += chromosomes[i].getFitness()/sum;
            selectionP[i] = tmp;
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < N; i = i+2) {

            Chromosome[] children = new Chromosome[2];
            //轮盘赌选择两个染色体
            for (int j = 0; j < 2; j++) {

                int selectedCity=0;
                for (int k = 0; k < N - 1; k++) {
                    double p = random.nextDouble();
                    if (p > selectionP[k] && p <= selectionP[k + 1]) {
                        selectedCity = k;
                    }
                    if (k==0 && random.nextDouble() <= selectionP[k]) {
                        selectedCity = 0;
                    }
                }
                try {
                    children[j] = (Chromosome) chromosomes[selectedCity].clone();

                    //children[j].print();
                    //System.out.println();
                } catch (CloneNotSupportedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            /*

            //交叉操作(OX1)

            if (random.nextDouble() < p_c_t) {
                //定义两个cut点
                int cutPoint1 = -1;
                int cutPoint2 = -1;
                int r1 = random.nextInt(airplaneNum);
                if (r1 > 0 && r1 < airplaneNum -1) {
                    cutPoint1 = r1;
                    //random = new Random(System.currentTimeMillis());
                    int r2 = random.nextInt(airplaneNum - r1);
                    if (r2 == 0) {
                        cutPoint2 = r1 + 1;
                    }else if(r2 > 0){
                        cutPoint2 = r1 + r2;
                    }

                }
                if (cutPoint1 > 0 && cutPoint2 > 0) {
                    //System.out.println("Cut point1 is: "+cutPoint1 +", and cut point2 is: "+cutPoint2);
                    int [] tour1 = new int[airplaneNum];
                    int [] tour2 = new int[airplaneNum];
                    if (cutPoint2 == airplaneNum - 1) {
                        for (int j = 0; j < airplaneNum; j++) {
                            tour1[j] = children[0].getEncode()[j];
                            tour2[j] = children[1].getEncode()[j];
                        }
                    }else {

                        //int n = 1;
                        for (int j = 0; j < airplaneNum; j++) {
                            if (j < cutPoint1) {
                                tour1[j] = children[0].getEncode()[j];
                                tour2[j] = children[1].getEncode()[j];
                            }else if (j >= cutPoint1 && j < cutPoint1+airplaneNum-cutPoint2-1) {
                                tour1[j] = children[0].getEncode()[j+cutPoint2-cutPoint1+1];
                                tour2[j] = children[1].getEncode()[j+cutPoint2-cutPoint1+1];
                            }else {
                                tour1[j] = children[0].getEncode()[j-airplaneNum+cutPoint2+1];
                                tour2[j] = children[1].getEncode()[j-airplaneNum+cutPoint2+1];
                            }

                        }
                    }
                    for (int j = 0; j < airplaneNum; j++) {
                        if (j < cutPoint1 || j > cutPoint2) {

                            children[0].getEncode()[j] = -1;
                            children[1].getEncode()[j] = -1;
                        }else {
                            int tmp1 = children[0].getEncode()[j];
                            children[0].getEncode()[j] = children[1].getEncode()[j];
                            children[1].getEncode()[j] = tmp1;
                        }
                    }
                    if (cutPoint2 == airplaneNum - 1) {
                        int position = 0;
                        for (int j = 0; j < cutPoint1; j++) {
                            for (int m = position; m < airplaneNum; m++) {
                                boolean flag = true;
//                                for (int n = 0; n < airplaneNum; n++) {
//                                    if (tour1[m] == children[0].getEncode()[n]) {
//                                        flag = false;
//                                        break;
//                                    }
//                                }
                                if (flag) {
                                    children[0].encode[j] = tour1[m];
                                    position = m + 1;
                                    break;
                                }
                            }
                        }
                        position = 0;
                        for (int j = 0; j < cutPoint1; j++) {
                            for (int m = position; m < airplaneNum; m++) {
                                boolean flag = true;
//                                for (int n = 0; n < airplaneNum; n++) {
//                                    if (tour2[m] == children[1].getEncode()[n]) {
//                                        flag = false;
//                                        break;
//                                    }
//                                }
                                if (flag) {
                                    children[1].encode[j] = tour2[m];
                                    position = m + 1;
                                    break;
                                }
                            }
                        }

                    }else {

                        int position = 0;
                        for (int j = cutPoint2 + 1; j < airplaneNum; j++) {
                            for (int m = position; m < airplaneNum; m++) {
                                boolean flag = true;
//                                for (int n = 0; n < airplaneNum; n++) {
//                                    if (tour1[m] == children[0].getEncode()[n]) {
//                                        flag = false;
//                                        break;
//                                    }
//                                }
                                if (flag) {
                                    children[0].encode[j] = tour1[m];
                                    position = m+1;
                                    break;
                                }
                            }
                        }
                        for (int j = 0; j < cutPoint1; j++) {
                            for (int m = position; m < airplaneNum; m++) {
                                boolean flag = true;
//                                for (int n = 0; n < airplaneNum; n++) {
//                                    if (tour1[m] == children[0].getEncode()[n]) {
//                                        flag = false;
//                                        break;
//                                    }
//                                }
                                if (flag) {
                                    children[0].encode[j] = tour1[m];
                                    position = m+1;
                                    break;
                                }
                            }
                        }


                        position = 0;
                        for (int j = cutPoint2 + 1; j < airplaneNum; j++) {
                            for (int m = position; m < airplaneNum; m++) {
                                boolean flag = true;
//                                for (int n = 0; n < airplaneNum; n++) {
//                                    if (tour2[m] == children[1].getEncode()[n]) {
//                                        flag = false;
//                                        break;
//                                    }
//                                }
                                if (flag) {
                                    children[1].encode[j] = tour2[m];
                                    position = m+1;
                                    break;
                                }
                            }
                        }
                        for (int j = 0; j < cutPoint1; j++) {
                            for (int m = position; m < airplaneNum; m++) {
                                boolean flag = true;
//                                for (int n = 0; n < airplaneNum; n++) {
//                                    if (tour2[m] == children[1].getEncode()[n]) {
//                                        flag = false;
//                                        break;
//                                    }
//                                }
                                if (flag) {
                                    children[1].encode[j] = tour2[m];
                                    position = m+1;
                                    break;
                                }
                            }
                        }
                    }



                }
            }
            //children[0].print();
            //children[1].print();

*/
            //变异操作(DM)

            //System.out.println("---------Start mutation------");
/*
            if (random.nextDouble() < p_m_t) {

                for (int j = 0; j < 2; j++) {
                    //定义两个cut点
                    int cutPoint1 = -1;
                    int cutPoint2 = -1;
                    int r1 = random.nextInt(airplaneNum);
                    if (r1 > 0 && r1 < airplaneNum -1) {
                        cutPoint1 = r1;
                        //random = new Random(System.currentTimeMillis());
                        int r2 = random.nextInt(airplaneNum - r1);
                        if (r2 == 0) {
                            cutPoint2 = r1 + 1;
                        }else if(r2 > 0){
                            cutPoint2 = r1 + r2;
                        }

                    }


                    if (cutPoint1 > 0 && cutPoint2 > 0) {
                        List<Integer> tour = new ArrayList<Integer>();
                        //System.out.println("Cut point1 is "+cutPoint1+", and cut point2 is "+cutPoint2);
                        if (cutPoint2 == airplaneNum - 1) {
                            for (int k = 0; k < cutPoint1; k++) {
                                tour.add(Integer.valueOf(children[j].getEncode()[k]));
                            }
                        }else {
                            for (int k = 0; k < airplaneNum; k++) {
                                if (k < cutPoint1 || k > cutPoint2) {
                                    tour.add(Integer.valueOf(children[j].getEncode()[k]));
                                }
                            }
                        }
                        //random = new Random(System.currentTimeMillis());
                        int position = random.nextInt(tour.size());

                        if (position == 0) {

                            for (int k = cutPoint2; k >= cutPoint1; k--) {
                                tour.add(0, Integer.valueOf(children[j].getEncode()[k]));
                            }

                        }else if (position == tour.size()-1) {

                            for (int k = cutPoint1; k <= cutPoint2; k++) {
                                tour.add(Integer.valueOf(children[j].getEncode()[k]));
                            }

                        } else {

                            for (int k = cutPoint1; k <= cutPoint2; k++) {
                                tour.add(position, Integer.valueOf(children[j].getEncode()[k]));
                            }

                        }
                        for (int k = 0; k < airplaneNum; k++) {
                            children[j].getEncode()[k] = tour.get(k).intValue();

                        }
                    }
                }
            }
            */
            nextGeneration[i] = children[0];
            nextGeneration[i+1] = children[1];

        }

        for (int k = 0; k < N; k++) {
            try {
                chromosomes[k] = (Chromosome) nextGeneration[k].clone();

            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    private void printOptimal(){
        System.out.println("The best fitness is: " + bestFitness);
        System.out.println("The best dispatch is: ");
//        for (int i = 0; i < airplaneNum; i++) {
//            System.out.print(bestEncode[i] + ", ");
//        }
//        System.out.println();
        bestChromosome.print();
    }

    private void outputResults(){
        String filename = "src\\com\\zhao\\lex\\leetcode\\intelligent_Algorithm\\GAlgorithm\\result.txt";
     /*File file = new File(filename);
     if (!file.exists()) {
       try {
         file.createNewFile();
       } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }
     }
     */
        try {
            @SuppressWarnings("resource")
            FileOutputStream outputStream = new FileOutputStream(filename);
            for (int i = 0; i < averageFitness.length; i++) {
                String line = String.valueOf(averageFitness[i]) + "\r\n";
                outputStream.write(line.getBytes());

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public Chromosome[] getChromosomes() {
        return chromosomes;
    }
    public void setChromosomes(Chromosome[] chromosomes) {
        this.chromosomes = chromosomes;
    }
    public int getAirplaneNum() {
        return airplaneNum;
    }
    public void setAirplaneNum(int cityNum) {
        this.airplaneNum = cityNum;
    }
    public double getP_c_t() {
        return p_c_t;
    }
    public void setP_c_t(double p_c_t) {
        this.p_c_t = p_c_t;
    }
    public double getP_m_t() {
        return p_m_t;
    }
    public void setP_m_t(double p_m_t) {
        this.p_m_t = p_m_t;
    }
    public int getMAX_GEN() {
        return MAX_GEN;
    }
    public void setMAX_GEN(int mAX_GEN) {
        MAX_GEN = mAX_GEN;
    }
    public int[] getBestEncode() {
        return bestEncode;
    }
    public void setBestEncode(int[] bestEncode) {
        this.bestEncode = bestEncode;
    }
    public double[] getAverageFitness() {
        return averageFitness;
    }
    public void setAverageFitness(double[] averageFitness) {
        this.averageFitness = averageFitness;
    }
    public int getN() {
        return N;
    }


    public void setN(int n) {
        N = n;
    }


    public double[][] getDistance() {
        return distance;
    }

    public void setDistance(double[][] distance) {
        this.distance = distance;
    }



    public static void main(String[] args) {
        GA ga = new GA();
        ga.solve();
//        ga.init();
    }
}
