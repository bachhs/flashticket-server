package com.bachhs.flashticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bachhs.flashticket.model.TeamSport;

@Repository
public interface TeamRepository extends JpaRepository<TeamSport, Long> {
}
