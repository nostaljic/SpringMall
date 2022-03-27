package nostaljic.core.order;

import nostaljic.core.member.Grade;
import nostaljic.core.member.Member;
import nostaljic.core.member.MemberService;
import nostaljic.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId,"testMemberD", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"ThinkPad E495", 730000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
