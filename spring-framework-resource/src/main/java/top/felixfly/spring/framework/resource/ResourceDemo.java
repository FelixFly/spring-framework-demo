package top.felixfly.spring.framework.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * {@link Resource}
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
public class ResourceDemo {

    private static final String SERVER_PROPERTIES_WINDOWS = "C:/opt/settings/server1.properties";

    public static void main(String[] args) throws IOException {
        // ClassPath 文件
        printResource(new ClassPathResource("resource.properties"), "UTF-8");
        // 文件系统下文件
        printResource(new FileSystemResource(SERVER_PROPERTIES_WINDOWS), "UTF-8");

        // 获取配置
        Properties properties = getProperties(new ClassPathResource("resource.properties"), "UTF-8");
        System.out.println(properties.getProperty("name"));

        properties = getProperties(new FileSystemResource(SERVER_PROPERTIES_WINDOWS), "UTF-8");
        System.out.println(properties.getProperty("name"));
    }


    private static void printResource(Resource resource, String encoding) throws IOException {
        if (resource.exists() && resource.isReadable()) {
            EncodedResource encodedResource = new EncodedResource(resource, encoding);
            try (Reader reader = encodedResource.getReader()) {
                IOUtils.copy(reader, System.out, encoding);
                System.out.println();
            }
        }
    }

    private static Properties getProperties(Resource resource, String encoding) throws IOException {
        Properties properties = new Properties();
        if (resource.exists() && resource.isReadable()) {
            EncodedResource encodedResource = new EncodedResource(resource, encoding);
            try (Reader reader = encodedResource.getReader()) {
                properties.load(reader);
            }
        }
        return properties;
    }
}
