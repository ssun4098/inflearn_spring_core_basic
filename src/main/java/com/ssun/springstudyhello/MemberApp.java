package com.ssun.springstudyhello;

import com.ssun.springstudyhello.member.Grade;
import com.ssun.springstudyhello.member.Member;
import com.ssun.springstudyhello.member.MemberService;
import com.ssun.springstudyhello.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());
        System.out.println("new member: " + member.getName());
        System.out.println("find member: " + findMember.getName());
    }
}
