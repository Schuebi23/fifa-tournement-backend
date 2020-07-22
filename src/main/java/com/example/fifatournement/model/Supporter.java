package com.example.fifatournement.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supporter")
public class Supporter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    private int numberOfShots;

    @OneToMany(mappedBy = "supporter")
    private List<Member> members;

    public Supporter(@NotNull String name, int numberOfShots){
        this.name = name;
        this.numberOfShots = numberOfShots;
    }

    public Supporter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public void setNumberOfShots(int numberOfShots) {
        this.numberOfShots = numberOfShots;
    }


}
