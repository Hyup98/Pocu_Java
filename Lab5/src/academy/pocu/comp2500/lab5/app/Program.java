package academy.pocu.comp2500.lab5.app;

import academy.pocu.comp2500.lab5.*;
import academy.pocu.comp2500.lab5.*;

public class Program {

    public static void main(String[] args) {
        Barbarian barbarian0 = new Barbarian("Dragonborn Whiterun", 250, 210, 60);
        Barbarian barbarian1 = new Barbarian("Ulfric Stormcloak", 200, 70, 10);

        barbarian0.attack(barbarian1);

        assert barbarian1.getHp() == 100;
        assert barbarian1.isAlive();

        barbarian0.attack(barbarian1);

        assert barbarian1.getHp() == 0;
        assert !barbarian1.isAlive();

        Gladiator gladiator0 = new Gladiator("Parthunax", 250, 210, 10);
        Gladiator gladiator1 = new Gladiator("Zoro", 100, 150, 65);
        Move move0 = new Move("Gomu Gomu no pistol", 50, 10);
        Move move1 = new Move("Thunderbolt", 90, 15);
        Move move2 = new Move("Ice Beam", 90, 10);
        Move move3 = new Move("Surf", 90, 15);

        assert gladiator0.addMove(move0);
        assert gladiator0.addMove(move1);
        assert gladiator0.addMove(move2);
        assert gladiator0.addMove(move3);

        assert gladiator0.removeMove("Surf");

        gladiator0.attack("Gomu Gomu no pistol", barbarian0);

        assert barbarian0.getHp() == 163;
        assert barbarian0.isAlive();

        gladiator0.attack("Gomu Gomu no pistol", gladiator1);

        assert gladiator1.getHp() == 20;

        gladiator1.rest();

        assert gladiator1.getHp() == 30;

        Knight knight0 = new Knight("Naruto", 252, 310, 99);
        Knight knight1 = new Knight("Sasuke", 250, 290, 111);
        Pet pet0 = new Pet("Giant Toad", 180);

        knight0.setPet(pet0);

        knight0.attackTogether(gladiator0);

        assert gladiator0.getHp() == 10;

        knight0.attackTogether(knight1);

        assert knight1.getHp() == 61;
    }
}
