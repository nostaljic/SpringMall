package nostaljic.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository = new MemoryMemberRepository(); //polymorphism
    /*
    TODO 1 -
        DIP:
        MemberServiceImpl 구현체는
        MemberRepository(interface), MemoryMemberRepository(class)
        둘 다 의존하고 있기 때문에 DIP를 준수하고 있지 않다.

    TODO 2 -
        OCP:
        구현 객체를 변경할 때 클라이언트 코드를 수정해야 한다.
        OCP를 준수하고 있지 않다.
    */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
