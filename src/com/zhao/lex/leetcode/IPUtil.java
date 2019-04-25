package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2019/3/25.
 */
public class IPUtil {
    public static long ipToLong(String strIp) {
        String[] ip = strIp.split("\\.");
        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + (Long.parseLong(ip[3]));
    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        System.out.println(ipToLong(ip));
        System.out.println(longToip(ipToLong(ip)));
    }

   public static String longToip(long number) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(number >>> 24));
        sb.append(".");
        sb.append(String.valueOf((number & 0x00ffffff) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((number & 0x0000ffff) >>> 8));
        sb.append(".");
        sb.append(String.valueOf((number & 0x000000ff)));
        return sb.toString();
   }


}
