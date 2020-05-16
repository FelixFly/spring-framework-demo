package top.felixfly.spring.framework.aop.service;

import org.springframework.stereotype.Component;

/**
 * 日志服务
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/11/28
 */
@Component
public class LogService {


    public void test() {
        System.out.println(".....test....");
        throw new RuntimeException("测试");
    }

}
