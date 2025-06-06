package com.ssun.springstudyhello.discount;

import com.ssun.springstudyhello.member.Grade;
import com.ssun.springstudyhello.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAccount = 1000;


    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAccount;
        }
        return 0;
    }
}
