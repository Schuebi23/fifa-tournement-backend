package com.example.fifatournement.service;

import com.example.fifatournement.model.Event;
import com.example.fifatournement.model.Game;
import com.example.fifatournement.repository.IEventRepository;
import com.example.fifatournement.repository.IGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    IEventRepository eventRepository;

    //    Get All Events
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    //  Get a specific event
    public Event getEvent(Integer eventId){
        return eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException());
    }

    // delete a event
    public void deleteEvent(Integer eventId){
       eventRepository.deleteById(eventId);
    }

    // add a event
    public Event addEvent(Event event){
        return eventRepository.save(event);
    }
}
