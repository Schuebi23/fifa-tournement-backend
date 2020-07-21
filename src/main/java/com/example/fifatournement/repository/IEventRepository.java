package com.example.fifatournement.repository;

import com.example.fifatournement.model.Event;
import com.example.fifatournement.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepository extends JpaRepository<Event, Integer> {
    Event findById(int game_id);

}
