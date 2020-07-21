package com.example.fifatournement.controller;


import com.example.fifatournement.model.Supporter;
import com.example.fifatournement.service.SupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fifa-tournement")
@CrossOrigin(origins = "*")
public class SupporterController {

    @Autowired
    SupporterService supporterService;

    //    Get all Students
    @GetMapping("/supporters")
    public List<Supporter> getSupporters(){
        return supporterService.getSupporters();
    }

    // Get a specific User
    @GetMapping("/supporter/{supporterId}")
    public Supporter getSupporter(
            @PathVariable Integer supporterId){
        return supporterService.getSupporter(supporterId);
    }

}
