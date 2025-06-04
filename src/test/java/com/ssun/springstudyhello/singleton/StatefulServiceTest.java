package com.ssun.springstudyhello.singleton;

import com.ssun.springstudyhello.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulService() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = context.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = context.getBean("statefulService", StatefulService.class);

        statefulService.order("John", 100);
        statefulService2.order("Anne", 200);

        assertThat(statefulService2.getPrice()).isEqualTo(200);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}