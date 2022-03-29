package nostaljic.core;

import nostaljic.core.discount.DiscountPolicy;
import nostaljic.core.discount.RateDiscountPolicy;
import nostaljic.core.member.MemberRepository;
import nostaljic.core.member.MemberService;
import nostaljic.core.member.MemberServiceImpl;
import nostaljic.core.member.MemoryMemberRepository;
import nostaljic.core.order.OrderService;
import nostaljic.core.order.OrderServiceImpl;

// AppConfig는 IoC 컨테이너 ( DI 컨테이너 ) 라고 한다. (또는 오브젝트 팩토리, 어셈블러 등)
// 런타임에 외부에서 구현객체를 클라이언트에 전달하여 의존관계를 연결하는 것을 의존관계 주입이라고 한다. (DI)
// 객체 인스턴스를 생성하고 그 참조값을 전달해서 연결한다.
// 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
// 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할수 있다.
public class AppConfig {
    //역할만 추출한다.만약 추후에 Impl이 달라진다면 해당 부분만 변경하면 된다.
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    private DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
    //DI : 의존성을 주입한다. IOC : 제어가 역전되어 AppConfig에서 실행흐름 제어를 관리한다.
    //프레임워크는 제어의 역전을 쉽게 관찰가능, 라이브러리는 실행흐름을 개발자가 제어한다.

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(discountPolicy(),memberRepository());
    }
}
