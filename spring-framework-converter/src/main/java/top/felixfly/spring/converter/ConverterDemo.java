package top.felixfly.spring.converter;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * {@link ConversionService}
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/6/1
 */
public class ConverterDemo {

    public static void main(String[] args) throws IntrospectionException {
        ConversionService conversionService = new DefaultConversionService();
        Integer convert = conversionService.convert("1111111111", Integer.class);
        System.out.println(convert);


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConverterDemo.class);
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        System.out.println(beanFactory.getConversionService());

        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            System.out.println(name);
        }
    }


    @Data
    public static class User {
        private Integer userId;

        private String userName;
    }

}
