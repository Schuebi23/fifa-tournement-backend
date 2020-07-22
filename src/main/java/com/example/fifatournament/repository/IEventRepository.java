package com.example.fifatournament.repository;

import com.example.fifatournament.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepository extends JpaRepository<Event, Integer> {
    Event findById(int game_id);

}
