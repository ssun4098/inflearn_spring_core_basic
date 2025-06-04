package com.ssun.springstudyhello.singleton;

import com.ssun.springstudyhello.AppConfig;
import com.ssun.springstudyhello.member.MemberRepository;
import com.ssun.springstudyhello.member.MemberServiceImpl;
import com.ssun.springstudyhello.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfigSingletonTest {

    @Test
    void configTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = context.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService =  context.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = context.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        assertThat(memberRepository).isSameAs(memberRepository1);
        assertThat(memberRepository).isSameAs(memberRepository2);
    }
}
