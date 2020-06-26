package top.felixfly.spring.framework.contextdemo;

import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

/**
 * environment 实现
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/6/22
 */
public class StandardEnvironmentDemo {

    public static void main(String[] args) {
        StandardEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.forEach(item -> System.out.println(item.getName()));
    }
}
