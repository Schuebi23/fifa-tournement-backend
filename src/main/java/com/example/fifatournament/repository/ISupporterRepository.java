package com.example.fifatournament.repository;

import com.example.fifatournament.model.Supporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupporterRepository extends JpaRepository<Supporter, Integer> {
}
