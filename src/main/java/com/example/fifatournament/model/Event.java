package com.example.fifatournament.model;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String member_home;
    private String member_away;
    private String name;
    private int numberOfShots_home;
    private int numberOfShots_away;


    @ManyToOne
    @JoinColumn(name = "supporter_home_id", nullable = true)
    private Supporter supporter_home;
    @ManyToOne
    @JoinColumn(name = "supporter_away_id", nullable = true)
    private Supporter supporter_away;

    public Event(String member_home, String member_away, Supporter supporter_home, Supporter supporter_away, String name, int numberOfShots_home, int numberOfShots_away) {
        this.member_home = member_home;
        this.member_away = member_away;
        this.supporter_home = supporter_home;
        this.supporter_away = supporter_away;
        this.name = name;
        this.numberOfShots_home = numberOfShots_home;
        this.numberOfShots_away = numberOfShots_away;

    }

    public Event() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMember_home() {
        return member_home;
    }

    public void setMember_home(String member_home) {
        this.member_home = member_home;
    }

    public String getMember_away() {
        return member_away;
    }

    public void setMember_away(String member_away) {
        this.member_away = member_away;
    }

    public Supporter getSupporter_home() {
        return supporter_home;
    }

    public void setSupporter_home(Supporter supporter_home) {
        this.supporter_home = supporter_home;
    }

    public Supporter getSupporter_away() {
        return supporter_away;
    }

    public void setSupporter_away(Supporter supporter_away) {
        this.supporter_away = supporter_away;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfShots_home() {
        return numberOfShots_home;
    }

    public void setNumberOfShots_home(int numberOfShots_home) {
        this.numberOfShots_home = numberOfShots_home;
    }

    public int getNumberOfShots_away() {
        return numberOfShots_away;
    }

    public void setNumberOfShots_away(int numberOfShots_away) {
        this.numberOfShots_away = numberOfShots_away;
    }
}
