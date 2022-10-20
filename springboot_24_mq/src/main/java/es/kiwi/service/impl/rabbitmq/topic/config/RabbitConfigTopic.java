package es.kiwi.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigTopic {

    @Bean
    public Queue topicQueue() {
        return new Queue("topic_queue");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic_queue2");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定键匹配规则 * 用来表示一个单词，且该单词是必须出现的 # 用来表示任意数量
     *
     * @return
     */
    @Bean
    public Binding bindingTopic() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }

    @Bean
    public Binding bindingTopic1() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.orders.*");
    }

}
