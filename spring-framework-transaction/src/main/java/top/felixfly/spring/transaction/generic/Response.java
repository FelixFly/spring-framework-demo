package top.felixfly.spring.transaction.generic;

import lombok.Data;

/**
 * 返回数据
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
@Data
public class Response<T> {

    private T data;
}
