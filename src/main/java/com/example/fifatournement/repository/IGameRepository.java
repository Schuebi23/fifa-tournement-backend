package com.example.fifatournement.repository;

import com.example.fifatournement.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<Game, Integer> {
    Game findById(int game_id);

}
