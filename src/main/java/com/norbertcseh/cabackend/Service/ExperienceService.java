package com.norbertcseh.cabackend.Service;

import java.util.List;

import com.norbertcseh.cabackend.Entity.Experience;
import com.norbertcseh.cabackend.Repository.ExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    private ExperienceRepository expRepo;

    @Autowired
    public void setExpRepo(ExperienceRepository expRepo) {
        this.expRepo = expRepo;
    }

    public List<Experience> findAllByUserId(Long userId) {
        return expRepo.findAllByUserId(userId);
    }

    public Experience deleteExperienceById(Long id) {
        return expRepo.deleteExperienceById(id);
    }

}