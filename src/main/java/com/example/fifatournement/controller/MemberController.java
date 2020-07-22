package com.example.fifatournement.controller;

import com.example.fifatournement.model.Member;
import com.example.fifatournement.model.Supporter;
import com.example.fifatournement.repository.IMemberRepository;
import com.example.fifatournement.repository.ISupporterRepository;
import com.example.fifatournement.service.MemberService;
import com.example.fifatournement.service.SupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fifa-tournement")
@CrossOrigin(origins = "*")
public class MemberController {

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
    @DeleteMapping("/member/{memberId}")
    public void deleteMember(
            @PathVariable Integer memberId) {
         memberService.deleteMember(memberId);
    }

    @PostMapping("/member/{supporterId}/add")
    public Member addMember(@PathVariable Integer supporterId ,@Valid @RequestBody Member member) {

                    //Die zile bruchsch ni setzisch ja dr supporter im MemberService ine
                    //member.setSupporter(supporterService.getSupporter(supporterId));

                    return memberService.addMember( supporterId, member);
    }
}
