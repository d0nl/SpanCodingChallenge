package com.span.league;

import com.span.main.LeagueRank;
import com.span.model.TeamScore;

import java.util.ArrayList;
import java.util.List;

public class LeagueStdInInputStream extends LeagueInputStream {

    @Override
    public List<String> getInputLines() {
        return null;
    }

    @Override
    public String getNextInputLine() {
        return null;
    }

    @Override
    public int getInputLinesLength() {
        return 0;
    }

    /*@Override
    public int writeOutputStream(ArrayList<TeamScore> list) {
        list.forEach(s -> System.out.println(s.getTeamName()
                + ", "
                + s.getTeamScore()
                + " "
                + (s.getTeamScore() == 1 ? "pt" : "pts"))
        );

        return LeagueRank.STATUS_OK;
    }*/
}
