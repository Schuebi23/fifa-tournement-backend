package com.example.fifatournement.repository;

import com.example.fifatournement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberRepository extends JpaRepository<Member, Integer> {
    Member findById(int member_id);

}
