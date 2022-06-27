package com.span.model;

public class GameResult {

    TeamScore teamA;
    TeamScore teamB;

    public GameResult(TeamScore teamA, TeamScore teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public void calculateScores(){
        int score1 = this.teamA.getTeamScore();
        int score2 = this.teamB.getTeamScore();
        int points1 = 0;
        int points2 = 0;
        if(score1 == score2){
            //Draw
            points1 = 1;
            points2 = 1;
        } else {
            points1 = score1 > score2 ? 3 : 0;
            points2 = score2 > score1 ? 3 : 0;
        }

        this.teamA.setMatchPoints(points1);
        this.teamB.setMatchPoints(points2);

    }

    public TeamScore getTeamA() {
        return teamA;
    }

    public void setTeamA(TeamScore teamA) {
        this.teamA = teamA;
    }

    public TeamScore getTeamB() {
        return teamB;
    }

    public void setTeamB(TeamScore teamB) {
        this.teamB = teamB;
    }
}
