package nostaljic.core.order;

import nostaljic.core.discount.DiscountPolicy;
import nostaljic.core.discount.FixDiscountPolicy;
import nostaljic.core.member.Member;
import nostaljic.core.member.MemberRepository;
import nostaljic.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy= new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
