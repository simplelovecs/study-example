package com.xyzq.doit.zfq.example.activemq;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.security.SimpleAuthenticationBroker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengfq on 2018/4/5.
 */
public class SimpleAuthBroker extends BrokerService {
    private String user;
    private String password;

    protected Broker addInterceptors(Broker broker) throws Exception {
        broker = super.addInterceptors(broker);
        Map passwords = new HashMap();
        passwords.put(getUser(), getPassword());
        broker = new SimpleAuthenticationBroker(broker, passwords, new HashMap());
        return broker;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
