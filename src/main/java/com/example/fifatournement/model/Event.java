package com.example.fifatournement.model;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String member_home;
    private String member_away;


    @ManyToOne
    @JoinColumn(name = "supporter_home_id", nullable = true)
    private Supporter supporter_home;
    @ManyToOne
    @JoinColumn(name = "supporter_away_id", nullable = true)
    private Supporter supporter_away;

    public Event(String member_home, String member_away, Supporter supporter_home, Supporter supporter_away) {
        this.member_home = member_home;
        this.member_away = member_away;
        this.supporter_home = supporter_home;
        this.supporter_away = supporter_away;

    }

    public Event() {
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
}
