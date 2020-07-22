package com.example.fifatournement.controller;

import com.example.fifatournement.model.Event;
import com.example.fifatournement.model.Game;
import com.example.fifatournement.service.EventService;
import com.example.fifatournement.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fifa-tournement")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    EventService eventService;


    //    Get all Clubs
    @GetMapping("/events")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    // Get a specific Club
    @GetMapping("/event/{eventId}")
    public Event getEvent(
            @PathVariable Integer eventId){
        return eventService.getEvent(eventId);
    }

    // delete a member
    @DeleteMapping("/event/{eventId}")
    public void deleteGame(
            @PathVariable Integer eventId) {
         eventService.deleteEvent(eventId);
    }

}
