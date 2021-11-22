package com.capstone.backend.data.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teams")
public class Team {
    @Id @GeneratedValue
    private Long teamId;
    @Getter @Setter
    private String teamName;
    @Getter @OneToMany(cascade = CascadeType.DETACH)
    private List<User> teamMembers;


    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
