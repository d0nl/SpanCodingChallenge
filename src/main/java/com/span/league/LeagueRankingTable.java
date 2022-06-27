package com.span.league;

import com.span.main.LeagueRank;
import com.span.model.GameResult;
import com.span.model.TeamScore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;

/**
 * Produces a ranking table of games in a league
 * @author Don Lewis-Enright
 */
public class LeagueRankingTable {

    private LeagueInputStream leagueInputStream = null;

    public LeagueRankingTable(LeagueInputStream leagueInputStream){
        this.leagueInputStream = leagueInputStream;
    }

    public int processStream(){
        int statusCode = leagueInputStream.initInputLines();
        if(statusCode == LeagueRank.STATUS_OK){
            ArrayList<TeamScore> list = calculateTeamRankings();
            statusCode = leagueInputStream.writeOutputStream(list);
        }

        return statusCode;
    }

    private final Hashtable<String, Integer> teamScoreHash = new Hashtable<String, Integer>();

    public ArrayList<TeamScore> calculateTeamRankings(){

        String[] teamValues = new String[2];
        TeamScore[] teamScore = new TeamScore[2];

        while(leagueInputStream.hasMoreLines()) {
            String line = leagueInputStream.getNextInputLine();

            int index = line.indexOf(",");
            teamValues[0] = line.substring(0, index).trim();
            teamValues[1] = line.substring(index+1).trim();

            //Process team scores
            for(int i=0;i<2;i++) {
                index = teamValues[i].lastIndexOf(" ");
                String key = teamValues[i].substring(0, index);
                int value = Integer.parseInt(teamValues[i].substring(index + 1));
                teamScore[i] = new TeamScore(key, value);
            }

            GameResult gameResult = new GameResult(teamScore[0], teamScore[1]);
            gameResult.calculateScores();

            //Update team points
            for(int i=0;i<2;i++) {
                if (teamScoreHash.containsKey(teamScore[i].getTeamName())) {
                    int points = teamScoreHash.get(teamScore[i].getTeamName());
                    teamScoreHash.put(teamScore[i].getTeamName(), teamScore[i].getMatchPoints() + points);
                } else {
                    teamScoreHash.put(teamScore[i].getTeamName(), teamScore[i].getMatchPoints());
                }
            }

        }

        //Add team scores to an ArrayList for sorting
        ArrayList<TeamScore> list = new ArrayList<TeamScore>();
        teamScoreHash.forEach((s, v) -> list.add(new TeamScore(s,v)));
        //Comparator to sort by name for scores that are equal
        Comparator<TeamScore> byName = Comparator.comparing(TeamScore::getTeamName);
        //Sort the list by score, then by name for scores that are the same
        list.sort(Comparator.comparing(TeamScore::getTeamScore)
                .reversed().
                thenComparing(byName));

        return list;
    }

}
