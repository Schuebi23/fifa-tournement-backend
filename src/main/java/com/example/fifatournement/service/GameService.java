package com.example.fifatournement.service;

import com.example.fifatournement.model.Game;
import com.example.fifatournement.model.Member;
import com.example.fifatournement.repository.IGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    IGameRepository gameRepository;

    //    Get All members
    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    //  Get a specific member
    public Game getGame(Integer gameId){
        return gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException());
    }

    // delete a member
    public void deleteGame(Integer gameId){
       gameRepository.deleteById(gameId);
    }

    // add a member
    public Game addGame(Game game){
        return gameRepository.save(game);
    }
}
