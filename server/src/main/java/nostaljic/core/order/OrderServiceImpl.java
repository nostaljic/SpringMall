package nostaljic.core.order;

import nostaljic.core.discount.DiscountPolicy;
import nostaljic.core.member.Member;
import nostaljic.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    /* Null Pointer Exception */
    /* 관심사를 분리하여 의존성을 주입해주는 것이 필요하다. */
    /* 구현 객체를 생성하고 연결하는 책임을 가지는 별도의 설정 클래스가 필요하다. */
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    private MemberRepository memberRepository;



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
