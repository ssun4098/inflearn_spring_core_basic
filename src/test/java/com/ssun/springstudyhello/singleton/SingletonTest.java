package com.ssun.springstudyhello.singleton;

import com.ssun.springstudyhello.AppConfig;
import com.ssun.springstudyhello.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonTest {

    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();;

        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService: " + memberService);
        System.out.println("memberService2: " + memberService2);

        assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    void testSingleton() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    void singletonContainer() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);
        MemberService memberService2 = context.getBean("memberService", MemberService.class);

        assertThat(memberService).isSameAs(memberService2);
    }
}
