package com.example.fifatournament.controller;

import com.example.fifatournament.model.Game;
import com.example.fifatournament.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fifa-tournement")
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    GameService gameService;


    //    Get all Clubs
    @GetMapping("/games")
    public List<Game> getGames(){
        return gameService.getGames();
    }

    // Get a specific Club
    @GetMapping("/game/{gameId}")
    public Game getGame(
            @PathVariable Integer gameId){
        return gameService.getGame(gameId);
    }

    // delete a member
    @DeleteMapping("/game/{gameId}")
    public void deleteGame(
            @PathVariable Integer gameId) {
         gameService.deleteGame(gameId);
    }

    @PostMapping("/game/{eventId}/add")
    public Game addGame(@PathVariable Integer eventId ,@Valid @RequestBody Game game) {
                    return gameService.addGame(game);
    }
}