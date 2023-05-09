package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){ // 테스터는 서로 의존관계가 없어야 한다.
        repository.clearStore();
    }

    // Test의 순서는 보장이 되지 않는다.
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // optional
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member3 = new Member();
        member3.setName("spring1");
        repository.save(member3);

        Member member4 = new Member();
        member4.setName("spring2");
        repository.save(member4);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
