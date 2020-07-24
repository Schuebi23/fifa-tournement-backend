package com.example.fifatournament.service;

import com.example.fifatournament.model.Event;
import com.example.fifatournament.model.Game;
import com.example.fifatournament.repository.IEventRepository;
import com.example.fifatournament.repository.IGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    IGameRepository gameRepository;
    @Autowired
    IEventRepository eventRepository;

    //    Get All Games
    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    public List<Game> getGamesByEvent(Integer eventId){
        return gameRepository.findByEventId(eventId);
    }
    //  Get a specific game
    public Game getGame(Integer gameId){
        return gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException());
    }

    // delete a game
    public void deleteGame(Integer gameId){
       gameRepository.deleteById(gameId);
    }

    // add a game
    public Game addGame(Game game, Integer eventId){
        return eventRepository.findById(eventId).map(event -> {
            game.setEvent(event);
            return gameRepository.save(game);
        }).orElseThrow(() -> new ResourceNotFoundException("EventId: " + eventId + " not found"));
    }

    public Game updateGame(Integer gameId, Game updatedGame){
        return gameRepository.findById(gameId).map(foundGame -> {
            foundGame.setScore_away(updatedGame.getScore_away());
            foundGame.setScore_home(updatedGame.getScore_home());
            foundGame.setTeam_away(updatedGame.getTeam_away());
            foundGame.setTeam_home(updatedGame.getTeam_home());
            return gameRepository.save(foundGame);
        }).orElseThrow(() -> new RuntimeException());
    }


}
