package com.span.league;

import com.span.main.LeagueRank;
import com.span.model.TeamScore;

import java.util.ArrayList;

public class LeagueFileInputStream extends LeagueInputStream {
    private String inputFileName;
    private String outputFileName;

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }



   /* @Override
    public int writeOutputStream(ArrayList<TeamScore> list) {
        list.forEach(s -> System.out.println(s.getTeamName()
                + ", "
                + s.getTeamScore()
                + " "
                + (s.getTeamScore() == 1 ? "pt" : "pts"))
        );

        return LeagueRank.STATUS_OK;
    }

    */
}
