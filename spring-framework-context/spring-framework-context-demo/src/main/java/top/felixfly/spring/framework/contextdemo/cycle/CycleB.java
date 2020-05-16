package top.felixfly.spring.framework.contextdemo.cycle;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *  A-->B
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/12/2
 */
public class CycleB {

    @Autowired
    private CycleA cycleA;
}
