package top.felixfly.spring.framework.aop.aspect;

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
@Order(2)
public class LogServiceAspect3 {

    @Pointcut("execution(* top.felixfly.spring.framework.aop.service.*Service.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("。。。。LogServiceAspect3。。。。。");
        //return joinPoint.proceed();
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("接收异常LogServiceAspect3");
            throw new RuntimeException("LogServiceAspect3");
        }
    }

}
