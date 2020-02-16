package game;

import java.util.Scanner;

public class Specter implements Attackable,Dieble {
    /**
     * object of scanner class for user input
     */
    Scanner sc = new Scanner(System.in);
    /**
     * object of player class.
     */
    Player p = new Player();
    /**
     * object of Introduction class.
     */
    Introduction i=new Introduction();
    /**
     * to store choice made by user
     */
    int choice;
    /**
     * player health
     */
    int spaceShipHp;

    /**
     * constructor
     */
    public Specter() {

    }

    /**
     * contains full process to attack on opponent space ship.
     * contains method calling to player class.
     */
    public void specter() {
        Player.Moves = Player.Moves + 1;
        System.out.println("You are about to attack on Specter Space Station");
        chooseSpaceShip();
        p.flying();
        p.warpDrive();
        System.out.println("Wow!!! That was amazing flight");
        System.out.println("Would you like to turn on Nuclear Reactor?");
        p.recoverHP();
        p.hold();
        spaceShipHp = Player.getPlayerHP();
        System.out.println("Space ship health is: "+spaceShipHp);
        p.hold();
        System.out.println("Specter commander is ready with Slave-1 space ship for the war");
        System.out.println("Wish you good luck!!!");
        p.choose_weapon();
        Player.specter=true;
        p.attack();

    }

    /**
     * code for attack by opponent space ship on player's space ship
     */
    @Override
    public void attack() {

        int opponentDamage = 0;
        opponentDamage = new java.util.Random().nextInt(3) + 1;
        p.hold();
        System.out.println("The hawk attacked you and gave " + opponentDamage + " damage!");
        spaceShipHp = Player.getPlayerHP();
        spaceShipHp = spaceShipHp - opponentDamage;
        Player.setPlayerHP(spaceShipHp);
        System.out.println("Your space ship HP: " + spaceShipHp);
    }

    /**
     * use to choose space ship for attack.
     */
    @Override
    public void chooseSpaceShip() {
        Player.Moves = Player.Moves + 1;
        System.out.println(
                "You have 2 option for fighter space ship."
                        + "\n" + "Remember you can only take one space ship please choose wisely according to your opponent");
        System.out.println("Caution!!!: The Specter is equip with the Slave-1 robotic army space ship. ");
        System.out.println("1. Tie Fighter" + "\n" + "2. Star Destroyer");
        choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("you have chosen Tie Fighter spaceship for attack on Specter.");
            Player.spaceships[0] = "Tie Fighter";
            Player.weapon[0]="Lasers";
            Player.weapon[1]="Particle Beams";

        } else if (choice == 2) {
            Player.spaceships[1] = "Star Destroyer";
            Player.weapon[0]="sentient";
            Player.weapon[1]="Plasma(AI based Plasma Destroyer)";
            System.out.println("you have chosen Star Destroyer spaceship for attack on Specter. ");

        }else if(choice==0){
            p.quit();
        }
        else {
            chooseSpaceShip();
        }


    }


    /**
     * code for successful attack on opponent and congratulation.
     */
    @Override
    public void die() {

        p.hold();
        System.out.println("Bravo!!!You defeated the Hawk!");
        System.out.println("Congratulation!!!The Daedalus space station is yours.");
        p.win();
    }
}
