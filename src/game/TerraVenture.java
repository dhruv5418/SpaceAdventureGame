package game;

import java.util.Scanner;

public class TerraVenture implements Attackable,Dieble {

    Scanner sc = new Scanner(System.in);
    Player p = new Player();
    Introduction i=new Introduction();
    int choice;
    int spaceShipHp;
    public TerraVenture() {
    }

    public void terraVenture() {
        Player.Moves = Player.Moves + 1;
        System.out.println("You are about to attack on Terra Venture Space Station");
        chooseSpaceShip();
        p.flying();
        p.warpDrive();
        System.out.println("Wow!!! That was amazing flight");
        System.out.println("Would you like to turn on battery backup?");
        p.recoverHP();
        p.hold();
        spaceShipHp=Player.getPlayerHP();
        System.out.println("Space ship health is: "+spaceShipHp);
        p.hold();
        System.out.println("Terra Venture commander is ready with Ghost space ship for the war");
        System.out.println("Wish you good luck!!!");
        System.out.println("Which Weapon would you like to use?");
        p.choose_weapon();
        Player.terraVenture=true;
        p.attack();
    }

    @Override
    public void attack() {
        int opponentDamage = 0;
        opponentDamage = new java.util.Random().nextInt(4) + 1;
        p.hold();
        System.out.println("The hawk attacked you and gave " + opponentDamage + " damage!");
        spaceShipHp = p.getPlayerHP();
        spaceShipHp = spaceShipHp - opponentDamage;
        p.setPlayerHP(spaceShipHp);
        System.out.println("Your space ship HP: " + spaceShipHp);

    }

    @Override
    public void chooseSpaceShip() {
        Player.Moves = Player.Moves + 1;
        System.out.println(
                "You have 2 option for fighter space ship."
                        + "\n" + "Remember you can only take one space ship please choose wisely according to your opponent");
        System.out.println("Caution!!!: The Terra Venture is equip with the Ghost Armored space ship. ");
        System.out.println("1. Prometheus" + "\n" + "2. Enterprise");
        choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("you have chosen Prometheus spaceship for attack on Terra Venture.");
            Player.spaceships[0] = "Prometheus";
            Player.weapon[0]="Torpedo";
            Player.weapon[1]="Particle Beams";

        } else if (choice == 2) {
            Player.spaceships[1] = "Enterprise";
            Player.weapon[0]="Particle Beams";
            Player.weapon[1]="Lasers";
            System.out.println("you have chosen Enterprise spaceship for attack on Terra Venture. ");

        } else {
            chooseSpaceShip();
        }

    }

    @Override
    public void die() {

        p.hold();
        System.out.println("Bravo!!!You defeated the Hawk!");
        System.out.println("Congratulation!!!The Terra Venture space station is yours.");
        p.win();
    }
}