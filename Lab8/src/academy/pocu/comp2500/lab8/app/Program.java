package academy.pocu.comp2500.lab8.app;

import academy.pocu.comp2500.lab8.Drainer;
import academy.pocu.comp2500.lab8.Planter;
import academy.pocu.comp2500.lab8.Schedule;
import academy.pocu.comp2500.lab8.Sprinkler;

public class Program {
    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
        Test8();
        Test9();
    }

    public static void Test1() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(0, 4));
        sprinkler.addSchedule(new Schedule(1, 4));
        sprinkler.addSchedule(new Schedule(2, 3));
        sprinkler.addSchedule(new Schedule(6, 4));

        boolean[] expectedIsOn = new boolean[]{false, true, true, true, true, false, true,
                true, true, true, false, false, false};

        for (int i = 0; i < expectedIsOn.length; ++i) {
            assert (expectedIsOn[i] == sprinkler.isOn());
            sprinkler.onTick();
        }
    }

    public static void Test2() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(3, 20));
        Drainer drainer = new Drainer(50);

        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);
        planter.installSmartDevice(drainer);

        int[] expectedWaterAmount = new int[]{0, 0, 0, 13, 26, 39, 52, 58, 64, 70,
                76, 82, 88, 94, 100, 106, 112, 118, 124, 130,
                136, 142, 148, 139, 130, 121, 112, 103, 94, 85,
                76, 67, 58, 49, 47, 45, 43, 41, 39, 37,
                35, 33, 31, 29, 27, 25, 23, 21, 19, 17};

        int[] sprinklerTicksSinceLastUpdate = new int[]{0, 1, 2, 0, 1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 0, 1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        int[] drainerTicksSinceLastUpdate = new int[]{0, 1, 2, 3, 4, 5, 6, 0, 1, 2,
                3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                23, 24, 25, 26, 0, 1, 2, 3, 4, 5,
                6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        for (int i = 0; i < expectedWaterAmount.length; ++i) {
            assert (expectedWaterAmount[i] == planter.getWaterAmount());
            assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate()) : i;
            assert (drainerTicksSinceLastUpdate[i] == drainer.getTicksSinceLastUpdate()) : i;
            planter.tick();
        }
    }

    public static void Test3() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(1, 2));
        sprinkler.addSchedule(new Schedule(10, 2));
        sprinkler.addSchedule(new Schedule(5, 3));

        boolean[] expectedIsOn = new boolean[]{
                false, true, true, false, false,
                false, false, false, false, false,
                true, true, false, false, false
        };

        int[] sprinklerTicksSinceLastUpdate = new int[]{
                0, 0, 1, 0, 1,
                2, 3, 4, 5, 6,
                0, 1, 0, 1, 2
        };

        boolean b1 = false;
        boolean b2 = false;
        int tick1 = 0;
        int tick2 = 0;
        for (int i = 0; i < expectedIsOn.length; ++i) {
            b1 = expectedIsOn[i];
            b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            tick1 = sprinklerTicksSinceLastUpdate[i];
            tick2 = sprinkler.getTicksSinceLastUpdate();
            assert (tick1 == tick2) : i;

            sprinkler.onTick();
        }
    }

    public static void Test4() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(4, 8));
        sprinkler.addSchedule(new Schedule(3, 4));

        boolean[] expectedIsOn = new boolean[]{false, false, true, true, true, true, true,
                false, false, false, false, false, false, false, false};

        for (int i = 0; i < expectedIsOn.length; ++i) {
            assert (expectedIsOn[i] == sprinkler.isOn()) : i;
            sprinkler.onTick();
        }
    }

    public static void Test5() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(1, 2));
        sprinkler.addSchedule(new Schedule(10, 2));
        sprinkler.addSchedule(new Schedule(5, 3));
        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);
        boolean[] expectedIsOn = new boolean[]{
                false, true, true, false, false,
                false, false, false, false, false,
                true, true, false, false, false
        };

        int[] expectedWater = new int[]{
                0, 13, 26, 24, 22,
                20, 18, 16, 14, 12,
                25, 38, 36, 34, 32
        };

        int[] expectedTick = new int[]{
                0, 0, 1, 0, 1,
                2, 3, 4, 5, 6,
                0, 1, 0, 1, 2
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            boolean b1 = expectedIsOn[i];
            boolean b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int t1 = expectedTick[i];
            int t2 = sprinkler.getTicksSinceLastUpdate();
            assert (t1 == t2) : i;

            planter.tick();
        }
    }

    public static void Test6() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(4, 8));
        sprinkler.addSchedule(new Schedule(3, 4));
        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);
        boolean[] expectedIsOn = new boolean[]{
                false, false, true, true, true,
                true, true, false, false, false,
                false, false, false, false, false
        };

        int[] expectedWater = new int[]{
                0, 0, 13, 26, 39,
                52, 65, 63, 61, 59,
                57, 55, 53, 51, 49
        };

        int[] expectedTick = new int[]{
                0, 1, 0, 1, 2,
                3, 4, 0, 1, 2,
                3, 4, 5, 6, 7
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            boolean b1 = expectedIsOn[i];
            boolean b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int t1 = expectedTick[i];
            int t2 = sprinkler.getTicksSinceLastUpdate();
            assert (t1 == t2) : i;

            planter.tick();
        }
    }

    public static void Test7() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(2, 5));
        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);
        boolean[] expectedIsOn = new boolean[]{
                false, false, true, true, true,
                true, true, false, false, false,
                false, false, false, false, false
        };

        int[] expectedWater = new int[]{
                0, 0, 13, 26, 39,
                52, 65, 63, 61, 59,
                57, 55, 53, 51, 49
        };

        int[] expectedTick = new int[]{
                0, 1, 0, 1, 2,
                3, 4, 0, 1, 2,
                3, 4, 5, 6, 7
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            boolean b1 = expectedIsOn[i];
            boolean b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int t1 = expectedTick[i];
            int t2 = sprinkler.getTicksSinceLastUpdate();
            assert (t1 == t2) : i;

            planter.tick();
        }
    }

    public static void Test8() {
        Sprinkler sprinkler = new Sprinkler();
        sprinkler.addSchedule(new Schedule(1, 1));
        sprinkler.addSchedule(new Schedule(2, 5));
        sprinkler.addSchedule(new Schedule(2, 5));
        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);
        boolean[] expectedIsOn = new boolean[]{
                false, true, false, false, false,
                false, false, false, false, false
        };

        int[] expectedWater = new int[]{
                0, 13, 11, 9, 7,
                5, 3, 1, 0, 0
        };

        int[] expectedTick = new int[]{
                0, 0, 0, 1, 2,
                3, 4, 5, 6, 7
        };

        for (int i = 0; i < expectedIsOn.length; ++i) {
            boolean b1 = expectedIsOn[i];
            boolean b2 = sprinkler.isOn();
            assert (b1 == b2) : i;

            int w1 = expectedWater[i];
            int w2 = planter.getWaterAmount();
            assert (w1 == w2) : i;

            int t1 = expectedTick[i];
            int t2 = sprinkler.getTicksSinceLastUpdate();
            assert (t1 == t2) : i;

            planter.tick();
        }
    }

    public static void Test9() {
        Sprinkler sprinkler = new Sprinkler();

        sprinkler.addSchedule(new Schedule(3, 20));
        Drainer drainer = new Drainer(0);

        Planter planter = new Planter(0);
        planter.installSmartDevice(sprinkler);
        planter.installSmartDevice(drainer);

        int[] expectedWater = new int[]{
                0, 0, 0, 6, 12,
                18, 24, 30, 36, 42,
                48, 54, 60, 66, 72,
                78, 84, 90, 96, 102,
                108, 114, 120, 111, 102,
                93, 84, 75, 66, 57
        };

        int[] sprinklerTicksSinceLastUpdate = new int[]{
                0, 1, 2, 0, 1,
                2, 3, 4, 5, 6,
                7, 8, 9, 10, 11,
                12, 13, 14, 15, 16,
                17, 18, 19, 0, 1,
                2, 3, 4, 5, 6
        };

        int[] drainerTicksSinceLastUpdate = new int[]{
                0, 0, 1, 2, 3,
                4, 5, 6, 7, 8,
                9, 10, 11, 12, 13,
                14, 15, 16, 17, 18,
                19, 20, 21, 22, 23,
                24, 25, 26, 27, 28
        };

        for (int i = 0; i < expectedWater.length; ++i) {
            System.out.print(i + " -> " + planter.getWaterAmount() + "       S:" + sprinkler.isOn() + "    D:" + drainer.isOn() + "\n");
            planter.tick();
        }
    }

}