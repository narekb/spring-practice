package am.babajanyan;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import javax.annotation.*;

public class LifecycleDemo implements InitializingBean, DisposableBean {

    public LifecycleDemo() {
        System.out.println("1) Constructor invoked.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3) InitializingBean.afterPropertiesSet() invoked.");
    }

    @PostConstruct
    public void customInit() {
        System.out.println("2) @PostConstruct init method invoked.");
    }

    public void initMethod() {
        System.out.println("4) @Bean initMethod invoked.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("6) DisposableBean.destroy() invoked.");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("5) @PreDestroy/@Bean destroy method invoked once.");
    }
}
