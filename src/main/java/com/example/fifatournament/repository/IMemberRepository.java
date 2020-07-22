package com.example.fifatournament.repository;

import com.example.fifatournament.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberRepository extends JpaRepository<Member, Integer> {
    Member findById(int member_id);

}
