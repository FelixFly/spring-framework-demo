package top.felixfly.spring.framework.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Aop切面配置
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/11/28
 */
@Configuration
@ComponentScan("top.felixfly.spring.framework.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfiguration {
}
