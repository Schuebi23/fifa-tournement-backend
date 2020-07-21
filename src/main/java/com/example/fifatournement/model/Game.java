package com.example.fifatournement.model;


import javax.persistence.*;


@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int score_home;
    private int score_away;
    private String team_home;

    private String team_away;


   public Game(int score_home, int score_away, String team_home, String team_away){
       this.score_home = score_home;
       this.score_away = score_away;
       this.team_home = team_home;
       this.team_away = team_away;
   }

    public Game() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getScore_home() {
        return score_home;
    }

    public void setScore_home(int score_home) {
        this.score_home = score_home;
    }

    public int getScore_away() {
        return score_away;
    }

    public void setScore_away(int score_away) {
        this.score_away = score_away;
    }

    public String getTeam_home() {
        return team_home;
    }

    public void setTeam_home(String team_home) {
        this.team_home = team_home;
    }

    public String getTeam_away() {
        return team_away;
    }

    public void setTeam_away(String team_away) {
        this.team_away = team_away;
    }

}