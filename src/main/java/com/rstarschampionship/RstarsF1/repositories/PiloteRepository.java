package com.rstarschampionship.RstarsF1.repositories;

import com.rstarschampionship.RstarsF1.entity.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PiloteRepository extends JpaRepository<Pilote, Long> {


    Optional<Pilote> findById(Long id);
}
