package academy.pocu.comp2500.lab5.app;

import academy.pocu.comp2500.lab5.Barbarian;

public class Program {

    public static void main(String[] args) {
        Barbarian barbarian0 = new Barbarian("Dragonborn Whiterun", 100, 250, 10);
        Barbarian barbarian1 = new Barbarian("Ulfric Stormcloak", 100, 70, 50);

        System.out.print(barbarian1.isAlive()); // true

        barbarian0.attack(barbarian1);

        System.out.print(barbarian1.isAlive()); // false
    }
}
