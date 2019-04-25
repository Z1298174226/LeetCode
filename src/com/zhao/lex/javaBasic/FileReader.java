package com.zhao.lex.javaBasic;

import java.io.*;

/**
 * Created by qtfs on 2019/2/27.
 */
public class FileReader {
    public static void main(String[] args) {
        String file =".\\src\\com\\zhao\\lex\\javaBasic\\AnnotationDemo.java";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        RandomAccessFile writers = null;
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("hello");
            writer.flush();
            writer.close();
            String line = reader.readLine();
            while(line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                reader.close();
                writer.close();
            }catch(IOException ex) {

            }
        }
    }
}
