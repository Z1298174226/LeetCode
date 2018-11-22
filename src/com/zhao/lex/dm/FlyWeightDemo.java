package com.zhao.lex.dm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by qtfs on 2018/8/1.
 */

/*
享元模式
 */
public class FlyWeightDemo {
    interface FlyWeight {
        void cell();
    }

    static class BookOrder implements FlyWeight {
        private String name;

        BookOrder(String name) {
            this.name = name;
        }

        @Override
        public void cell() {
            System.out.println("卖了一本书，书名为'" + this.name + "'");
        }
    }

    static class FlyWeightFactory {
        static class SingletonInner {
            static FlyWeightFactory factory = new FlyWeightFactory();
        }
        private Map<String, FlyWeight> bookPools = new HashMap<String, FlyWeight>();

        public static FlyWeightFactory getInstance() {
            return SingletonInner.factory;
        }

        //添加订单
        public FlyWeight getOrder(String bookName) {
            FlyWeight order = null;
            if (bookPools.containsKey(bookName)) {
                order = bookPools.get(bookName);
            } else {
                order = new BookOrder(bookName);
                bookPools.put(bookName, order);
            }
            return order;
        }

        public int getTotalObjects() {
            return bookPools.size();
        }

    }

    private static List<FlyWeight> orders = new ArrayList<FlyWeight>();
    private static FlyWeightFactory factory;

    public static void main(String[] args) {
        factory = FlyWeightFactory.getInstance();
        takeOrders("三国演义");
        takeOrders("水浒传");
        takeOrders("封神榜");
        takeOrders("三体");
        takeOrders("红楼梦");
        takeOrders("三国演义");
        takeOrders("封神榜");
        takeOrders("水浒传");

        for (FlyWeight order : orders) {
            order.cell();
        }
        // 打印生成的订单java对象数量
        System.out.println("\n客户一共买了 " + orders.size() + " 本书! ");
        // 打印生成的订单java对象数量
        System.out.println("共生成了 " + factory.getTotalObjects()
                + " 个 FlyWeight java对象! ");
    }

    private static void takeOrders(String bookName) {
        orders.add(factory.getOrder(bookName));
    }
}
