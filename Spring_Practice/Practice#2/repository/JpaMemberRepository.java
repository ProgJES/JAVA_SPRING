package practice2.Practice2.repository;

import practice2.Practice2.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {

        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByID(Long ID) {
        //Try to search by primary key
        Member member = em.find(Member.class, ID);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {

        //Try to change plain column value
        List<Member> result = em.createQuery("SELECT m FROM Member m WHERE m.name = :name", Member.class)
                .setParameter("name", name).getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {

        //Try to find data with plain column value
        return em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
    }
}
