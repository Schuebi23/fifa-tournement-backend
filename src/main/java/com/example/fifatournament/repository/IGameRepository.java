package com.example.fifatournament.repository;

import com.example.fifatournament.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGameRepository extends JpaRepository<Game, Integer> {
   @Query("SELECT g FROM Game g WHERE g.event.id = ?1")
   List<Game> findByEventId(Integer eventId);


}
