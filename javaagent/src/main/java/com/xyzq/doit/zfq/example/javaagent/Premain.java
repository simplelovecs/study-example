package com.xyzq.doit.zfq.example.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * Created by zhengfq on 2018/12/28.
 */
public class Premain {

    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
        // 添加Transformer
        inst.addTransformer(new FirstAgent());
    }
}
