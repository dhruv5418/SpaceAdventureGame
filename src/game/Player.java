package game;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Player implements Attackable,Dieble {

    public static int Moves = 0;
    public static int playerHP = 10;
    public static String[] spaceships = { "", "", "" };
    public static String[] weapon = {"","",""};
    int opponentHp = 10;
    public static HashMap<String, String> planet = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    int choice;
    Introduction i=new Introduction();
    public static boolean daedalus  = false;
    public static boolean terraVenture = false;
    public static boolean specter = false;
    public Player() {
    }

    public void planet() {
        if ((planet.get("Daedalus").equals("true")) && (planet.get("TerraVenture").equals("true"))
                && (planet.get("Specter").equals("true"))) {

            end();
        } else {
            System.out.println("Select Space station to attack...");
            System.out.println("1. Daedalus" + "\n" + "2. Terra Venture" + "\n" + "3. Specter");

            int choice = sc.nextInt();
            if (choice == 1) {

                if (planet.get("Daedalus").equals("true")) {
                    System.out.println("Bravo!!! you have all ready won the Daedalus, please choose other space station to attack");
                    planet();
                } else {
                  new Daedalus().daedalus();
                }
            } else if (choice == 2) {
                if (planet.get("TerraVenture").equals("true")) {
                    System.out.println("Bravo!!! you have all ready won the Terra Venture, please choose other space station to attack");
                    planet();
                } else {
                    new TerraVenture().terraVenture();
                }
            } else if (choice == 3) {
                if (planet.get("Specter").equals("true")) {
                    System.out.println("Bravo!!! you have all ready won the Specter, please choose other space station to attack");
                    planet();
                } else {
                 new Specter().specter();
                }
            } else {
                planet();
            }

        }
    }
    public void flying() {
        hold();
        System.out.println("Space ship is cruising through the galaxies...");
        hold();
        System.out.println("Space ship is cruising through the galaxies...");
        hold();

    }
    public void choose_weapon() {
        System.out.println("Which Weapon would you like to use?");
        System.out.println("1."+weapon[0] + "\n" + "2." + weapon[1]);
        choice = sc.nextInt();
    }

    public void warpDrive(){
        System.out.println("Wolud you like to turn on Warp drive mode?");
        System.out.println("Tips:Warp drive mode consume more power but helps to travel faster than speed of light!!!");
        System.out.println("1. Yes" + "\n" + "2. No");
        choice=sc.nextInt();
        if(choice==1){
            System.out.println("Warp drive mode is on!!!"+"\n"+"Hold on tight"+"\n"+"You are cruising at speed of 6.5 billion km per second ");
            flying();
            playerHP=playerHP-5;
        }else if(choice==2) {
            System.out.println("You are cruising at speed of 186,000 miles per second");
            flying();
            flying();
            flying();
            playerHP=playerHP-2;
        }else{
            warpDrive();
        }
    }
    public void recoverHP(){
        System.out.println("1. Yes" + "\n" + "2. No");
        choice=sc.nextInt();
        if(choice==1){
            System.out.println("Great!!!Power loss due to travelling is getting recovered");
            playerHP=playerHP+2;
        }
        else if(choice==2){
            System.out.println("Ops!!!Power is low."+"\n"+"Hope for the best. ");
        }
        else {
            recoverHP();
        }
    }

    public void hold() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int getPlayerHP() {
        return playerHP;
    }

    public static void setPlayerHP(int playerHP) {
        Player.playerHP = playerHP;
    }


    @Override
    public void attack() {
        int playerDamage = 0;
        if (choice == 1) {
            Player.Moves = Player.Moves + 1;
            playerDamage = new java.util.Random().nextInt(3);
        } else if (choice == 2) {
            Player.Moves = Player.Moves + 1;
            if (weapon[1].equals("Ion Weapons")) {
                playerDamage = new java.util.Random().nextInt(3);
            } else if (weapon[1].equals("Gauss Guns")) {
                playerDamage = new java.util.Random().nextInt(7) + 1;
            } else if (weapon[1].equals("Plasma(AI based Plasma Destroyer)")) {
                playerDamage = new java.util.Random().nextInt(7) + 1;
            } else if (weapon[1].equals("Lasers")) {
                playerDamage = new java.util.Random().nextInt(7) + 1;
            }

        } else {
            choose_weapon();
        }
        hold();
        System.out.println("You attacked the opponent and gave " + playerDamage + " damage!");
        Player.Moves = Player.Moves + 1;
        opponentHp = opponentHp - playerDamage;
        System.out.println("opponent HP: " + opponentHp);
        Daedalus d = new Daedalus();
        TerraVenture t = new TerraVenture();
        Specter s = new Specter();
        if (opponentHp < 1) {
            if (daedalus) {
                hold();
                d.die();
            } else if (terraVenture) {
                hold();

                t.die();
            } else if (specter) {
                hold();

                s.die();
            }
        } else if (opponentHp > 0) {

            if (daedalus) {
                d.attack();
            } else if (terraVenture) {
                t.attack();
            } else if (specter) {
                s.attack();
            }
            if (playerHP < 1) {
                hold();
                die();
            } else if (playerHP > 0) {
                attack();
            }
        }

    }

    @Override
    public void chooseSpaceShip() {

    }

    @Override
    public void die() {

        System.out.println("Bad Luck!!!Your space ship is destroyed.");
        System.out.println("\n\nGAME OVER");
        System.out
                .println("Remember that some weapon has higher killing strength"+"\n"+"You can always choose different weapon!!");
        System.out.println(
                "Don't worry, the space station which you won will be yours, unless and until you restart the game");
        playerHP = 10;
        setPlayerHP(playerHP);
        hold();
        i.introduuction();
    }

    public void win(){
        System.out.println("victory!!!"+"\n"+"Celebration Time");
        System.out.println("Heading back to Babylon 5");
        flying();
        if (daedalus) {
             playerHP=10;
            planet.replace("Daedalus", "true");
            daedalus = false;
            planet();
        } else if (terraVenture) {
            playerHP=10;
            planet.replace("TerraVenture", "true");
            terraVenture = false;
            planet();
        } else if (specter) {
            playerHP=10;
            planet.replace("Specter", "true");
            specter = false;
            planet();
        }
    }

    public void end(){
        hold();
        System.out.println("Congratulations!! you have won all 3 space station!!!");
        System.out.println("You have proved your bravery to Babylon 5 space station!!!");
        hold();
        System.out.println("Player Name :" +Introduction.PlayerName);
        System.out.println("Total moves :" + Moves);


    }


}
