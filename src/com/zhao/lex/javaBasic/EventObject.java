package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2018/9/28.
 */
public class EventObject extends java.util.EventObject{
    private static final long serialVersionUID = 1L;
    public EventObject(Object source){
        super(source);
    }
    public void doEvent(){
        System.out.println("通知一个事件源 source :"+ this.getSource());
    }

}
