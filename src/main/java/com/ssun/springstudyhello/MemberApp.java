package com.ssun.springstudyhello;

import com.ssun.springstudyhello.member.Grade;
import com.ssun.springstudyhello.member.Member;
import com.ssun.springstudyhello.member.MemberService;
import com.ssun.springstudyhello.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());
        System.out.println("new member: " + member.getName());
        System.out.println("find member: " + findMember.getName());
    }
}
