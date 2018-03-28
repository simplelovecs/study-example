package com.xyzq.doit.zfq.fastdfs;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;

@ContextConfiguration(locations = { "classpath:application-context-fastdfs.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class FastDFSDemo extends AbstractJUnit4SpringContextTests {

    @Test
    public void uploadFile() throws Exception {
        File file = new File("/home/duhui/code/fastdfsdemo/src/test/resources/images/54af9bcdN78b67b5a.jpg");
        StorePath storePath = fastFileStorageClient.uploadFile(null, new FileInputStream(file), file.length(), "jpg");
    }

    @Autowired
    FastFileStorageClient fastFileStorageClient;
}