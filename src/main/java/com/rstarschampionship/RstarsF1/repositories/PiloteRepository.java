package com.rstarschampionship.RstarsF1.repositories;

import com.rstarschampionship.RstarsF1.entity.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiloteRepository extends JpaRepository<Pilote, Long> {

}
