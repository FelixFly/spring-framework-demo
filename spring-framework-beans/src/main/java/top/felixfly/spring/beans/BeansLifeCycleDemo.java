package top.felixfly.spring.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import top.felixfly.spring.beans.entity.User;

/**
 * Bean 生命周期
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/14
 */
@ComponentScan("top.felixfly.spring.beans.lifecycle")
public class BeansLifeCycleDemo {

    @Bean(initMethod = "customizedInit",destroyMethod = "customizedDestroy")
    public static User user(){
        return User.createUser();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeansLifeCycleDemo.class);
        applicationContext.refresh();


        User user = applicationContext.getBean(User.class);
        System.out.println(user);

        User user2 = applicationContext.getBean(User.class);
        System.out.println(user2);
        System.out.println(user == user2);

        applicationContext.close();
    }
}