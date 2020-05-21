package top.felixfly.spring.framework.aop;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

/**
 * Aop切面配置
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/11/28
 */
@Configuration
@ComponentScan("top.felixfly.spring.framework.aop")
@EnableAspectJAutoProxy
public class AopConfiguration {

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public TraceBeanFactoryPointcutAdvisor traceBeanFactoryPointcutAdvisor(){
        TraceBeanFactoryPointcutAdvisor pointcutAdvisor = new TraceBeanFactoryPointcutAdvisor();
        pointcutAdvisor.setAdvice(traceInterceptor());
        return pointcutAdvisor;
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public TraceInterceptor traceInterceptor(){
        return new TraceInterceptor();
    }
}
