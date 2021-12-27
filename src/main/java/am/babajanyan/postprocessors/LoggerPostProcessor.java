package am.babajanyan.postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

public class LoggerPostProcessor implements BeanPostProcessor {
@Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean with name " + beanName + " initialized. Value = " + bean.toString());
        return bean;
    }
}
