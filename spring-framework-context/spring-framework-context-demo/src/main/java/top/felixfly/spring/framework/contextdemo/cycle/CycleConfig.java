package top.felixfly.spring.framework.contextdemo.cycle;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 循环应用配置
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/12/2
 */
@Configuration
@ComponentScan("top.felixfly.spring.framework.contextdemo.cycle")
public class CycleConfig {


    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public CycleA cycleA(){
        return new CycleA();
    }

    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Bean
    public CycleB cycleB(){
        return new CycleB();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                CycleConfig.class);
        CycleA cycleA = applicationContext.getBean(CycleA.class);

        System.out.println(cycleA);
        System.out.println(cycleA.getCycleB());
        System.out.println(cycleA.getCycleB());
        applicationContext.close();
    }
}
