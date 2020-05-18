package top.felixfly.spring.beans.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import top.felixfly.spring.beans.entity.User;

import java.util.Objects;
import java.util.Optional;

/**
 * {@link InstantiationAwareBeanPostProcessor} 初始化
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/14
 */
@Component
public class UserInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(User.class.equals(beanClass)) {
            System.out.println("InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation");
        }
        return null;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        if (User.isUser(bean)) {
            System.out.println("InstantiationAwareBeanPostProcessor#postProcessProperties");
            PropertyValue age = pvs.getPropertyValue("age");
            if (Objects.nonNull(age)) {
                SimpleTypeConverter simpleTypeConverter = new SimpleTypeConverter();
                Integer integer = simpleTypeConverter.convertIfNecessary(age.getValue(), Integer.class);
                age.setConvertedValue(Optional.ofNullable(integer).orElse(1) + 1);
            }
        }
        return pvs;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(User.isUser(bean)){
            System.out.println("InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation");
            User.addUserAge(bean);
        }
        return true;
    }
}
