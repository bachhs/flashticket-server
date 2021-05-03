package com.bachhs.flashticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bachhs.flashticket.model.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
}
