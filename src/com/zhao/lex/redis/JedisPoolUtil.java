package com.zhao.lex.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by qtfs on 2018/9/26.
 */
public class JedisPoolUtil {
    private static JedisPool pool = null;
    static {
        //加载配置文件
        InputStream in = JedisPoolUtil.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载文件失败");
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大连接数
//        poolConfig.setMaxTotal(Integer.parseInt( pro.get("redis.maxTotal").toString()));
//        //最大空闲连接数
//        poolConfig.setMaxIdle(Integer.parseInt( pro.get("redis.maxIdle").toString()));
//        //最小空闲连接数
//        poolConfig.setMinIdle(Integer.parseInt( pro.get("redis.minIdle").toString()));
//        pool = new JedisPool(poolConfig, pro.get("redis.url").toString(),Integer.parseInt( pro.get("redis.port")
//                .toString()));
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }
    public static void release(Jedis jedis){
        if(null != jedis){
            jedis.close();
        }
    }
}
