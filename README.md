# FootballWC
# System description
The Football World Cup is played between 4 teams. The teams are ranked from 1 to 4, with 1 indicating the highest ranking and 4 the lowest.
The Cup is played in two stages: Preliminary and Final.
<br/>
During the Preliminary stage, each team plays the other three teams resulting in a total of six (6)games played. The games during the Preliminary stage occur sequentially and the result of each game is shown on the screen as it is completed. In the Preliminary stage a team gains 3 points for a win, 1 point for a draw, and 0 points for a loss.
At the end of the Preliminary stage the system will display a summary of the results with the teams sorted from first to last, based on the following criteria:
<br/>
• The teams will be listed from most to least points.
<br/>
• If teams have the same points, then the team with the higher number of goals scored will
be placed higher on the table.
<br/>
• If teams cannot be separated by any of the previous criteria, then the higher placing in the
table will be determined randomly.
<br/>
After the Preliminary stage is completed, the top two teams play in the Final. The only difference
between the final and the preliminary games is that the final must have a winner, the Football
World Cup Champions!
<br/>
At the end of the Final the overall results are displayed on the screen, including the name of the
Football World Cup champion team, the Golden Boot Award player, and the Fair Play Award
team.

# System Interface
When the program starts, the system reads the details of each team from file called ‘teams.txt’.
The details include each team’s name and ranking. Once the information is loaded from the file
there is no more reading or writing to the file during the actual running of the program.
The program then prompts the user for the names of two players in each team who will be the goal
scorers. If the name entered is invalid then the user is prompted to re-enter. If the name re-entered
is invalid then a default value is allocated, e.g. player-1-Ghana
The system will then offer the user the following menu options and you must display a text based
menu that uses the Scanner class to obtain input from the keyboard:
A. Play Preliminary Stage
B. Play Final
C. Display Teams
D. Display Players
E. Display Cup Result
X. Close
<br/>
If the user chooses option ‘A’ the Preliminary stage will be played.
If the user chooses option ‘B’ the Final will be played between the top teams from the preliminary
stage, as previously described. If option ‘B’ is chosen but the Preliminary stage has not been
played an error message will be displayed. If the final ends in a draw then a penalty shoot-out is
played.
If the user chooses option ‘C’ the record of each team is displayed. For example:
 Played Won Lost Drawn Goals Points Fair Play Score
Australia 6 4 2 0 14 12 3
China 6 3 2 1 10 10 0
Ghana 6 3 2 1 9 10 0
Spain 6 2 4 0 6 6 4
If the user chooses option ‘D’ the players are listed with their number of goals scored. The list
does not need to be sorted in any order. For example:
Cahill (Australia) - 8
Rogic (Australia) - 6
Gao (China) - 7
Yu (China) - 3
………..
……….
If the user chooses option ‘E’ the name of the Football World Cup champion team, the Golden
Boot Award player, and the Fair Play Award team will be displayed to screen. For example:
Football World Cup Winner: Australia
Golden Boot Award: Ronaldo from Spain
Fair Play Award: Ghana and China
Note that there can be multiple players that win the Golden Boot Award and there can be multiple
teams that win the Fair Play Award.
After menu item A to E, the menu is re-displayed on the screen.
If the user chooses option ‘X’, the system should write the same information shown when option
‘E’ is chosen to a file called ‘statistics.txt’. The system will then close.
