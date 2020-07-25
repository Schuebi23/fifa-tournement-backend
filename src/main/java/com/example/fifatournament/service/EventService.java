package com.example.fifatournament.service;

import com.example.fifatournament.model.Event;
import com.example.fifatournament.model.Game;
import com.example.fifatournament.repository.IEventRepository;
import com.example.fifatournament.repository.IGameRepository;
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
    @Autowired
    GameService gameService;

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
        List<Game> games = this.gameService.getGames();
        for (Game game: games) {
            if(game.getEvent().getId() == eventId){
                this.gameService.deleteGame(game.getId());
            }
        }
        eventRepository.deleteById(eventId);
    }

    // add a event
    public Event addEvent(Event event){
        return supporterRepository.findById(event.getSupporter_home().getId()).map(supporter -> {
            event.setSupporter_home(supporter);
            return supporterRepository.findById(event.getSupporter_away().getId()).map(sup_away -> {
                event.setSupporter_away(sup_away);
                return eventRepository.save(event);
            }).orElseThrow(() -> new RuntimeException("could not find supporter with Id" + event.getSupporter_away().getId()));
        }).orElseThrow(() -> new RuntimeException("could not find supporter with Id" + event.getSupporter_home().getId()));
    }

    public Event updateEvent(Integer eventId, Event updatedEvent){
        return eventRepository.findById(eventId).map(foundEvent -> {
            foundEvent.setMember_away(updatedEvent.getMember_away());
            foundEvent.setMember_home(updatedEvent.getMember_home());
            foundEvent.setSupporter_away(updatedEvent.getSupporter_away());
            foundEvent.setSupporter_home(updatedEvent.getSupporter_home());
            foundEvent.setName(updatedEvent.getName());
            foundEvent.setNumberOfShots_home(updatedEvent.getNumberOfShots_home());
            return eventRepository.save(foundEvent);
        }).orElseThrow(() -> new RuntimeException());
    }
}
