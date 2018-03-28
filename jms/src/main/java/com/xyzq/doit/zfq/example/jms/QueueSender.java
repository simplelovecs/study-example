package com.xyzq.doit.zfq.example.jms;

/**
 * Created by zhengfq on 2018/3/25.
 * <p>
 * https://codedependents.com/2009/10/16/efficient-lightweight-jms-with-spring-and-activemq/
 * http://highscalability.com/blog/2009/8/11/13-scalability-best-practices.html
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {
    private final JmsTemplate jmsTemplate;

    @Autowired
    public QueueSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final String message) {
        jmsTemplate.convertAndSend("Queue.Name", message);
    }
}
