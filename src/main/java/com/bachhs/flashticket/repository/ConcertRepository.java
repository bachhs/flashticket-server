package com.bachhs.flashticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bachhs.flashticket.model.Concert;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
