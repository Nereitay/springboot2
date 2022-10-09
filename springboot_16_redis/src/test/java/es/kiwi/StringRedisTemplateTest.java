package es.kiwi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisTemplateTest {

    /**
     * RedisTemplate以对象作为key和value，内部对数据进行序列化
     *
     * StringRedisTemplate以字符串作为key和value，与Redis客户端操作等效
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void get() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        System.out.println(ops.get("name"));
    }
}
