import java.util.Scanner;
import java.util.ArrayList;
/**
 * Defines player playing the game.
 *
 * @author (Pooja Sinha)
 * @version (1)
 */
public class Player
{
    private String name; 
    int goals;
    RandomGoalsGenerator random = new RandomGoalsGenerator();

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        name = "";
        goals = 0;
    }

    /**
     * Constructor for objects of class Player - non default
     */
    public Player(String newName, int newGoals)
    {
        name = newName;
        goals = newGoals;

    }

    /**
     * checks name of player is valid or not
     */
    public void checkPlayerName(int i,String usedName,Team[] teamList)
    {
        Scanner scan = new Scanner(System.in);
        int errorCount = 0;
        StringBuffer sb;
        while (errorCount < 2)
        {
            if (errorCount == 1)
                System.out.println("Try again...");
            int hyphenCount = 0;
            String pName = scan.nextLine().trim();
            boolean specialFlag = false;
            for (int p = 0;p < pName.length();p++)
            {
                if (pName.charAt(p) == '-')
                    hyphenCount++;
                else if (!Character.isLetter(pName.charAt(p)))
                {
                    System.out.println("Name cant have digits or special characters\n");
                    errorCount = errorCount + 1;
                    specialFlag = true;
                    break;
                }
            }
            if (specialFlag == true)
                continue;         

            else if (pName.length() < 2 || pName.length() > 80 || pName.startsWith("-") || pName.endsWith("-") || hyphenCount >= 2)
            {
                System.out.println("Player name must be between 2 and 80 characters and must not start or end with hyphen.\nIt can have ONLY ONE hyphen in middle.\n");
                errorCount = errorCount + 1;
            }                          
            else if (pName.equalsIgnoreCase(usedName))
            {
                System.out.println("Team already has player of same name.\n");
                errorCount = errorCount + 1;
            }
            else    
            {
                setName(pName);
                break;
            }
            hyphenCount = 0;
        }  

        if (errorCount == 2)
        { 
            sb = new StringBuffer("Player-");
            sb.append(teamList[i].getName());
            if (sb.toString().equals(usedName))
            {
                sb.append("B");                
            }
            setName(sb.toString());
            System.out.println("Default name selected is: " +getName());
        }
    }

    /**
     * getter for goal
     */
    public int getGoals()
    {
        return goals;
    }

    /**
     * getter for name
     */
    public String getName()
    {
        return name;
    }

    /**
     * setter for goal
     */
    public void setGoals(int newGoals)
    {
        goals = newGoals;
    }

    /**
     * setter for name
     */
    public void setName(String newName)
    {
        name = newName;
    }

}