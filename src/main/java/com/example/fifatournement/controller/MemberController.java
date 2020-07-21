package com.example.fifatournement.controller;

import com.example.fifatournement.model.Member;
import com.example.fifatournement.model.Supporter;
import com.example.fifatournement.repository.IMemberRepository;
import com.example.fifatournement.repository.ISupporterRepository;
import com.example.fifatournement.service.MemberService;
import com.example.fifatournement.service.SupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fifa-tournement")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    MemberService memberService;

    //    Get all Clubs
    @GetMapping("/members")
    public List<Member> getMembers(){
        return memberService.getMembers();
    }

    // Get a specific Club
    @GetMapping("/member/{memberId}")
    public Member getMember(
            @PathVariable Integer memberId){
        return memberService.getMember(memberId);
    }

    // delete a member
    @DeleteMapping("/member/delete/{memberId}")
    public void deleteMember(
            @PathVariable Integer memberId) {
         memberService.deleteMember(memberId);
    }

    @PostMapping("/member/add")
    public Member addMember(@RequestBody Member member){
        return memberService.addMember(member);
    }
}
