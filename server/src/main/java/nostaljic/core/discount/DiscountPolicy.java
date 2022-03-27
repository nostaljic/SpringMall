package nostaljic.core.discount;

import nostaljic.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
