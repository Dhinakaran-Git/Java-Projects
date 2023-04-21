package com.bassure.learning.springmvc.lms.controller;

import com.bassure.learning.springmvc.lms.Service.MemberService;
import com.bassure.learning.springmvc.lms.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public String getMembers(Model model) {
        model.addAttribute("members", memberService.getMembers());
        return "memberList";
    }

    @GetMapping("/addMember")
    public String addMemberPage(Model model) {
        return "addMember";
    }

    @PostMapping(value = "/newMember", consumes = "application/x-www-form-urlencoded")
    public String newMemberInfo(Member member, Model model) {
        System.out.println(member);
        model.addAttribute("info", memberService.addMember(member));
        return "redirect:/members";
    }

    @RequestMapping(value = "/delmember/{mid}")
    public String removeMember(@PathVariable int mid, Model model) {
        memberService.removeMember(mid);
        return "redirect:/members";
    }

    @GetMapping("/updatemember/{mid}")
    public String editMemberPage(@PathVariable int mid, Model model) {
        model.addAttribute("member", memberService.getMember(mid));
        return "editmember";
    }

    @RequestMapping(value = "/updatemember/update/{mid}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editMember(@PathVariable int mid, @RequestParam String name, @RequestParam int age,
            @RequestParam String gender, @RequestParam long num, @RequestParam String status) {

        Member member = new Member(mid, name, age, gender, num, "Available");
        System.out.println(member);
        if (memberService.updateMember(member)) {
            return "redirect:/members";
        } else {
            return "editmember";
        }
    }
}
