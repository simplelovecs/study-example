package com.xyzq.doit.zfq.example.activemq;

import org.apache.activemq.broker.BrokerService;

public class App {
    public static void main(String[] args) {

        BrokerService broker = new BrokerService();
        broker.setBrokerName("test3");
//        broker.setUser("1111111");
//        broker.setPassword("1111111");
//        broker.setMessageAuthorizationPolicy();
        broker.setDataDirectory("activemq-data/localhost/kahaDB2");

        // configure the broker
        try {
            broker.addConnector("tcp://localhost:61618");
            broker.setUseJmx(false);
//            broker.addConnector("tcp://localhost:61616?jms.prefetchPolicy.all=50");
//            broker.addConnector("tcp://localhost:61616?jms.prefetchPolicy.queuePrefetch=1");


//            broker.addNetworkConnector();
            broker.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Hello World!");
    }
}
