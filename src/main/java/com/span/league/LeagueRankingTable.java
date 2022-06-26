package com.span.league;

import com.span.main.LeagueRank;
import com.span.model.GameResult;

import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 * Produces a ranking table of games in a league
 *
 */
public class LeagueRankingTable {

    private LeagueInputStream leagueInputStream = null;

    public LeagueRankingTable(LeagueInputStream leagueInputStream){
        this.leagueInputStream = leagueInputStream;
    }

    public int go(){
        int statusCode = leagueInputStream.initInputLines();
        if(statusCode == LeagueRank.STATUS_OK){
            buildHashMap();
        }

        return statusCode;
    }

    private Hashtable<String, GameResult> hashTable = new Hashtable<String, GameResult>();

    private void buildHashMap(){

        String teamValues[] = new String[2];

        while(leagueInputStream.hasMoreLines()) {
            String line = leagueInputStream.getNextInputLine();

            int index = line.indexOf(",");
            teamValues[0] = line.substring(0, index).trim();
            teamValues[1] = line.substring(index+1).trim();

            //Process teamA
            for(int i=0;i<2;i++) {
                index = teamValues[i].lastIndexOf(" ");
                String key = teamValues[i].substring(0, index);
                int value = Integer.valueOf(teamValues[i].substring(index + 1));

            }

            hashTable.forEach((s, v) -> System.out.println(s + "=" + v));

        }
    }

}
