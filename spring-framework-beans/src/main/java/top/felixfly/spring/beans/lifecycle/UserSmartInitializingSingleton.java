package top.felixfly.spring.beans.lifecycle;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * {@link SmartInitializingSingleton}
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/16
 */
@Component
public class UserSmartInitializingSingleton implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("SmartInitializingSingleton#afterSingletonsInstantiated");
    }
}
