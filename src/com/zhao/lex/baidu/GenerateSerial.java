package com.zhao.lex.baidu;

import java.io.*;
import java.nio.Buffer;
import java.util.Random;

/**
 * Created by qtfs on 2019/5/13.
 */
public class GenerateSerial {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\com\\zhao\\lex\\baidu\\num.txt"));
        for(double x = 1.0; x < 2000; x += 0.1) {
        //    writer.write(String.valueOf(Math.cos(x) + Math.log(x) + random.nextDouble() / 10) + '\n');
            writer.write(String.valueOf(Math.cos(x) + Math.sin(x) + Math.sqrt(x) + Math.tan(x) + Math.log(x) + random.nextDouble() / 10) + '\n');
          //  System.out.println(Math.cos(x) + Math.log(x) + random.nextDouble() / 10);
        }
    }
}
