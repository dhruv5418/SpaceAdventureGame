package game;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Contains all the attributes and methods of player for ex-moves,playerHp,fight,win,etc...
 */
public class Player implements GameOver {

    /**
     * count the total moves used by player.
     */
    public static int Moves = 0;
    /**
     * player health
     */
    public static int playerHP = 10;
    /**
     * array of string stores the space ship selected by player.
     */
    public static String[] spaceships = { "", "", "" };
    /**
     * array of string stores the weapon selected by player for attack.
     */
    public static String[] weapon = {"","",""};
    /**
     * opponent space ship health.
     */
    int opponentHp = 10;
    /**
     * HashMap of string to prevent re-attack on opponent space ships.
     */
    public static HashMap<String, String> planet = new HashMap<>();
    /**
     * object of scanner class for user input
     */
    Scanner sc = new Scanner(System.in);
    /**
     * to store choice made by user
     */
    int choice;
    /**
     * store total life of player for the game.
     */
    int life=3;
    /**
     * boolean to prevent re-attack on daedalus.
     */
    public static boolean daedalus  = false;
    /**
     * boolean to prevent re-attack on terraVenture.
     */
    public static boolean terraVenture = false;
    /**
     * boolean to prevent re-attack on specter.
     */
    public static boolean specter = false;

    /**
     * constructor
     */
    public Player() {
    }

    /**
     * contains code for choosing opponent space ship to attack.
     */
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
            } else if(choice==0){
                quit();
            }else {
                planet();
            }

        }
    }

    /**
     *  fly method with some text.
     */
    public void flying() {
        hold();
        System.out.println("Space ship is cruising through the galaxies...");
        hold();
        System.out.println("Space ship is cruising through the galaxies...");
        hold();
    }

    /**
     * contains code for choosing weapon to attack on opponent space ship.
     */
    public void choose_weapon() {
        System.out.println("Which Weapon would you like to use?");
        System.out.println("1."+weapon[0] + "\n" + "2." + weapon[1]);
        choice = sc.nextInt();
    }

    /**
     * contains cod for wrap drive mode.
     */
    public void warpDrive(){
        System.out.println("Would you like to turn on Warp drive mode?");
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
        }else if(choice==0){
            quit();
        }
        else{
            warpDrive();
        }
    }

    /**
     * health recovery code.
     */
    public void recoverHP(){
        System.out.println("1. Yes" + "\n" + "2. No");
        choice=sc.nextInt();
        if(choice==1){
            System.out.println("Great!!!Power loss due to travelling is getting recovered");
            playerHP=playerHP+2;
        }
        else if(choice==2){
            System.out.println("Ops!!!Power is low."+"\n"+"Hope for the best. ");
        }else if(choice==0){
            quit();
        }
        else {
            recoverHP();
        }
    }

    /**
     * method to take sleep of thread.
     */
    public void hold() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * getter method for playeHp.
     * @return player's healh.
     */
    public static int getPlayerHP() {
        return playerHP;
    }

    /**
     * setter method for playeHp.
     * @param playerHP player's healh.
     *
     */
    public static void setPlayerHP(int playerHP) {
        Player.playerHP = playerHP;
    }


    /**
     * contains code for attack by player's space ship on opponent space ship.
     */

    public void fight() {
        int playerDamage = 0;
        if (choice == 1) {
            Player.Moves = Player.Moves + 1;
            playerDamage = new java.util.Random().nextInt(3);
        } else if (choice == 2) {
            Player.Moves = Player.Moves + 1;
            switch (weapon[1]) {
                case "Ion Weapons":
                    playerDamage = new java.util.Random().nextInt(3);
                    break;
                case "Gauss Guns":
                    playerDamage = new java.util.Random().nextInt(7) + 1;
                    break;
                case "Plasma(AI based Plasma Destroyer)":
                    playerDamage = new java.util.Random().nextInt(7) + 1;
                    break;
                case "Lasers":
                    playerDamage = new java.util.Random().nextInt(7) + 1;
                    break;
            }

        }else if(choice==0){
            quit();
        }
        else {
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
                System.out.println("Bad Luck!!!Your space ship is destroyed.");
                hold();
                System.out.println("Remember that some weapon has higher killing strength"+"\n"+"You can always choose different weapon!!");
                hold();
                die();
            } else if (playerHP > 0) {
                fight();
            }
        }

    }



    /**
     * contains code for player's lose.
     */
    @Override
    public void die() {
        System.out.println("Don't worry, the space station which you won will be yours, unless and until you restart the game");
        hold();
        System.out.println("Available Life="+life);
        hold();
        if (life>0){

            System.out.println("Do you want to play again?");
            hold();
            System.out.println("1. Yes"+"\n"+"2. No");
            choice=sc.nextInt();
            if(choice==1){
                life--;
                playerHP = 10;
                setPlayerHP(playerHP);
                planet();
            }else if (choice==2){
                quit();
            }else if(choice==0){
                quit();
            }
            else {
                die();
            }

        }else{
            hold();
            System.out.println("\n\nGAME OVER");
            hold();
            System.out.println("\nBetter luck next time!!!");
            hold();
            System.out.println("Thank you for playing...");
            System.out.println("Player Name :" +Introduction.PlayerName);
            System.out.println("Total moves :" + Moves);
            System.exit(1);
        }

    }

    /**
     * contains code for players after completion of successful attack .
     */
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

    /**
     * contains code for quiting the game by player.
     */
   public void quit(){
        System.out.println("Are you sure you want to exit?");
        System.out.println("1. Yes"+"\n"+"2. No");
        choice=sc.nextInt();
        if(choice==1){
            System.out.println("Thank you for playing...");
            System.out.println("Hope to see you soon...");
            System.out.println("Player Name :" +Introduction.PlayerName);
            System.out.println("Total moves :" + Moves);
            System.exit(1);
        }else if(choice==2){
            return;
        }else{
            quit();
        }

    }

    /**
     * contains code after complete victory at the end of game.
     */
    public void end(){

        hold();
        System.out.println("Congratulations!! you have won all 3 space station!!!");
        System.out.println("You have proved your bravery to Babylon 5 space station!!!");
        hold();
        System.out.println("Player Name :" +Introduction.PlayerName);
        System.out.println("Total moves :" + Moves);
    }


}
