package com.example.fifatournament.service;

import com.example.fifatournament.repository.IMemberRepository;
import com.example.fifatournament.model.Member;
import com.example.fifatournament.repository.ISupporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    IMemberRepository memberRepository;
    @Autowired
    ISupporterRepository supporterRepository;

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
    public Member addMember(Integer supporterId, Member member){
       return supporterRepository.findById(supporterId).map(supporter -> {
            member.setSupporter(supporter);
            return memberRepository.save(member);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + supporterId + " not found"));

    }
}