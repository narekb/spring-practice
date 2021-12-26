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
        // 2) Configure multiple lifecycle hooks (@PostConstruct, initMethodName, afterPropertiesSet())
        // 3) Monitor sequence of method output
        ctx.getBean("demoBean", LifecycleDemo.class);
        ctx.close();
    }
}
