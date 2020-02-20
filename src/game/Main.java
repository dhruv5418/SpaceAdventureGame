package game;

/**
 * The SpaceAdventureGame program implements an text-based game.
 *
 * @author Patel Dhruvkumar Jayantihai-1992744
 * @author Varma Akshay Chandrashekhar-1992658
 * @author Amandeep Singh Sehmi-192746
 *
 * @version 1.0
 * @since 20-02-2020
 */
public class Main {

    /**
     * Main method of game.
     * @param args array of strings which stores arguments passed by command line
     */
    public static void main(String[] args)
    {
        System.out.println("Welcome to Star-Wars!!!");
        Introduction i=new Introduction();
        i.playerSetup();
        i.introduction();
    }

}
