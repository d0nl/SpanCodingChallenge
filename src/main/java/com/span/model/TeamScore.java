package com.span.model;

public class TeamScore {
    private String teamName;
    private int teamScore;
    private int matchPoints;

    public TeamScore(String teamName, int teamScore) {
        this.teamName = teamName;
        this.teamScore = teamScore;
        this.matchPoints = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public void setMatchPoints(int matchPoints) {
        this.matchPoints = matchPoints;
    }
}
