package com.zhao.lex.javaBasic;

/**
 * Created by qtfs on 2018/6/12.
 */
public class EffectiveJava17 {
    class Super {
        public void print() {
            System.out.println("I am " + getContent());

        }

        public String getContent() {
            return "Super";
        }
    }

    class Sub extends Super {
        @Override
        public void print() {
            System.out.println("I am " + getContent());
            super.print();
        }
        @Override
        public String getContent() {
            return "Sub";
        }
    }

    public static void main(String[] args) {
        EffectiveJava17 effectiveJava17 = new EffectiveJava17();
        Super obj = effectiveJava17.new Sub();
        obj.print();
    }
}
