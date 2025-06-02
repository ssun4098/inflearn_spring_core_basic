package com.ssun.springstudyhello.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long id);
}
