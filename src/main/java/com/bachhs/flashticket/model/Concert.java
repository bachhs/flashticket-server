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
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Instant openingDay;

    @ManyToMany
    @JoinTable(name = "concert_name", joinColumns = @JoinColumn(name = "concert_id"), inverseJoinColumns = @JoinColumn(name = "name_id"))
    private Set<Name> artists;

    private String poster;

    public Concert() {
    }

    public Concert(Long id, String title, Instant openingDay, Set<Name> artists, String poster) {
        this.id = id;
        this.title = title;
        this.openingDay = openingDay;
        this.artists = artists;
        this.poster = poster;
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

    public Instant getOpeningDay() {
        return this.openingDay;
    }

    public void setOpeningDay(Instant openingDay) {
        this.openingDay = openingDay;
    }

    public Set<Name> getArtists() {
        return this.artists;
    }

    public void setArtists(Set<Name> artists) {
        this.artists = artists;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
