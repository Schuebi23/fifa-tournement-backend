package com.example.fifatournament.service;

import com.example.fifatournament.model.Supporter;
import com.example.fifatournament.repository.ISupporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupporterService {

    @Autowired
    ISupporterRepository supporterRepository;

    //    Get All Supporter Clubs
    public List<Supporter> getSupporters(){
        return supporterRepository.findAll();
    }

    //  Get a specific Supporter Club
    public Supporter getSupporter(Integer supporterId){
        return supporterRepository.findById(supporterId).orElseThrow(() -> new RuntimeException("Error loading supporter Club"));
    }

    // delete a Supporter club
    public void deleteSupporter(Integer supporterId){
       supporterRepository.deleteById(supporterId);
    }

    // add a club
    public Supporter addSupporter(Supporter supporter){
        return supporterRepository.save(supporter);
    }
}
