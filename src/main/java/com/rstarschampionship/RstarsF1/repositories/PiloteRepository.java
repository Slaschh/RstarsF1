package com.rstarschampionship.RstarsF1.repositories;

import com.rstarschampionship.RstarsF1.entity.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PiloteRepository extends JpaRepository <Pilote, Long>
{
    List<Pilote> findById_pilote(Long id_pilote);

}
