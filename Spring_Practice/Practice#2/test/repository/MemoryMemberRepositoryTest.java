package practice2.Practice2.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import practice2.Practice2.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {


    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        memberRepository.save(member);

        Member result = memberRepository.findByID(member.getID()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("testName");
        memberRepository.save(member);

        Member result = memberRepository.findByName(member.getName()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("testName");
        Member member2 = new Member();
        member2.setName("testName2");
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> memberContainer = memberRepository.findAll();

        assertThat(memberContainer.size()).isEqualTo(2);
    }
}
