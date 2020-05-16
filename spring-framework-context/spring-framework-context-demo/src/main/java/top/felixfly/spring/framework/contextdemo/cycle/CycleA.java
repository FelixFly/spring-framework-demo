package top.felixfly.spring.framework.contextdemo.cycle;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  A-->B
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2019/12/2
 */
@Getter
public class CycleA {

    @Autowired
    private CycleB cycleB;
}
