package com.span.model;

public class TeamScore {
    private String teamAName;
    private int teamAScore;

    public TeamScore(String teamAName, int teamAScore) {
        this.teamAName = teamAName;
        this.teamAScore = teamAScore;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }
}
