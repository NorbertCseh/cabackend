package com.norbertcseh.cabackend.Repository;

import com.norbertcseh.cabackend.Entity.Education;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {

    Education findByUserId(Long userId);

}