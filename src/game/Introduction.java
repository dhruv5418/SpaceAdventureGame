package game;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Introduction {

    public static String PlayerName;
    /**
     *
     */
    public static int Age;
    public static String Gender;
    public static String Birthdate;
    Scanner sc = new Scanner(System.in);

    public Introduction() {
    }

    public void playerSetup() {

        System.out.println("enter your name");
        PlayerName = sc.nextLine();
        System.out.println("enter your age");
        Age = sc.nextInt();
        System.out.println("Enter your Birth date (dd/mm/yy):");
        Birthdate = sc.next();
        System.out.println("enter your Gender");
        Gender = sc.next();

    }

    /**
     *
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
