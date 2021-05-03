package com.bachhs.flashticket.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedBy;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie_id;

    @OneToOne
    @JoinColumn(name = "concert_id")
    private Concert concert_id;

    @OneToOne
    @JoinColumn(name = "sport_id")
    private Sport sport_id;

    private String type;

    private String position;

    private Instant date;

    @CreatedBy
    @OneToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Seat() {
    }

    public Seat(Long id, Movie movie_id, Concert concert_id, Sport sport_id, String type, String position, Instant date,
            User owner) {
        this.id = id;
        this.movie_id = movie_id;
        this.concert_id = concert_id;
        this.sport_id = sport_id;
        this.type = type;
        this.position = position;
        this.date = date;
        this.owner = owner;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie_id() {
        return this.movie_id;
    }

    public void setMovie_id(Movie movie_id) {
        this.movie_id = movie_id;
    }

    public Concert getConcert_id() {
        return this.concert_id;
    }

    public void setConcert_id(Concert concert_id) {
        this.concert_id = concert_id;
    }

    public Sport getSport_id() {
        return this.sport_id;
    }

    public void setSport_id(Sport sport_id) {
        this.sport_id = sport_id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Instant getDate() {
        return this.date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}