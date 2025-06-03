package com.ssun.springstudyhello.bean;

import com.ssun.springstudyhello.discount.DiscountPolicy;
import com.ssun.springstudyhello.discount.FixDiscountPolicy;
import com.ssun.springstudyhello.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(DiscountPolicy.class));
    }

    @Test
    void findBeanByParentTypeBeanName() {
        DiscountPolicy discountPolicy = context.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = context.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = context.getBeansOfType(Object.class);
        for(String key : beansOfType.keySet()) {
            System.out.println(key + ", " + beansOfType.get(key));
        }
    }

    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
