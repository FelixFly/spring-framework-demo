package top.felixfly.spring.framework.aop;

import com.alibaba.fastjson.JSON;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/5/18
 */
public class TraceInterceptor extends SimpleTraceInterceptor {


    private AtomicInteger count = new AtomicInteger();

    @Override
    protected boolean isLogEnabled(Log logger) {
        return logger.isInfoEnabled();
    }


    @Override
    protected void writeToLog(Log logger, String message, Throwable ex) {
        if (Objects.nonNull(ex)) {
            logger.error(message, ex);
            return;
        }
        logger.info(message);
    }


    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {
        int num = count.incrementAndGet();
        long start = System.currentTimeMillis();
        try {
            Object proceed = invocation.proceed();
            writeToLog(logger, getDescription(invocation, num, proceed, System.currentTimeMillis() - start));
            return proceed;

        } catch (Throwable ex) {
            writeToLog(logger, getDescription(invocation, num, null, System.currentTimeMillis() - start), ex);
            throw ex;
        }
    }

    private String getDescription(MethodInvocation invocation, int num, Object returnObject, long time) {
        Method method = invocation.getMethod();
        Object[] arguments = invocation.getArguments();
        return String.format("%d|%d|%s#%s|%s|%s", time, num,
                method.getDeclaringClass().getSimpleName(), method.getName(), JSON.toJSONString(arguments),
                JSON.toJSONString(returnObject));
    }
}
