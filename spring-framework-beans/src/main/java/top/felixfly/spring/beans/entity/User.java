package top.felixfly.spring.beans.entity;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 用户信息
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/14
 */
@Data
public class User implements InitializingBean, DisposableBean {

    private Integer id;

    private String name;

    private Integer age;

    public static User createUser() {
        User user = new User();
        user.setId(1);
        user.setName("FelixFly");
        user.setAge(20);
        return user;
    }

    public static void addUserAge(Object bean) {
        if (isUser(bean)) {
            User user = (User) bean;
            user.addAge();
            System.out.println("年龄递增。。。" + user.getAge());
        }
    }

    public void customizedInit(){
        System.out.println("User#customizedInit");
        addAge();
    }

    public void customizedDestroy(){
        System.out.println("User#customizedDestroy");
        addAge();
    }

    private void addAge(){
        this.setAge(this.getAge() + 1);
    }

    public static boolean isUser(Object bean) {
        return bean.getClass().equals(User.class);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy");
        addAge();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet");
        addAge();
    }
}
