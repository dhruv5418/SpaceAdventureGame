package game;

import java.util.Scanner;

public class Daedalus implements Attackable,Dieble {
    Scanner sc = new Scanner(System.in);
    Player p = new Player();
    Introduction i=new Introduction();
    int choice;
    int spaceShipHp;

    public Daedalus() {
    }

    public void daedalus() {
        Player.Moves = Player.Moves + 1;
        System.out.println("You are about to attack on Daedalus Space Station");
        chooseSpaceShip();
        p.flying();
        p.warpDrive();
        System.out.println("Wow!!! That was amazing flight");
        System.out.println("Would you like to turn on solar panels?");
        p.recoverHP();
        p.hold();
        spaceShipHp=Player.getPlayerHP();
        System.out.println("Space ship health is: "+spaceShipHp);
        p.hold();
        System.out.println("Daedalus commander is ready with Gunner space ship for the war");
        System.out.println("Wish you good luck!!!");
        p.choose_weapon();
        Player.daedalus=true;
        p.attack();


    }



    @Override
    public void chooseSpaceShip() {
        Player.Moves = Player.Moves + 1;
        System.out.println(
                "You have 2 option for fighter space ship."
                        + "\n" + "Remember you can only take one space ship please choose wisely according to your opponent");
        System.out.println("Caution!!!: The Daedalus is equip with the Hawk Gunner space ship. ");
        System.out.println("1. Falcon" + "\n" + "2. Gunstar");
        choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("you have chosen Falcon spaceship for attack on Daedalus.");
          Player.spaceships[0] = "Falcon";
          Player.weapon[0]="Beam lamps";
          Player.weapon[1]="Deflector shields with small guns";

        } else if (choice == 2) {
            Player.spaceships[1] = "Gunstar";
            Player.weapon[0]="Ion Weapons";
            Player.weapon[1]="Gauss Guns";
            System.out.println("you have chosen Gunstar spaceship for attack on Daedalus. ");

        }else if(choice==0){
            p.quit();
        } else {
            chooseSpaceShip();
        }
    }

    @Override
    public void attack() {
        int opponentDamage = 0;
        opponentDamage = new java.util.Random().nextInt(4) + 1;
        p.hold();
        System.out.println("The hawk attacked you and gave " + opponentDamage + " damage!");
        spaceShipHp = Player.getPlayerHP();
        spaceShipHp = spaceShipHp - opponentDamage;
        Player.setPlayerHP(spaceShipHp);
        System.out.println("Your space ship HP: " + spaceShipHp);
    }


    @Override
    public void die() {
        p.hold();
        System.out.println("Bravo!!!You defeated the Hawk!");
        System.out.println("Congratulation!!!The Daedalus space station is yours.");
        p.win();

    }
}
