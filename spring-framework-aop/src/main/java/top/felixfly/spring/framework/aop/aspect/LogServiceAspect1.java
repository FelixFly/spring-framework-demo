package top.felixfly.spring.framework.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/11/28
 */
@Aspect
@Component
@Order(0)
public class LogServiceAspect1 {

    @Pointcut("execution(* top.felixfly.spring.framework.aop.service.*Service.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("。。。。LogServiceAspect1#Before。。。。。");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("。。。。LogServiceAspect1#Around。。。。。");
        //return joinPoint.proceed();
        try {
            return joinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("接收异常LogServiceAspect1");
            throw ex;
        }
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        System.out.println("。。。。LogServiceAspect1#After。。。。。");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("。。。。LogServiceAspect1#AfterReturning。。。。。");
    }


}
