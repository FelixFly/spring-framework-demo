package top.felixfly.spring.beans.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import top.felixfly.spring.beans.entity.User;

/**
 * {@link BeanPostProcessor} 初始化
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/14
 */
@Component
public class UserBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (User.isUser(bean)) {
            System.out.println("BeanPostProcessor#postProcessBeforeInitialization");
            User.addUserAge(bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (User.isUser(bean)) {
            System.out.println("BeanPostProcessor#postProcessAfterInitialization");
            User.addUserAge(bean);
        }
        return bean;
    }
}
