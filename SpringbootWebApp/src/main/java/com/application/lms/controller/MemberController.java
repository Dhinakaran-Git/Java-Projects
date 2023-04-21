package com.application.lms.controller;

import com.application.lms.apirequest.MemberRequest;
import com.application.lms.entity.Member;
import com.application.lms.serviceImpl.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/api/")
public class MemberController {

    @Autowired
    private MemberServiceImpl memberServiceImpl;

    @GetMapping("/register")
    public String addMemberPage() {
        return "addmember";
    }

    @PostMapping("/register")
    public String addMember(Model model, @ModelAttribute MemberRequest memberRequest) {
        try {
            memberServiceImpl.saveMember(memberRequest);
            return "redirect:/member/api/viewMembers";
        } catch (Exception e) {
            model.addAttribute("status", "Please enter correct input");
            return "addmember";
        }
    }

    @GetMapping(value = "/viewMembers")
    public String viewMembers(Model model, HttpServletRequest request) {
        Principal userPrincipal = request.getUserPrincipal();
        Member user = memberServiceImpl.findByMemberName(userPrincipal.getName()).get();
        model.addAttribute("role", user.getUserRole());
        model.addAttribute("member", memberServiceImpl.getMembers());
        return "viewMembers";
    }

    @PostMapping(value = "/memberbyid/{mid}")
    public String viewMember(@RequestParam int mid, Model model) {
        model.addAttribute("member", memberServiceImpl.getMember(mid));
        return "viewmember";
    }

    @GetMapping(value = "/delmember/{mid}")
    public String removeMember(@PathVariable int mid, Model model) {
        memberServiceImpl.removeMember(mid);
        return "redirect:/member/api/viewMembers";
    }

    @GetMapping("/updatemember/{mid}")
    public String editMemberPage(@PathVariable int mid, Model model) {
        System.out.println(memberServiceImpl.getMember(mid));
        model.addAttribute("member", memberServiceImpl.getMember(mid));
        return "editmember";
    }

    @PostMapping(value = "/updatemember")
    public String editMember(@ModelAttribute MemberRequest memberRequest) {
        System.out.println(memberRequest);
        memberServiceImpl.updateMember(memberRequest, memberRequest.getId());
        return "redirect:/member/api/viewMembers";
    }
}
