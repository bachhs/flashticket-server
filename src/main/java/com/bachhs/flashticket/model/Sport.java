package com.bachhs.flashticket.model;

import java.time.Instant;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String poster;

    private String league;

    private String round;

    private Instant time;

    @ManyToMany
    @JoinTable(name = "sport_team", joinColumns = @JoinColumn(name = "sport_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<TeamSport> teams;

    private String stadium;

    public Sport() {
    }

    public Sport(Long id, String title, String poster, String league, String round, Instant time, Set<TeamSport> teams,
            String stadium) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.league = league;
        this.round = round;
        this.time = time;
        this.teams = teams;
        this.stadium = stadium;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getLeague() {
        return this.league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getRound() {
        return this.round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Instant getTime() {
        return this.time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Set<TeamSport> getTeams() {
        return this.teams;
    }

    public void setTeams(Set<TeamSport> teams) {
        this.teams = teams;
    }

    public String getStadium() {
        return this.stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

}
