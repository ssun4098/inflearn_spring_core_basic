package com.ssun.springstudyhello;

import com.ssun.springstudyhello.discount.RateDiscountPolicy;
import com.ssun.springstudyhello.member.MemberService;
import com.ssun.springstudyhello.member.MemberServiceImpl;
import com.ssun.springstudyhello.member.MemoryMemberRepository;
import com.ssun.springstudyhello.order.OrderService;
import com.ssun.springstudyhello.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
    }

    @Bean
    public RateDiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
