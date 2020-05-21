package top.felixfly.spring.framework.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.annotation.AnnotationClassFilter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 日志切面
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
public class TracePointcut implements Pointcut, Serializable {

    public static final TracePointcut INSTANCE = new TracePointcut();

    /**
     * Enforce Singleton pattern.
     */
    private TracePointcut() {
    }

    @Override
    public ClassFilter getClassFilter() {
        // service 注解打点,true表示派生的注解
        return new AnnotationClassFilter(Service.class, true);
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return MethodMatcher.TRUE;
    }

    /**
     * Required to support serialization. Replaces with canonical
     * instance on deserialization, protecting Singleton pattern.
     * Alternative to overriding {@code equals()}.
     */
    private Object readResolve() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "Pointcut.TRUE";
    }
}
