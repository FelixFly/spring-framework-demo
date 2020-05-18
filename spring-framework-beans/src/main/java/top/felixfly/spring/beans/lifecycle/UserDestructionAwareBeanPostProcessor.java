package top.felixfly.spring.beans.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import top.felixfly.spring.beans.entity.User;

/**
 * {@link DestructionAwareBeanPostProcessor} 销毁后置处理器
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/17
 */
@Component
public class UserDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if(User.isUser(bean)) {
            System.out.println("DestructionAwareBeanPostProcessor#postProcessBeforeDestruction");
        }
    }
}
