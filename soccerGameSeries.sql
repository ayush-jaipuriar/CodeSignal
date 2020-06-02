/*

You have a table scores that  contains information about a series of soccer games. Your goal is to determine the winner of the series. A team is declared the winner if it won more games than the other team. If both teams had the same number of wins, then the winner is determined by the better goal difference (the difference between the goals that a team scores and the goals that the opposing team scores on them over all the games). If the goal differences are equal, the winner is the team that scored more goals during away games (i.e. games when it was not the host team). The result is the index of the winning team. If the above criteria are not sufficient for determining the winner, return 0.

The scores table contains the following columns:

match_id - the unique ID of the match;
first_team_score - the score of the 1st team in the current match;
second_team_score - the score of the 2nd team in the current match;
match_host - the team that is the host of the match (can be 1 or 2).
Your task is to write a select statement which returns a single column winner, which can contain 1, 2, or 0.

Example

For given table scores

match_id	first_team_score	second_team_score	match_host
1	3	2	1
2	2	1	2
3	1	2	1
4	2	1	2
the output should be

winner
1
The first team won 3 games out of 4, so it's the winner of the series.

[execution time limit] 10 seconds (mysql)
*/

/*Please add ; after each select statement*/
CREATE PROCEDURE soccerGameSeries()
BEGIN
	SELECT IF(first_team_wins > second_team_wins, 1, 
                      IF(second_team_wins > first_team_wins, 2, IF( 
                      first_team_goals > second_team_goals, 1, IF( 
         second_team_goals > first_team_goals 
         , 2, IF( 
         first_team_away_goals > second_team_away_goals 
         , 1, IF( 
         second_team_away_goals > 
         first_team_away_goals, 2, 0)))))) AS winner 
  FROM   (SELECT SUM(IF(first_team_score > second_team_score, 1, 0)) AS 
                 first_team_wins, 
                 SUM(IF(second_team_score > first_team_score, 1, 0)) AS 
                 second_team_wins, 
                 SUM(first_team_score)                               AS 
                 first_team_goals, 
                 SUM(second_team_score)                              AS 
                 second_team_goals 
                        , 
                 SUM(IF(match_host = 1, first_team_score, 0))        AS 
                        first_team_home_goals, 
                 SUM(IF(match_host = 2, first_team_score, 0))        AS 
                        first_team_away_goals, 
                 SUM(IF(match_host = 1, second_team_score, 0))       AS 
                        second_team_away_goals, 
                 SUM(IF(match_host = 2, second_team_score, 0))       AS 
                        second_team_home_goals 
          FROM   scores) AS results; 
END
