package com.example.fifatournement.model;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "supporter_id", nullable = true)
    private Supporter supporter;

    private String first_name;
    private String last_name;
    private String nickname;

    public Member(Supporter supporter, String first_name, String last_name, String nickname){
        this.supporter = supporter;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Member() {
    }

    public Supporter getSupporter() {
        return supporter;
    }

    public void setSupporter(Supporter supporter) {
        this.supporter = supporter;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
