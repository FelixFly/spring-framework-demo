package top.felixfly.spring.beans.lifecycle;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;
import top.felixfly.spring.beans.entity.User;

/**
 * {@link MergedBeanDefinitionPostProcessor}
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/14
 */
@Component
public class UserMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {


    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {

        if (User.class.equals(beanType)) {
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            propertyValues.add("age", "10");
            System.out.println("MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition");
        }
    }
}
