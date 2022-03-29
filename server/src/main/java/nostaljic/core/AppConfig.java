package nostaljic.core;

import nostaljic.core.discount.DiscountPolicy;
import nostaljic.core.discount.RateDiscountPolicy;
import nostaljic.core.member.MemberRepository;
import nostaljic.core.member.MemberService;
import nostaljic.core.member.MemberServiceImpl;
import nostaljic.core.member.MemoryMemberRepository;
import nostaljic.core.order.OrderService;
import nostaljic.core.order.OrderServiceImpl;

public class AppConfig {
    //역할만 추출한다.만약 추후에 Impl이 달라진다면 해당 부분만 변경하면 된다.
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    private DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
    //DIP : 의존성을 주입한다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(discountPolicy(),memberRepository());
    }
}
