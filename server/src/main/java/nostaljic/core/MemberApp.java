package nostaljic.core;

import nostaljic.core.member.Grade;
import nostaljic.core.member.Member;
import nostaljic.core.member.MemberService;
import nostaljic.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args){
        AppConfig appConfig = new AppConfig();

        //의존성 주입에 의해 memberService에는 AppConfig에서 주입된 MemberServiceImpl이 들어가 있다.
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L,"testMemberA", Grade.VIP);
        memberService.join(member);
        Member member1 = memberService.findMember(1L);
        System.out.println(member.getName());
        System.out.println(member1.getName());

    }
}
