package nostaljic.core.beanfind;

import nostaljic.core.AppConfig;
import nostaljic.core.member.MemberRepository;
import nostaljic.core.member.MemberService;
import nostaljic.core.member.MemberServiceImpl;
import nostaljic.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("find by name with abstracted type")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("find by name with implemented type")
    void findBeanByNameAndType(){

        MemberServiceImpl memberServiceImpl = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("find by type")
    void findBeanByType(){
        MemberServiceImpl memberService = ac.getBean( MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
