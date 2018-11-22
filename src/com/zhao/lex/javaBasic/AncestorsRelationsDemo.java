package com.zhao.lex.javaBasic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * Created by qtfs on 2018/10/16.
 */
public class AncestorsRelationsDemo {
    class GrandFater{
        public void say() {
            System.out.println("It's grandfather said!");
        }
    }

    class Father extends GrandFater{
        @Override
        public void say() {
            System.out.println("It's father said!");
        }
    }

    class Son extends Father {
        @Override
        public void say() {
            MethodType methodType = MethodType.methodType(void.class);
            try{
                Field IMPL_LOOPUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOPUP.setAccessible(true);
                MethodHandles.Lookup lkp = (MethodHandles.Lookup) IMPL_LOOPUP.get(null);
                MethodHandle handle = lkp.findSpecial(GrandFater.class, "say", methodType, GrandFater.class);
                handle.invoke(this);
            }catch(NoSuchFieldException ex) {

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AncestorsRelationsDemo().new Son().say();
    }



}
