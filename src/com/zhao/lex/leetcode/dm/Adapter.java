package com.zhao.lex.leetcode.dm;

/**
 * Created by qtfs on 2018/8/1.
 */
public class Adapter {

    /*
    Objcet 适配器模式有三个重要角色：
    目标角色（Target），要转换成的目标接口。在我的代码例子中，是中国的两孔接口
    源角色（Adaptee），需要被转换的源接口。在我的代码例子中，是美国的三孔接口
    适配器角色（Adapter），核心是实现Target接口, 组合Adaptee接口
    class 适配器：
    核心是继承Adaptee类，实现target接口
     */
    interface ThreePinSoket {
        void chargeWithThreePin();

        int voltage();
    }

    class ThreePinSoketAmerica implements ThreePinSoket {

        @Override
        public void chargeWithThreePin() {
            System.out.println("美国标准的三孔的插座");
        }

        @Override
        public int voltage() {
            return 110;
        }

    }

    interface TwoPinSoket {
        void chargeWithTwoPin();

        int voltage();
    }

    class TwoPinSoketChina implements TwoPinSoket {

        @Override
        public void chargeWithTwoPin() {
            System.out.println("中国标准的两孔的插座");
        }

        @Override
        public int voltage() {
            return 220;
        }

    }

    class AmericaAdapter implements TwoPinSoket {
        ThreePinSoket threePinSoket; // 组合三孔插座(adaptee)

        public AmericaAdapter(ThreePinSoket threePinSoket) {
            this.threePinSoket = threePinSoket;
        }

        @Override
        public void chargeWithTwoPin() {
            threePinSoket.chargeWithThreePin();
        }

        @Override
        public int voltage() {
            return threePinSoket.voltage() * 2;
        }

    }

    class RongYao {
        TwoPinSoket twoPinSoket;

        public RongYao() {
        }

        public void setTwoPinSoket(TwoPinSoket twoPinSoket) {
            this.twoPinSoket = twoPinSoket;
        }

        public void chargeRequest() {
            System.out.println("华为荣耀手机， " + twoPinSoket.voltage() + " 伏特充电中\n");
        }

    }

    public static void main(String[] args) {

        Adapter adapter = new Adapter();
        TwoPinSoketChina twoPinSoketChina = adapter.new TwoPinSoketChina();
        RongYao myRongYao = adapter.new RongYao();
        myRongYao.setTwoPinSoket(twoPinSoketChina);
        myRongYao.chargeRequest();

        // 然后坐飞机去美国旅游，美国某旅馆的墙上有只有一个三孔插座
        ThreePinSoketAmerica threePinSoketAmerica = adapter.new ThreePinSoketAmerica();
        testThreePin(threePinSoketAmerica);

        // 幸好我有美国适配器，一头插到三孔插座，另一头转换成二孔插座，就可以给我的荣耀手机充电
        AmericaAdapter americaAdapter = adapter.new AmericaAdapter(threePinSoketAmerica);
        testTwoPin(americaAdapter);

        // 在美国，通过美国适配器，用三空插座充电
        myRongYao.setTwoPinSoket(americaAdapter);
        myRongYao.chargeRequest();

    }

    static void testTwoPin(TwoPinSoket twoPinSoket) {
        twoPinSoket.chargeWithTwoPin();
        System.out.println("电压是" + twoPinSoket.voltage() + "伏特\n");
    }

    static void testThreePin(ThreePinSoket threePinSoket) {
        threePinSoket.chargeWithThreePin();
        System.out.println("电压是" + threePinSoket.voltage() + "伏特\n");
    }
}
