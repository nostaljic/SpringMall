package nostaljic.core;


import nostaljic.core.member.Grade;
import nostaljic.core.member.Member;
import nostaljic.core.member.MemberService;
import nostaljic.core.member.MemberServiceImpl;
import nostaljic.core.order.Order;
import nostaljic.core.order.OrderService;
import nostaljic.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args){

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId,"testMemberC", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"ThinkPad E495 32GB RYZEN5 3500U",730000);
        System.out.println("Price :"+order);
    }
}
