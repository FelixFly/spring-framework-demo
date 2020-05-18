package top.felixfly.spring.beans.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import top.felixfly.spring.beans.entity.User;

/**
 * {@link ImportSelector} 实现注入
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
public class UseImportBeanDefinitionRegistrar
        implements ImportBeanDefinitionRegistrar, BeanNameAware, ApplicationContextAware {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("ImportBeanDefinitionRegistrar#registerBeanDefinitions");
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        registry.registerBeanDefinition("user", beanDefinitionBuilder.getBeanDefinition());
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("ImportBeanDefinitionRegistrar.BeanNameAware#setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ImportBeanDefinitionRegistrar.ApplicationContextAware#BeanNameAware");
    }
}
