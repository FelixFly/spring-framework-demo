package top.felixfly.spring.framework.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.felixfly.spring.framework.aop.service.LogService;

import java.util.concurrent.TimeUnit;

/**
 * AOP测试类
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/11/28
 */
public class AopTest {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AopConfiguration.class);
        LogService logService = applicationContext.getBean(LogService.class);
        logService.test("1111", "2222");
        // 阻塞5秒确保执行
        TimeUnit.SECONDS.sleep(5);

    }

    private static void newThreadRun(LogService logService) {
        new Thread(() -> logService.test("1111", "2222")).start();
    }
}
