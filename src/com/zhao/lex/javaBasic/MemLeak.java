package com.zhao.lex.javaBasic;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;


/**
 * Created by qtfs on 2018/11/7.
 */
public class MemLeak {
    static class MyClassLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String filename) throws ClassNotFoundException {
            String file = filename.substring(filename.lastIndexOf(".") + 1) + ".class";
            try{
                InputStream stream = getClass().getResourceAsStream(file);
                if(stream == null)
                    return super.loadClass(filename);
                byte[] bytes = new byte[stream.available()];
                stream.read(bytes);
                return defineClass(filename, bytes, 0, bytes.length);

            }catch(IOException ex) {
                throw new ClassNotFoundException();
            }
        }
    }

    ThreadLocal<Object> threadLocal = new ThreadLocal<>();


    public static void main(String[] args)  {
        new Thread(() -> {
            ClassLoader myLoader = new MyClassLoader();
            Object demo = null;
            try {
                demo = myLoader.loadClass("com.zhao.lex.javaBasic.Demo").newInstance();
                new MemLeak().threadLocal.set(demo);

                while(true) {
                    myLoader = null;
                    demo = null;
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
