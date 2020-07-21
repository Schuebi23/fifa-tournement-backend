package com.example.fifatournement.service;

import com.example.fifatournement.model.Supporter;
import com.example.fifatournement.repository.ISupporterRepository;
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
        return supporterRepository.findById(supporterId).orElseThrow(() -> new RuntimeException());
    }
}
