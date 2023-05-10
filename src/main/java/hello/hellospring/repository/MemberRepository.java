package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member) throws SQLException; // 회원저장
    Optional<Member> findById(Long id) throws SQLException; // 아이디로 찾기
    Optional<Member> findByName(String name) throws SQLException; // 이름으로 찾기
    List<Member> findAll() throws SQLException; // 모두 찾기
}
