package nostaljic.core;

import nostaljic.core.member.Grade;
import nostaljic.core.member.Member;
import nostaljic.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args){
        MemberServiceImpl memberService = new MemberServiceImpl();
        Member member = new Member(1L,"testMemberA", Grade.VIP);
        memberService.join(member);
        Member member1 = memberService.findMember(1L);
        System.out.println(member.getName());
        System.out.println(member1.getName());

    }
}
