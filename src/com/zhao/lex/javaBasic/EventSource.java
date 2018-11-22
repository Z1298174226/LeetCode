package com.zhao.lex.javaBasic;

import java.util.Vector;

/**
 * Created by qtfs on 2018/9/28.
 */
public class EventSource {
    //监听器列表，监听器的注册则加入此列表
    private Vector<EventListener> ListenerList = new Vector<EventListener>();
    //注册监听器
    public void addListener(EventListener eventListener){
        ListenerList.add(eventListener);
    }
    //撤销注册
    public void removeListener(EventListener eventListener){
        ListenerList.remove(eventListener);
    }
    //接受外部事件
    public void notifyListenerEvents(EventObject event){
        for(EventListener eventListener:ListenerList){
            eventListener.handleEvent(event);
        }
    }

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();

        eventSource.addListener(new EventListener(){
            @Override
            public void handleEvent(EventObject event) {
                event.doEvent();
                if(event.getSource().equals("closeWindows")){
                    System.out.println("doClose");
                }
            }

        });
        /*
         * 传入openWindows事件，通知listener，事件监听器，
         对open事件感兴趣的listener将会执行
         **/
        eventSource.notifyListenerEvents(new EventObject("openWindows"));

    }

}
