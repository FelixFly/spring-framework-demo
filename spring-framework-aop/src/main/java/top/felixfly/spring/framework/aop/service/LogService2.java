package top.felixfly.spring.framework.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日志服务
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/11/28
 */
@Service
public class LogService2 {

    @Autowired
    private LogService logService;


    public void test(String arg1, String arg2) {
        System.out.println(".....test....");
        logService.test3();
        logService.test4();
    }

}
