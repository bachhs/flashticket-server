package com.bachhs.flashticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bachhs.flashticket.model.Name;

@Repository
public interface NameRepository extends JpaRepository<Name, Long> {
}
