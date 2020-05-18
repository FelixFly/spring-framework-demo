package top.felixfly.spring.framework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/11/28
 */
@Aspect
@Component
@Order(3)
public class LogServiceAspect4 {

    @Pointcut("execution(* top.felixfly.spring.framework.aop.service.*Service.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("。。。。LogServiceAspect4。。。。。");
        //return joinPoint.proceed();
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("接收异常LogServiceAspect4");
            throw new RuntimeException("LogServiceAspect4");
        }
    }

}
