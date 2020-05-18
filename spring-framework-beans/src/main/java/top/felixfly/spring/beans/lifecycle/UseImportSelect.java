package top.felixfly.spring.beans.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import top.felixfly.spring.beans.entity.User;

/**
 * {@link ImportSelector} 实现注入
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
public class UseImportSelect implements ImportSelector, BeanNameAware, ApplicationContextAware {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("ImportSelector#selectImports");
        return new String[]{User.class.getName()};
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("ImportSelector.BeanNameAware#setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ImportSelector.ApplicationContextAware#BeanNameAware");
    }
}
