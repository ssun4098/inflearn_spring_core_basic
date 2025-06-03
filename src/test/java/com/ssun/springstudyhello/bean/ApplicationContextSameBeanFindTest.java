package com.ssun.springstudyhello.bean;

import com.ssun.springstudyhello.member.MemberRepository;
import com.ssun.springstudyhello.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    void findBeanByNameX() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(MemberRepository.class));
    }

    @Test
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = context.getBeansOfType(MemberRepository.class);
        for (Map.Entry<String, MemberRepository> entry : beansOfType.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
