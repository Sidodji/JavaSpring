package com.example.project.service;

import com.example.project.entity.Athletes;
import com.example.project.repository.AthletesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthletesService {
    @Autowired
    private AthletesRepository athletesRepository;

    public Athletes addAthlete(Athletes athlete) {
        return athletesRepository.saveAndFlush(athlete);
    }

    public void delete(Long id) {
        athletesRepository.deleteById(id);
    }

    public Athletes getByName(String name) {
        return athletesRepository.findByName(name);
    }

    public Athletes editAthlete(Athletes athlete) {
        return athletesRepository.saveAndFlush(athlete);
    }

    public List<Athletes> getAll() {
        return athletesRepository.findAll();
    }

    public Athletes findById(long id) {
        return athletesRepository.findById(id).get();
    }
}
