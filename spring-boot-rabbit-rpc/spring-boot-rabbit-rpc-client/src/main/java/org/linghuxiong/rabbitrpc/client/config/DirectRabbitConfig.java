package org.linghuxiong.rabbitrpc.client.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linghuxiong
 * @date 2019/12/11 1:40 下午
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 队列 起名：TestDirectQueue
     * @return
     */
    @Bean
    public Queue testDirectQueue() {
        //true 是否持久
        return new Queue("TestDirectQueue",false);
    }

    /**
     * Direct交换机 起名：TestDirectExchange
     * @return
     */
    @Bean
    DirectExchange testDirectExchange() {
        return new DirectExchange("TestDirectExchange");
    }

    /**
     * 绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
     * @return
     */
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("TestDirectRouting");
    }

}
