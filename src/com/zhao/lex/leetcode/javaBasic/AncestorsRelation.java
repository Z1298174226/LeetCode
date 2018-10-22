package com.zhao.lex.leetcode.javaBasic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * Created by qtfs on 2018/9/5.
 */
public class AncestorsRelation {
    class Grandfather{
        public void say(){
            System.out.println("It's grandfather said!");
        }
    }

    class Father extends Grandfather{
        public void say(){
            System.out.println("It's father said!");
        }
    }

    class Son extends Father{
        public void say(){

            MethodType methodType = MethodType.methodType(void.class);

            try {
                //找到祖父类的构造函数
              //  MethodHandle inithandle = MethodHandles.lookup().findConstructor(Grandfather.class, methodTypeC);
//                //获取祖父类实例对象
          //      Object o = inithandle.invoke();

                //MethodHandles.Lookup中有个私有的静态全局属性IMPL_LOOPKUP，通过反射，可以获取到该成员属性IMPL_LOOKUP
                //对应的Field对象，并将其设置成可访问，从而得到IMPL_LOOKUP具体对象
                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOKUP.setAccessible(true);
                MethodHandles.Lookup lkp = (MethodHandles.Lookup) IMPL_LOOKUP.get(null);
//                MethodHandle handle = MethodHandles.lookup()
//                        .findVirtual(Grandfather.class, "say", methodType).bindTo(new AncestorsRelation().new Grandfather());
                MethodHandle handle1 = lkp
                        .findSpecial(Grandfather.class, "say", methodType, Grandfather.class);
                //调用祖父类里被父类覆写的方法
               // handle.invoke();
                handle1.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        class Demo {
            private final static int ACCESS = 0;
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        new AncestorsRelation().new Son().say();
    }
}
