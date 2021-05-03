package com.bachhs.flashticket.model;

import java.time.Instant;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String poster;

    private Integer duration;

    private String description;

    private Instant openingDay;

    @ManyToMany
    @JoinTable(name = "movie_director", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "name_id"))
    private Set<Name> directors;

    @ManyToMany
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "name_id"))
    private Set<Name> actors;

    @CreatedBy
    @OneToOne
    @JoinColumn(name = "created_by")
    private User user;

    @CreatedDate
    private Instant createdDate;

    public Movie() {

    }

    public Movie(Long id, String title, String poster, Integer duration, String description, Instant openingDay,
            Set<Name> directors, Set<Name> actors, User user, Instant createdDate) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.duration = duration;
        this.description = description;
        this.openingDay = openingDay;
        this.directors = directors;
        this.actors = actors;
        this.user = user;
        this.createdDate = createdDate;
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

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getOpeningDay() {
        return this.openingDay;
    }

    public void setOpeningDay(Instant openingDay) {
        this.openingDay = openingDay;
    }

    public Set<Name> getDirectors() {
        return this.directors;
    }

    public void setDirectors(Set<Name> directors) {
        this.directors = directors;
    }

    public Set<Name> getActors() {
        return this.actors;
    }

    public void setActors(Set<Name> actors) {
        this.actors = actors;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

}