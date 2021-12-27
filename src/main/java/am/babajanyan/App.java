package am.babajanyan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
public class App {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        // 1) Create simple bean
        // 2) Create logger BeanPostProcessor that will log which beans get injected
        // 3) Create a custom annotation and implement BeanPostProcessor to
        // mimic @Autowired behavior

        SimpleBean bean = ctx.getBean(SimpleBean.class);
        System.out.println("String value = " + bean.getStringValue());
        System.out.println("13 = success. Integer value = " + bean.getIntValue());
        ctx.close();
    }
}
