package com.xyzq.doit.zfq.example.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Sender {

    public static void main(String[] args) throws JMSException, InterruptedException, IOException {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "failover:(tcp://localhost:61616,tcp://localhost:61617)");

        connectionFactory.setTrustedPackages(new ArrayList(
                    Arrays.asList("com.xyzq.doit.zfq.example.activemq.entity".split(","))));


        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection =  connectionFactory.createConnection();

        connection.start();
        // Session： 一个发送或接收消息的线程
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        // Destination ：消息的目的地;消息发送给谁.
        Destination destination =  session.createQueue("my-queue");

        // MessageProducer：消息发送者
        MessageProducer producer =  session.createProducer(destination);

        // 设置不持久化，可以更改
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for(int i=0;i<10;i++){
//            byte[] msgBytes = Files.readAllBytes(Paths.get("/Users/zhengfq/temp/mytest.html"));
//            //创建文本消息
//            String msg = new String(msgBytes) +i + new Date();
            String msg = "2我是中国人啊，第几条"+i + new Date();
            TextMessage message = session.createTextMessage(msg);
            message.setStringProperty("appId", "afa"+(i%2+1));

            System.out.println(msg);
//            Thread.sleep(10000);
            //发送消息
            producer.send(message);
        }

//        for(int i=0;i<10;i++){
//            byte[] msgBytes = Files.readAllBytes(Paths.get("/Users/zhengfq/temp/mytest.html"));
//            //创建文本消息
////            String msg = "我是中国人啊，第几条"+i + new Date();
//            String msg = new String(msgBytes) +i + new Date();
//            MessageBean bean = new MessageBean();
//            bean.setContent(msg);
//            bean.setProDate(new Date());
//            bean.setNumber(i);
//            ObjectMessage message = session.createObjectMessage();
//            message.setObject(bean);
//
//            System.out.println(msg);
//            Thread.sleep(1000);
//            //发送消息
//            producer.send(message);
//        }

        session.commit();
        session.close();
        connection.close();
    }

}