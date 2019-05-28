package com.xyzq.doit.zfq.studyexample.jgroup;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhengfq on 2018/7/10.
 */
public class ChatServer {
    public ChatServer(String userName) {
        this.userName = userName;
    }

    JChannel channel;
    String userName;

    public void start() throws Exception {
    channel=new JChannel();
        channel.setReceiver(new ReceiverAdapter() {
            public void viewAccepted(View new_view) {
                System.out.println("** view: " + new_view);
            }

            public void receive(Message msg) {
                System.out.println(msg.getSrc() + ": " + msg.getObject());
            }
        });
    channel.connect("ChatCluster");
    eventLoop();
    channel.close();
}

    private void eventLoop() {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                System.out.print("> "); System.out.flush();
                String line=in.readLine().toLowerCase();
                if(line.startsWith("quit") || line.startsWith("exit"))
                    break;
                line="[" + userName + "] " + line;
                Message msg=new Message(null, line);
                channel.send(msg);
            }
            catch(Exception e) {
            }
        }
    }
}
