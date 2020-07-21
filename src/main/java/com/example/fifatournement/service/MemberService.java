package com.example.fifatournement.service;

import com.example.fifatournement.model.Member;
import com.example.fifatournement.model.Supporter;
import com.example.fifatournement.repository.IMemberRepository;
import com.example.fifatournement.repository.ISupporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    IMemberRepository memberRepository;

    //    Get All members
    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    //  Get a specific member
    public Member getMember(Integer memberId){
        return memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException());
    }

    // delete a member
    public void deleteMember(Integer memberId){
       memberRepository.deleteById(memberId);
    }

    // add a member
    public Member addMember(Member member){
        return memberRepository.save(member);
    }
}
