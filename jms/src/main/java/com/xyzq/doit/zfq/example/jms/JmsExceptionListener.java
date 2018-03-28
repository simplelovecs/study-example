package com.xyzq.doit.zfq.example.jms;

/**
 * Created by zhengfq on 2018/3/25.
 */

import org.springframework.stereotype.Component;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;


@Component
public class JmsExceptionListener implements ExceptionListener {
    public void onException(final JMSException e) {
        e.printStackTrace();
    }
}