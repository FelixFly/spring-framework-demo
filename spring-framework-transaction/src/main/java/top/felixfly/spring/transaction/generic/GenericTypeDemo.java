package top.felixfly.spring.transaction.generic;

import org.springframework.core.GenericTypeResolver;

/**
 * 泛型示例
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
public class GenericTypeDemo {


    public static void main(String[] args) {
        Class<?> aClass = GenericTypeResolver.resolveTypeArgument(UserResponse.class, Response.class);
        System.out.println(aClass.getName());
    }
}
