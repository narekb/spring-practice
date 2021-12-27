package am.babajanyan.postprocessors;

import am.babajanyan.annotations.Autoplug;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class AutoplugPostProcessor implements BeanPostProcessor, BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Scan fields for our @Autoplug annotation
        for (Field field : bean.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(Autoplug.class)) {
                try {
                    field.set(bean, beanFactory.getBean(field.getType()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Scan methods for our annotation
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(Autoplug.class)) {
                if(method.getParameters().length > 0) {
                    Parameter firstParam = method.getParameters()[0];
                    try {
                        method.invoke(bean, beanFactory.getBean(firstParam.getType()));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return bean;
    }
}
