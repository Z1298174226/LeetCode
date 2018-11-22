package com.zhao.lex.javaBasic;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.Map;

/**
 * Created by qtfs on 2018/10/16.
 */
public class FutureTaskDemo {
    public Map<Object, Future<String>> tasks = new HashMap<Object, Future<String>>();
    public String compute(final Object taskName) throws ExecutionException, InterruptedException {
        while(true) {
            Future<String> future = tasks.get(taskName);
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    public String call() {
                        return (String) taskName;
                    }
                };
                FutureTask<String> futureTask = new FutureTask(task);
                future = tasks.putIfAbsent(taskName, future);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (CancellationException e) {
                tasks.remove(taskName, future);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("zhao", "xudong");
        String s = map.putIfAbsent("xudong", "zhao");
        System.out.println(s == null);
    }
}
