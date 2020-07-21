package com.example.fifatournement.repository;

import com.example.fifatournement.model.Supporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupporterRepository extends JpaRepository<Supporter, Integer> {
    Supporter findById(int supporter_id);

}
