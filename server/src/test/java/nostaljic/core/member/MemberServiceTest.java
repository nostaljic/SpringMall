package nostaljic.core.member;
import nostaljic.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    @Test
    void join(){
        //given
        Member testMemberB = new Member(1L, "testMemberB", Grade.VIP);
        //when
        memberService.join(testMemberB);
        Member foundMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(foundMember).isEqualTo(testMemberB);
    }
}
