package practice2.Practice2.repository;

import practice2.Practice2.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findByID(Long ID);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
