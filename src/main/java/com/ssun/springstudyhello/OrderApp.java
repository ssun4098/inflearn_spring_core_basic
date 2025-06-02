package com.ssun.springstudyhello;

import com.ssun.springstudyhello.member.Grade;
import com.ssun.springstudyhello.member.Member;
import com.ssun.springstudyhello.member.MemberService;
import com.ssun.springstudyhello.member.MemberServiceImpl;
import com.ssun.springstudyhello.order.Order;
import com.ssun.springstudyhello.order.OrderService;
import com.ssun.springstudyhello.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
