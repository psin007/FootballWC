import java.util.Scanner;
/**
 * Displays Menu
 *
 * @author (Pooja Sinha)
 * @version (11-May-2018)
 */
public class Menu
{

    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {

    }

    /**
     * prints menu
     *
     */
    public String menuShow()
    {
        String choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose one of the following:");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("A. Play Preliminary Stage \nB. Play Final\nC. Display Teams\nD. Display Players\nE. Display Cup Result\nX. Close");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");        
        System.out.println("Enter the option: ");
        choice = scan.nextLine();
        return choice;
    }
}
