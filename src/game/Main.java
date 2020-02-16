package game;

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
