package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //조회에서는 성능 올라감
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional //따로 설정이 우선적으로 들어감
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //회원 단건조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    //트랜잭션 있는 상태에서 멤버 조회하면 영속상태임
    @Transactional
    public void update(Long id, String name) {
        //영속상태 멤버 가져오기
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
