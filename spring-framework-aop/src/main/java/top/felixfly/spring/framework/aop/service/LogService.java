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
public class LogService {

    @Autowired
    private LogService2 logService2;

    public void test(String arg1, String arg2) {
        System.out.println(".....test....");
        //throw new RuntimeException("测试");
        logService2.test(arg1, arg2);
        test2();
        test3();
        test4();
    }


    private void test2() {

    }

    protected void test3() {

    }

    void test4() {
    }


}
