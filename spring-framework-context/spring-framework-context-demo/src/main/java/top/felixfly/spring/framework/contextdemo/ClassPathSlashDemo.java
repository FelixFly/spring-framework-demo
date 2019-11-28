package top.felixfly.spring.framework.contextdemo;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * classpath 是否有/的演示
 *
 * @author FelixFly
 * @date 2019/11/28
 */
public class ClassPathSlashDemo {

    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/user.xml");
        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));*/

       /* GenericApplicationContext applicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("user.xml");
        applicationContext.refresh();
        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
        System.out.println(applicationContext.containsBean("user1"));
        System.out.println(applicationContext.containsBean("user2"));
        applicationContext.close();*/

        AnnotationBeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClassName(ClassPathSlashDemo.class.getName());
        String name = beanNameGenerator.generateBeanName(rootBeanDefinition,null);
        System.out.println(name);
    }
}
