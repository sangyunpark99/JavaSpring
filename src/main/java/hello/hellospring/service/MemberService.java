package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 제거
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { // 중복회원 검증
        memberRepository.findByName(member.getName())// null 가능성이 있으면, Optional 사용
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다");
            });
    }

    public List<Member> findMembers() { // 전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){ // 한 회원 조회
        return memberRepository.findById(memberId);
    }
}
