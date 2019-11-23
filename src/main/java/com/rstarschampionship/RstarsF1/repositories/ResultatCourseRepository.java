package com.rstarschampionship.RstarsF1.repositories;

import com.rstarschampionship.RstarsF1.entity.ResultatCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultatCourseRepository extends JpaRepository<ResultatCourse, Long> {

}
