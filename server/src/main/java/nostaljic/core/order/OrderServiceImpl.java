package nostaljic.core.order;

import nostaljic.core.discount.DiscountPolicy;
import nostaljic.core.discount.FixDiscountPolicy;
import nostaljic.core.discount.RateDiscountPolicy;
import nostaljic.core.member.Member;
import nostaljic.core.member.MemberRepository;
import nostaljic.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy= new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy= new RateDiscountPolicy();
    /* interface, implementation에 둘 다 의존하고 있는 코드 : DIP를 준수하지 않는다. */
    /* discount rate를 바꾸는  순간 OrderServiceImpl도 함께 변경해야만 한다. : OCP를 위반한다. */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
