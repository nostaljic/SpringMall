package nostaljic.core.beanfind;
import nostaljic.core.AppConfig;
import nostaljic.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("Print Bean")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanName : beanDefinitionNames){
            Object bean = ac.getBean(beanName);
            System.out.println("ApplicationContextInfoTest.findAllBean "+ bean);
        }
    }
}
