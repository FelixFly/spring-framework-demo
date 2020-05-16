package top.felixfly.spring.framework.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.felixfly.spring.framework.aop.service.LogService;

/**
 * AOP测试类
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/11/28
 */
public class AopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AopConfiguration.class);
        LogService logService = applicationContext.getBean(LogService.class);
        logService.test();
    }
}
