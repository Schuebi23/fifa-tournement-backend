package com.example.fifatournament.service;

import com.example.fifatournament.model.Event;
import com.example.fifatournament.repository.IEventRepository;
import com.example.fifatournament.repository.ISupporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    IEventRepository eventRepository;
    @Autowired
    ISupporterRepository supporterRepository;

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

    public Event updateEvent(Integer eventId, Event updatedEvent){
        return eventRepository.findById(eventId).map(foundEvent -> {
            foundEvent.setMember_away(updatedEvent.getMember_away());
            foundEvent.setMember_home(updatedEvent.getMember_home());
            foundEvent.setSupporter_away(updatedEvent.getSupporter_away());
            foundEvent.setSupporter_home(updatedEvent.getSupporter_home());
            foundEvent.setName(updatedEvent.getName());
            return eventRepository.save(foundEvent);
        }).orElseThrow(() -> new RuntimeException());
    }
}
