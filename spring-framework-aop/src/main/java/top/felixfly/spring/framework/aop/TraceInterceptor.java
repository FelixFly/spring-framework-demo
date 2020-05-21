package top.felixfly.spring.framework.aop;

import com.alibaba.fastjson.JSON;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 日志拦截器
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
public class TraceInterceptor extends SimpleTraceInterceptor {


    private final AtomicInteger count = new AtomicInteger();

    @Override
    protected boolean isLogEnabled(Log logger) {
        // 调整日志级别
        return logger.isInfoEnabled();
    }


    @Override
    protected void writeToLog(Log logger, String message, Throwable ex) {
        // 打印日志方式
        if (Objects.nonNull(ex)) {
            logger.error(message, ex);
            return;
        }
        logger.info(message);
    }


    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {
        // 这地方有个并发的问题
        int num = count.incrementAndGet();
        long start = System.currentTimeMillis();
        try {
            Object proceed = invocation.proceed();
            // 执行序号|执行方法名|执行时间|入参|出参|错误信息
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
        return String.format("%d|%s#%s|%d|%s|%s", num,
                method.getDeclaringClass().getSimpleName(), method.getName(), time, JSON.toJSONString(arguments),
                Objects.isNull(returnObject) ? "" : JSON.toJSONString(returnObject));
    }
}
