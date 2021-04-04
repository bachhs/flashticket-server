package com.bachhs.flashticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bachhs.flashticket.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
