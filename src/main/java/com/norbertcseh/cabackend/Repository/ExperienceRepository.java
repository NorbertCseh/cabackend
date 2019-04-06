package com.norbertcseh.cabackend.Repository;

import com.norbertcseh.cabackend.Entity.Experience;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    Experience findByUserId(Long userId);

}