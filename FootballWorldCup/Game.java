import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
/**
 * This class defines all rules and regulations of this game
 *
 * @author (Pooja Sinha)
 * @version (1)
 */
public class Game
{
    private Team[] teamList;
    int prelimDone;
    int finalDone;
    Team winner;
    String gbAward;
    String fairPlayTeam = " ";

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        int sizeTeam = 4;
        teamList  = new Team[sizeTeam];
        prelimDone = 1;
        finalDone = 1;
        winner = new Team();
        gbAward = " ";
        fairPlayTeam = " ";
    }

    /**
     * Parameterised constructor of class Game taking all parameters
     *
     */
    public Game (Team[] newTeamList,int newPrelimDone,int newFinalDone, Team newWinner,String newgbAward,String newfairPlayTeam)
    {
        teamList = newTeamList;
        prelimDone = newPrelimDone;
        finalDone = newFinalDone;
        winner = newWinner;
        gbAward = newgbAward;
        fairPlayTeam = newfairPlayTeam;
    }

    /**
     * it caculates marks on basis of red and yellow card
     *
     */
    public void calculateMarks()
    {
        for (int i = 0 ;i < teamList.length;i ++)
        {
            int mark = (teamList[i].getScoreDetail(6) * 1) + (teamList[i].getScoreDetail(7) * 2);
            teamList[i].setScoreDetail(mark,9);
        }
    }

    /**
     * it displays cup result
     *
     */
    public void displayCupResult()
    {
        if(winner.getName().equals(""))
            System.out.println("Winner has not been decided");
        else
        {
            System.out.println("Football World cup winner: " + winner.getName());
            System.out.println("Golden Boot Award: " + gbAward);
            System.out.println("Fair play Award: " + fairPlayTeam);
        }
    }

    /**
     * it displays game result
     *
     */
    public void displayGameResult(int team1,int team2)
    {

        System.out.print("Game result: ");
        System.out.println(teamList[team1].getName() + " " + teamList[team1].getScoreDetail(5) + " vs. " + teamList[team2].getName() +" " + teamList[team2].getScoreDetail(5));

        if (teamList[team1].getScoreDetail(6) != 0)
        {
            System.out.print("Cards Awarded : ");
            System.out.println(teamList[team1].getName() + "-" + teamList[team1].getScoreDetail(6) + " Yellow card");
        }
        if (teamList[team2].getScoreDetail(6) != 0)
        {
            System.out.print("Cards Awarded : ");
            System.out.println(teamList[team2].getName() + "-" + teamList[team2].getScoreDetail(6) + " Yellow card");
        }
        if (teamList[team1].getScoreDetail(7) != 0)
        {
            System.out.print("Cards Awarded : ");
            System.out.println(teamList[team1].getName() + "-" + teamList[team1].getScoreDetail(7) + " Red card");
        }
        if (teamList[team2].getScoreDetail(7) != 0)
        {
            System.out.print("Cards Awarded : ");
            System.out.println(teamList[team2].getName() + "-" + teamList[team2].getScoreDetail(7) + " Red card");
        }

    }

    /**
     * to display players name and goals 
     *
     */     
    public void displayPlayers()
    {
        for (int i = 0;i < teamList.length; i++)
        {
            System.out.println(teamList[i].getPlayer1().getName() + "(" + teamList[i].getName() + ")" + "-" + teamList[i].getPlayer1().getGoals());
            System.out.println(teamList[i].getPlayer2().getName() + "(" + teamList[i].getName() + ")" + "-" + teamList[i].getPlayer2().getGoals());
        }
    }

    /**
     * to display teams
     *
     */
    public void displayTeams()
    {
        sortTeam();
        System.out.println("Team\t\tPlayed\t\tWon\t\tLost\t\tDrawn\t\tGoals\t\tPoints\t\tFair Play Score");
        for(int i = 0;i < teamList.length ;i++)
        {
            System.out.println(teamList[i].getName() + "\t\t" + teamList[i].getScoreDetail(0) + "\t\t" + teamList[i].getScoreDetail(1) + "\t\t" + teamList[i].getScoreDetail(3) 
                + "\t\t" + teamList[i].getScoreDetail(2) + "\t\t" + teamList[i].getScoreDetail(5) + "\t\t" + teamList[i].getScoreDetail(4) + "\t\t" +
                teamList[i].getScoreDetail(9));
        } 
    }

    /**
     * getter for teamList
     *
     * @param  index  index to retrieve in an array
     * @return    team at index
     */
    public Team getTeamList(int index)
    {
        return teamList[index];
    }

    /**
     * it validates player names
     *
     */
    public void playerNames()
    {
        Menu menuObj = new Menu();
        try
        {
            for (int i = 0;i < teamList.length;i++)
            {
                teamList[i].validateName(i,teamList);   //uncomment later
            }
        }
        catch (ArrayIndexOutOfBoundsException exception) 
        {
            System.out.println(exception); 
        }
    }

    /**
     * plays final game
     *
     */
    public void playFinal()
    {
        int flagerr = 0;
        for(int i= 0; i< teamList.length; i++)
        {
            if(teamList[i].getScoreDetail(0) < 3)
            {
                flagerr = 1;
                break;
            }
        }
        if (flagerr == 1)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("Preliminary round is not Complete, User have to play preliminary round first!!"); 
            System.out.println("-----------------------------------------------");        
        }
        else if (finalDone !=1)
        {
            System.out.println("---------------------");    
            System.out.println("Final has already been played no more matches left!!!");
            System.out.println("---------------------");
        }
        else
        {
            System.out.println("Playing finale...");
            playGame(2);    // as only two teams in final   
            if (teamList[0].getScoreDetail(5) == teamList[1].getScoreDetail(5)) //goal is at index 5 of scoreDetail
            {
                winner = playPenaltyShootOut();
            }
            else if (teamList[0].getScoreDetail(5) > teamList[1].getScoreDetail(5))
            {
                winner = teamList[0];
            }
            else 
                winner = teamList[1];

            System.out.println("Goals : " + teamList[0].getName() + " : " + teamList[0].getScoreDetail(5));
            System.out.println("Goals : " + teamList[1].getName() + " : " + teamList[1].getScoreDetail(5));
            System.out.println("****************----------****************-----------*************");
            System.out.println("World Champions are : " + winner.getName());
            System.out.println("****************----------****************-----------*************");
            finalDone = 2;
        }
    }

    /**
     * set logic to play game between 2 teams
     *
     */
    public void playGame(int length)
    {
        int team1 = 0; //1st team iterator
        int team2 = team1 + 1;
        int round = 1;
        int goal1 = 0; //goal by first team
        int goal2 = 0; //goal by second team
        for (team1 = 0; team1 < length;team1++)
        {
            for (team2 = team1 + 1; team2  < length;team2++)
            {
                if (length == teamList.length) 
                {
                    System.out.println("Round " + round + "begins...");
                    System.out.println("*******************************");
                }
                System.out.println(teamList[team1].getName() + " VS " + teamList[team2].getName());
                int rankDiff = Math.abs(teamList[team1].getRank() - teamList[team2].getRank());
                goal1 = teamList[team1].higherGoal(); //goal by first team
                goal2 = teamList[team2].lowerGoal(rankDiff); //goal by second team
                teamList[team1].setScoreDetail(goal1,5);
                teamList[team2].setScoreDetail(goal2,5);
                teamList[team1].playerGoals(teamList[team1].getScoreDetail(5));
                teamList[team1].playerGoals(teamList[team2].getScoreDetail(5));
                teamList[team1].setCard();
                teamList[team2].setCard(); 
                if (goal1  > goal2) //team1 wins
                {
                    teamList[team1].setScoreDetail((teamList[team1].getScoreDetail(0)) + 1,0); // no of games played is incremented for team1
                    teamList[team1].setScoreDetail((teamList[team1].getScoreDetail(1)) + 1,1); // no of matches won is incremented for team1
                    teamList[team1].setScoreDetail((teamList[team1].getScoreDetail(4)) + 3,4); // points increased by 3 for team1
                    teamList[team2].setScoreDetail((teamList[team2].getScoreDetail(0)) + 1,0); // no of games played is incremented for team2                   
                    teamList[team2].setScoreDetail((teamList[team2].getScoreDetail(3)) + 1,3); // no of matches lost is incremented for team2
                }
                else if (goal1 < goal2) // team2 wins
                {
                    teamList[team2].setScoreDetail((teamList[team2].getScoreDetail(0)) + 1,0); // no of games played is incremented for team2
                    teamList[team2].setScoreDetail((teamList[team2].getScoreDetail(1)) + 1,1); // no of matches won is incremented for team2
                    teamList[team2].setScoreDetail((teamList[team2].getScoreDetail(4) + 3),4); // points increased by 3 for team2
                    teamList[team1].setScoreDetail((teamList[team1].getScoreDetail(0)) + 1,0); // no of games played is incremented for team1                 
                    teamList[team1].setScoreDetail((teamList[team1].getScoreDetail(3)) + 1,3); // no of matches lost is incremented for team1         
                }
                else if (goal1 == goal2)//draw
                {
                    teamList[team1].setScoreDetail((teamList[team1].getScoreDetail(0)) + 1,0); // no of games played is incremented for team1
                    teamList[team2].setScoreDetail((teamList[team2].getScoreDetail(0)) + 1,0); // no of games played is incremented for team2
                    teamList[team1].setScoreDetail((teamList[team1].getScoreDetail(2)) + 1,2); // no of matches draw is incremented for team1
                    teamList[team2].setScoreDetail((teamList[team2].getScoreDetail(2)) + 1,2); // no of matches draw is incremented for team2
                    teamList[team1].setScoreDetail((teamList[team1].getScoreDetail(4)) + 1,4); // points increased by 1 for team1     
                    teamList[team2].setScoreDetail((teamList[team2].getScoreDetail(4)) + 1,4); // points increased by 1 for team1                        
                }  
                if (length == teamList.length)
                    displayGameResult(team1,team2);
                round++;
            }
        }

    }    

    /**
     * it sets rules to play penatly shoot out in case of tie
     *
     */
    public Team playPenaltyShootOut()
    {
        int goal1 = 0;
        int goal2 = 0;
        for(int chance = 0 ; chance < 5; chance++)
        {
            boolean shootTotal1 =  teamList[0].shoot();
            if(shootTotal1 == true)
                goal1 = goal1 +1;            
            boolean shootTotal2 =  teamList[1].shoot();
            if(shootTotal2 == true)
                goal2 = goal2 + 1;            
        }
        if (goal1 > goal2)
            return teamList[0];
        else if (goal1 < goal2)
            return teamList[1];
        else
            return tieBreaker();
    }

    /**
     * plays preliminary game
     *
     */
    public void preliminary()
    {
        if (prelimDone !=1)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("Preliminary round has been completed. User can only play final round!!!");
            System.out.println("-----------------------------------------------");   
        }
        else
        {
            playGame(teamList.length);
            System.out.println("-----------------------------------------------");
            System.out.println("End of Preliminary round !!!");
            System.out.println("-----------------------------------------------"); 
            prelimDone = 2;
        }           
    }

    /**
     * Prints fair play teams award winners
     *
     */
    public void printFairPlay()
    {
        calculateMarks();
        int min = 0;
        for (int i = 0;i < teamList.length;i ++)
        {
            if (teamList[i].getScoreDetail(9) == min) //index 9 in array ScoreDetail for marks            
                fairPlayTeam = fairPlayTeam + " " + (teamList[i].getName());            
            else if (teamList[i].getScoreDetail(9) < min)            
                fairPlayTeam = teamList[i].getName();            
        }        
        System.out.println("Fair play team award: " + fairPlayTeam);
    }

    /**
     * Prints golden boot award winners
     *
     */
    public void printGoldenBoot()
    { 
        int max = 0;
        String gbAward = " ";
        for (int i = 0;i < teamList.length;i ++) 
        {
            if (teamList[i].getPlayer1().goals == max)               
                gbAward = gbAward + " " + (teamList[i].getPlayer1().getName() );               
            else if (teamList[i].getPlayer2().goals == max)               
                gbAward.concat(teamList[i].getPlayer2().getName() + " ");                                     
            else if (teamList[i].getPlayer1().goals > max)               
                gbAward = teamList[i].getPlayer1().getName();               
            else if (teamList[i].getPlayer2().goals > max)               
                gbAward = teamList[i].getPlayer2().getName();

        }
        System.out.println("Golden boot award: " +gbAward);
    }    

    /**
     * Sorts the rank
     *
     */       
    public void rankSort() //At 0th position, rank1
    {
        //temporary team object to swap position
        Team temp;
        for(int i =0 ; i <teamList.length ; i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(teamList[j].getRank() > teamList[i].getRank())
                {
                    temp = teamList[j];
                    teamList[j]=teamList[i];
                    teamList[i]=temp;
                }
            }
        }        
    }

    /**
     * sorts team when basis of points , goals ,else by random number
     */
    public void sortTeam() 
    {
        Team temp;
        for (int i = 0;i < teamList.length;i++)
        {
            int iPoints = teamList[i].getScoreDetail(4);
            int iGoals = teamList[i].getScoreDetail(5);
            for (int j = 0;j < teamList.length;j++)
            {
                int jPoints = teamList[j].getScoreDetail(4);
                int jGoals = teamList[j].getScoreDetail(5);   

                if(jPoints < iPoints)
                {
                    temp = teamList[j];
                    teamList[j] = teamList [i];
                    teamList[i] = temp;
                }
                else if(jPoints == iPoints)
                {
                    if(jGoals < iGoals)
                    {
                        temp = teamList[j];
                        teamList[j] = teamList[i];
                        teamList[i] = temp;
                    }

                    else 
                    {
                        RandomGoalsGenerator random = new RandomGoalsGenerator();
                        random.setMin(0);
                        random.setMax(10);
                        int number = (int)random.randomNumber();
                        if ((number % 2) == 0)
                        {
                            temp = teamList[j];
                            teamList[j] = teamList[i];
                            teamList[i] = temp;
                        }
                    }
                }
            }
        }
    }   

    /**
     * starting point of game
     * 
     */
    public void startGameFootball()
    {
        teamRankSet();
        playerNames();
       // menuhandle();
        rankSort();
        preliminary();
        playFinal();
        printGoldenBoot();
        printFairPlay();
        writeFile();       
    }

    /**
     * reads from file and set rank of team
     *
     */ 
    public void teamRankSet()
    {
        String fileName = "teams.txt";
        try
        {
            FileReader inputFile = new FileReader(fileName);
            int i = 0;
            try
            {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine())
                {
                    String name = parser.nextLine();
                    String[] list = name.split(",");
                    teamList[i] = new Team(list[0],list[1]);
                    i = i + 1;
                }        
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(fileName + " not found");
        }
        catch(ArrayIndexOutOfBoundsException exception)
        {
            System.out.println(exception); 
        }        
        catch(IOException exception)
        {
            System.out.println("unexpected I/O error occured");
        }
    }

    /**
     * breaks tie when penatly shoot out is also tie
     *
     */
    public Team tieBreaker()
    {
        int tie = 1;
        Team team  = new Team();
        while (tie == 1)
        {
            int goal1 = 0;
            int goal2 = 0;
            boolean shoot1 =  teamList[0].shoot();
            if(shoot1 == true)
                goal1 = goal1 +1;        
            boolean shoot2 =  teamList[1].shoot();
            if(shoot2 == true)
                goal2 = goal2 + 1;       
            if(goal1 > goal2) 
            {
                team =  teamList[0];            
            }
            else 
            {
                team = teamList[1];
            }
        }
        return team;
    }

    /**
     * Write to statistics file at end of game
     *
     */
    public void writeFile()
    {
        if(finalDone == 1 )
        {
            System.out.println("---------------------");
            System.out.println("Winner not yet decided");
            System.out.println("---------------------");
        }
        else
        {
            try
            {
                String filename = "statistics.txt";
                FileWriter outputfile = new FileWriter(new File(filename));
                try
                {
                    sortTeam();
                    outputfile.write("Team\t\tPlayed\t\tWon\t\tLost\t\tDrawn\t\tGoals\t\tPoints\t\tFair Play Score" + "\r\n");
                    for(int i = 0;i < teamList.length ;i++)
                    {
                        outputfile.write(teamList[i].getName() + "\t\t" + teamList[i].getScoreDetail(0) + "\t\t" + teamList[i].getScoreDetail(1) + "\t\t" + teamList[i].getScoreDetail(3) 
                            + "\t\t" + teamList[i].getScoreDetail(2) + "\t\t" + teamList[i].getScoreDetail(5) + "\t\t" + teamList[i].getScoreDetail(4) + "\t\t" +
                            teamList[i].getScoreDetail(9) + "\r\n");
                    } 
                } 
                finally 
                {
                    outputfile.close();
                }
            }
            catch(IOException e) 
            {
                System.out.println("Error with file");
            }
        }
    }

    public void menuhandle()
    {
        Menu menu = new Menu();
        String choice = "";
        while(!choice.equals("X"))
        {    
        choice = menu.menuShow();
        if (choice.equals("A"))
            preliminary();
        else if (choice.equals("B"))
            playFinal();
        else if (choice.equals("C"))
            displayTeams();
        else if (choice.equals("D"))
            displayPlayers();
        else if (choice.equals("E"))
            displayCupResult();
        }  
        if (choice .equals("X"))
            writeFile();
    }
}

