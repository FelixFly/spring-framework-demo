package top.felixfly.spring.transaction.generic;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@link Response} 字符串返回
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/5/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserResponse extends Response<String> {
}
