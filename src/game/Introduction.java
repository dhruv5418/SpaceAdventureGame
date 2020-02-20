package game;

import javax.swing.*;
import java.util.Scanner;
/**
 * Contains all the details of Player and introduction part of game.
 */
public class Introduction extends JPanel  {

    /**
     * Store player name.
     */
    public static String PlayerName;
    /**
     *store player age.
     */
    public static int Age;
    /**
     * store player gender
     */
    public static String Gender;
    /**
     * store player birth date.
     */
    public static String BirthDate;
    /**
     * object of scanner class for user input.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * store user's choice.
     */
    private int choice;

    /**
     * constructor
     */
    public Introduction() {
    }

    /**
     * method to get player's details
     */
    public void playerSetup() {

        System.out.println("Enter your name:-");
        PlayerName = sc.nextLine();
        System.out.println("Hey "+PlayerName);
        Boolean b=true;
        do{
            System.out.println("Enter your age:-");
            choice = sc.nextInt();
            if(choice>0&&choice<110){
                Age=choice;
                b=false;
            }else {
                System.out.println("Please enter correct age.");
            }
        }while (b);
        System.out.println("Enter your Birth date (mm-dd-yyyy):-");
        BirthDate = sc.next();
        do {
            System.out.println("Choose your Gender:-");
            System.out.println("1. Male" + "\n" + "2. Female");
            choice = sc.nextInt();
            if (choice == 1) {
                Gender = "Male";
                b=true;
            } else if (choice == 2) {
                Gender = "Female";
               b=true;
            } else {
                System.out.println("Please,Choose right option.");
            }
        }while (!b);
    }

    /**
     * contains the introduction part of game.
     */
    public  void introduction() {
        Player p = new Player();
        System.out.println("Welcome to the world of Space Adventure");
        p.hold();
        System.out.print("You are on the space station named Babylon 5 Station." + "\n"
                + "You are the commander of this station and you have to protect the citizens of Babylon 5 Station. " + "\n"
                + "You have to destroy 3 rival space station." + "\n"
                + "Make sure to choose proper space ship to win." + "\n"
                + "Here you have 3 Space Station to attack. please choose one." + "\n");
        Player.planet.put("Daedalus", "false");

        Player.planet.put("TerraVenture", "false");
        Player.planet.put("Specter", "false");
        p.hold();
        System.out.println("You can always press 0 while choosing the option for quit the game... ");
        p.planet();
    }
}
