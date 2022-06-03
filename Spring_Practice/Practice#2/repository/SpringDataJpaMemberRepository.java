package practice2.Practice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice2.Practice2.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
