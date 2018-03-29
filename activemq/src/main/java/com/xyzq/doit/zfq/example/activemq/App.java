package com.xyzq.doit.zfq.example.activemq;

import org.apache.activemq.broker.BrokerService;

public class App {
    public static void main(String[] args) {

        BrokerService broker = new BrokerService();

        // configure the broker
        try {
//            broker.addConnector("tcp://localhost:61616");
            broker.addConnector("tcp://localhost:61616");
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
