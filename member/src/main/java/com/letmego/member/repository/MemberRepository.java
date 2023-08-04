package com.letmego.member.repository;

import com.letmego.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByEmail(String email);
    Boolean existsByEmail(String email);
    MemberEntity findByEmailAndPassword(String email, String password);

}
