package org.linghuxiong.rabbitrpc.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 监听的队列名称 TestDirectQueue
 * @author linghuxiong
 * @date 2019/12/11 1:49 下午
 */

@Component
@RabbitListener(queues = "TestDirectQueue")
@Slf4j
public class DirectReceiver{

    @Value("${server.port}")
    int port;

    @RabbitHandler
    public String process(Map testMessage) {
        log.info(">>>> "+port + "  >>>>>>>  DirectReceiver sleep before : " + testMessage.toString());
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(">>>> "+port + "  >>>>>>>  DirectReceiver after : " + testMessage.toString());
        return "Success from receive";
    }
}
