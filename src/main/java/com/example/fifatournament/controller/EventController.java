package com.example.fifatournament.controller;

import com.example.fifatournament.model.Event;
import com.example.fifatournament.service.EventService;
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

    // delete an Event
    @DeleteMapping("/event/{eventId}")
    public void deleteEvent(
            @PathVariable Integer eventId) {
         eventService.deleteEvent(eventId);
    }

    @PutMapping("/event/{eventId}")
    public void updateEvent(@PathVariable Integer eventId,  @RequestBody Event event){
        eventService.updateEvent(eventId, event);
    }

}
