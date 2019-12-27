package com.rstarschampionship.RstarsF1.repositories;

import com.rstarschampionship.RstarsF1.entity.UserSecu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserSecuRepository extends JpaRepository<UserSecu, Long> {

@Query(" select u from UserSecu u " +        " where u.username = ?1")
Optional<UserSecu> findUserWithName(String username);


 Optional<UserSecu> findByEmail(String email);
}
