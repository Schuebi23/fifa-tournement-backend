package com.example.fifatournement.controller;

import com.example.fifatournement.model.Member;
import com.example.fifatournement.service.MemberService;
import com.example.fifatournement.service.SupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fifa-tournement")
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    MemberService memberService;
    SupporterService supporterService;

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

    @PostMapping("/member/{supporterId}/add")
    public Member addMember(@PathVariable Integer supporterId ,@Valid @RequestBody Member member) {
                    member.setSupporter(supporterService.getSupporter(supporterId));
                    return memberService.addMember(member);
    }
}
