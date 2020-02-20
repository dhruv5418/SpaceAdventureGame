package game;

import java.util.Scanner;

/**
 * Class TerraVenture which contains all methods and attributes for attack on TerraVenture space-station.
 * Implemented from Attackable,GameOver interfaces.
 */
public class TerraVenture implements Attackable,GameOver {

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
    public TerraVenture() {

    }

    /**
     * contains full process to attack on opponent space ship.
     * contains method calling to player class.
     */
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
        System.out.println("Terra Venture commander is ready with Ghost space ship for the war");
        p.hold();
        System.out.println("Space ship health is: "+spaceShipHp);
        p.hold();
        System.out.println("What do you want to do?");
        confirmAttack();
    }

    /**
     * code for attack by opponent space ship on player's space ship
     */
    @Override
    public void attack() {
        int opponentDamage = 0;
        opponentDamage = new java.util.Random().nextInt(3) + 1;
        p.hold();
        System.out.println("The Ghost attacked you and gave " + opponentDamage + " damage!");
        spaceShipHp = Player.getPlayerHP();
        spaceShipHp = spaceShipHp - opponentDamage;
        Player.setPlayerHP(spaceShipHp);
        System.out.println("Your space ship HP: " + spaceShipHp);

    }

    /**
     * Attack confirmation method.
     */
    @Override
    public void confirmAttack() {
        System.out.println("1. Attack" + "\n" + "2. Abort");
        choice=sc.nextInt();
        if(choice==1){
            Player.Moves = Player.Moves + 1;
            System.out.println("Bravo");
            p.hold();
            System.out.println("Wish you good luck!!!");
            p.choose_weapon();
            Player.terraVenture=true;
            p.fight();
        }
        else if(choice==2){
            Player.Moves = Player.Moves + 1;
            System.out.println("Aborting mission...");
            p.die();
        }
        else {
            confirmAttack();
        }
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
        System.out.println("Bravo!!!You defeated the Ghost!");
        System.out.println("Congratulation!!!The Terra Venture space station is yours.");
        p.win();
    }
}
