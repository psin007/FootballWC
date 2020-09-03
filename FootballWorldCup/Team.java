import java.util.ArrayList;
import java.util.Scanner;
/**
 * Performs team operations
 *
 * @author (Pooja Sinha)
 * @version (1)
 */
public class Team
{
    private String name;
    private int rank;
    private Player player1  = new Player(); 
    private Player player2 = new Player();
    private int[] scoreDetail;
    RandomGoalsGenerator rand = new RandomGoalsGenerator();

    /**
     * default constructor
     */
    public Team()
    {
        name = "";
        rank = 0;
        scoreDetail = new int[10];
    }

    /**
     * non default constructor
     */
    public Team(String newName,String newRank) 
    {
        name = newName;
        rank = Integer.parseInt(newRank);
        scoreDetail = new int[10];
    }

    /**
     * getter for Player1
     */
    public Player getPlayer1()
    {
        return player1;
    }

    /**
     * getter for player2
     */
    public Player getPlayer2()
    {
        return player2;
    }

    /**
     * setter for ScoreDetail
     */
    public void setScoreDetail(int newValue, int index)
    {
        scoreDetail[index] = newValue;
    }

    /**
     * validates the name of player in a team
     */
    public void validateName(int i,Team[] teamList)
    {
        String blank = " ";
        System.out.println("Enter player1 name for team " + teamList[i].getName());
        player1.checkPlayerName(i,blank,teamList);
        System.out.println("Enter player2 name for team " + teamList[i].getName());
        player2.checkPlayerName(i,player1.getName(),teamList);
    }

    /**
     * getter for name
     */
    public String getName()
    {
        return name;
    }

    /**
     * getter for rank
     */
    public int getRank()
    {
        return rank;
    }

    /**
     * getter for ScoreDetail
     */
    public int getScoreDetail(int index)
    {
        return scoreDetail[index];
    }

    /**
     * setter for name
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * setter for rank
     */
    public void setRank(int newRank)
    {
        rank = newRank;
    }

    /**
     * setter for player1
     */
    public void setPlayer1(Player newPlayer)
    {
        player1 = newPlayer;
    }

    /**
     * settre for player2
     */
    public void setPlayer2(Player newPlayer)
    {
        player2 = newPlayer;
    }

    /**
     * generates upset value
     */
    public double upset()
    {
        rand.setMin(0); 
        rand.setMax(2);
        return Math.floor(rand.randomNumber());
    }

    /**
     * goal by team of better rank
     */
    public int higherGoal()
    {
        rand.setMin(0);
        double maximum = 5 + upset();
        rand.setMax(maximum);
        double goalHigh = rand.randomNumber();
        return (int)goalHigh; 
    }

    /**
     * goal by team of lower rank
     */
    public int lowerGoal(int rankDiff)
    {
        rand.setMin(0);
        double maximum = (5 - rankDiff) + upset();
        rand.setMax(maximum);
        double goalHigh = rand.randomNumber();
        return (int)goalHigh; 
    }

    /**
     * randomly distributing goals by player
     */
    public void playerGoals(int goals)
    {
        rand.setMin(0);
        rand.setMax(1);        
        double toss = rand.randomNumber(); //to randomly distribute goals scored by team between players
        rand.setMin(0);
        rand.setMax(goals);
        int marker = (int)rand.randomNumber();
        if (toss > 0.5)
        {
            player1.setGoals(player1.getGoals() + marker);
            player2.setGoals(player2.getGoals() + (goals - marker));
        }
        else
        {
            player2.setGoals(player2.getGoals() + marker);
            player1.setGoals(player2.getGoals() + (goals-marker));
        }
    }
    //cards awarded- at index 6 of scoreDetail
    /**
     * sets yellow and red card
     */
    public void setCard()
    {
        rand.setMin(0);
        rand.setMax(1);
        double ifAward = rand.randomNumber(); //if card should be awarded or not 
        if (ifAward  < 0.30)
        { 
            rand.setMin(0);
            rand.setMax(4); 
            int whichCard = (int)Math.round(rand.randomNumber());
            if (whichCard <= 3)
            {
                int prevYellowCard = getScoreDetail(6);
                setScoreDetail((prevYellowCard + 1),6);
            } 
            else
            {
                int prevRedCard = getScoreDetail(7);
                setScoreDetail((prevRedCard + 1),7);
            }
        }
        int totalCard = getScoreDetail(6) + getScoreDetail(7);
        setScoreDetail(totalCard,8);
    }

    /**
     * if player scored in penalty shoot out or not
     */
    public boolean shoot()
    {
        rand.setMin(0);
        rand.setMax(1);
        double num = rand.randomNumber() ;
        if(num > 0.5)
            return true;
        else
            return false;       
    }
}