package com.xyzq.doit.zfq.example.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;


public class Receiver {
    // ConnectionFactory ：连接工厂，JMS 用它创建连接
    private static ActiveMQConnectionFactory connectionFactory =
            new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                                          ActiveMQConnection.DEFAULT_PASSWORD,
                                          "tcp://localhost:61616");

    {

//        connectionFactory.setTrustedPackages(new ArrayList(
//                Arrays.asList("nia,org.apache.camel.test".split(","))));

        connectionFactory.setTrustAllPackages(true);
    }

    // Connection ：JMS 客户端到JMS Provider 的连接
    private static Connection connection;

    public static void main(String[] args) throws JMSException {

        startConsuming();
        startConsuming2();


    }

    public static void startConsuming2() throws JMSException {
        connection = connectionFactory.createConnection();

        connection.start();

        // Session： 一个发送或接收消息的线程
        final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        // Destination ：消息的目的地;消息送谁那获取.
        Destination destination = session.createQueue("my-queue");

        // 再来一个消费者，消息接收者
//        MessageConsumer consumer2 = session.createConsumer(destination);
        MessageConsumer consumer2 = session.createConsumer(destination, "appId='afa2'");

        consumer2.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message msg) {

                try {

                    if (msg instanceof TextMessage) {
                        TextMessage message = (TextMessage) msg;
                        System.out.println("consumer2收到消息： " + message.getText());
                    } else if (msg instanceof ObjectMessage) {
                        ObjectMessage message = (ObjectMessage) msg;
                        Object obj = message.getObject();
                        if (obj instanceof MessageBean) {
                            MessageBean objBean = (MessageBean) obj;
                            System.out.println("consumer2收到消息： " + objBean);

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        Thread.sleep(1000);
                        startConsuming2();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }

            }
        });
    }

    public static void startConsuming() throws JMSException {
        connection = connectionFactory.createConnection();

        connection.start();
        // Session： 一个发送或接收消息的线程
        final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // Destination ：消息的目的地;消息送谁那获取.
        Destination destination = session.createQueue("my-queue");
        // 消费者，消息接收者
//        MessageConsumer consumer1 = session.createConsumer(destination);
        MessageConsumer consumer1 = session.createConsumer(destination, "appId='afa1'");

        consumer1.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message msg) {

                try {
                    if (msg instanceof TextMessage) {
                        TextMessage message = (TextMessage) msg;
                        System.out.println("consumer1收到消息： " + message.getText());
                    } else if (msg instanceof ObjectMessage) {
                        ObjectMessage message = (ObjectMessage) msg;
                        Object obj = message.getObject();
                        if (obj instanceof MessageBean) {
                            MessageBean objBean = (MessageBean) obj;
                            System.out.println("consumer1收到消息： " + objBean);

                        }
                    }
                    Thread.sleep(1000);
                    session.commit();
                } catch (Exception e) {
                    e.printStackTrace();

                    try {
                        Thread.sleep(1000);
                        startConsuming();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });

    }


}

