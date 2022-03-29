package nostaljic.core;

import nostaljic.core.discount.RateDiscountPolicy;
import nostaljic.core.member.MemberService;
import nostaljic.core.member.MemberServiceImpl;
import nostaljic.core.member.MemoryMemberRepository;
import nostaljic.core.order.OrderService;
import nostaljic.core.order.OrderServiceImpl;

public class AppConfig {
    //AppConfig를 통해서 의존성을 주입한다;
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new RateDiscountPolicy(),new MemoryMemberRepository());
    }
}
