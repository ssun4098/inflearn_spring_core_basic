package com.ssun.springstudyhello;

import com.ssun.springstudyhello.member.Grade;
import com.ssun.springstudyhello.member.Member;
import com.ssun.springstudyhello.member.MemberService;
import com.ssun.springstudyhello.member.MemberServiceImpl;
import com.ssun.springstudyhello.order.Order;
import com.ssun.springstudyhello.order.OrderService;
import com.ssun.springstudyhello.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
