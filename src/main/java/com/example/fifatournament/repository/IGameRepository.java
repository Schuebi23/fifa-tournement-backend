package com.example.fifatournament.repository;

import com.example.fifatournament.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<Game, Integer> {
    Game findById(int game_id);

}
