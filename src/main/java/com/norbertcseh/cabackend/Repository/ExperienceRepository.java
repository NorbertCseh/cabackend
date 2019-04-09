package com.norbertcseh.cabackend.Repository;

import java.util.List;

import com.norbertcseh.cabackend.Entity.Experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    List<Experience> findAllByUserId(Long userId);

    Experience deleteExperienceById(Long id);
}