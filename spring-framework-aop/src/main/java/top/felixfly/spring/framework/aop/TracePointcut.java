package top.felixfly.spring.framework.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.io.Serializable;

/**
 * TODO
 *
 * @author xcl <xcl@winning.com.cn>
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
        return ClassFilter.TRUE;
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
