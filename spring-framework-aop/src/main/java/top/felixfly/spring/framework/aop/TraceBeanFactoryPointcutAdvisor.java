package top.felixfly.spring.framework.aop;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * TODO
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/5/18
 */
public class TraceBeanFactoryPointcutAdvisor extends AbstractBeanFactoryPointcutAdvisor {


    @Override
    public Pointcut getPointcut() {
        return TracePointcut.INSTANCE;
    }
}
