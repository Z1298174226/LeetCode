package com.zhao.lex.leetcode.javaBasic;


/**
 * Created by qtfs on 2018/9/28.
 */
public interface EventListener extends java.util.EventListener {
    //事件处理
    public void handleEvent(EventObject event);
}
