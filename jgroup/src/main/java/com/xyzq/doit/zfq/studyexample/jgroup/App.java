package com.xyzq.doit.zfq.studyexample.jgroup;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ChatServer chatServer = new ChatServer("userName2");
        chatServer.start();

    }

    private static void test() throws Exception {
        JChannel channel=new JChannel();
        channel.setReceiver(new ReceiverAdapter() {
            public void receive(Message msg) {
                System.out.println("received msg from " + msg.getSrc() + ": " + msg.getObject());
            }
        });
        channel.connect("MyCluster");
        channel.send(new Message(null, "hello world"));
        channel.close();
    }
}
