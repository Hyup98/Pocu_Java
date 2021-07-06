package academy.pocu.comp2500.lab8.app;

import academy.pocu.comp2500.lab8.Planter;
import academy.pocu.comp2500.lab8.Schedule;
import academy.pocu.comp2500.lab8.Sprinkler;

public class Program {

    public static void main(String[] args) {
        {
            Sprinkler sprinkler = new Sprinkler();

            sprinkler.addSchedule(new Schedule(2, 3));

            Planter planter = new Planter(0);
            planter.installSmartDevice(sprinkler);

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

            for (int i = 0; i < 40; ++i) {
                System.out.print(i + "(" + planter.getWaterAmount() + ")" + " -> " + sprinkler.isOn() + "  " + sprinkler.getTicksSinceLastUpdate() + "\n");
                planter.tick();
            }
        }
    }
}