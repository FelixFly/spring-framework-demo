package top.felixfly.spring.framework.aop;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * 日志通知器
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
public class TraceBeanFactoryPointcutAdvisor extends AbstractBeanFactoryPointcutAdvisor {


    @Override
    public Pointcut getPointcut() {
        // 所有的方法
        return Pointcut.TRUE;
    }
}
