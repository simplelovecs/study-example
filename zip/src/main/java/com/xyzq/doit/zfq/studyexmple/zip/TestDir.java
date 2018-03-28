package com.xyzq.doit.zfq.studyexmple.zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestDir {
    public static void main(String[] args) throws IOException {
        // the file path need to compress
        File file = new File("/home/liangruihua/ziptest/test");
        ZipOutputStream zos = new ZipOutputStream(
                new FileOutputStream(
                        "/home/liangruihua/ziptest/test.zip"));

        // judge the file is the directory
        if (file.isDirectory()) {
            // get the every file in the directory
            File[] files = file.listFiles();

            for (int i = 0; i < files.length; i++) {
                // new the BuuferedInputStream
                BufferedInputStream bis = new BufferedInputStream(
                        new FileInputStream(
                                files[i]));
                // the file entry ,set the file name in the zip
                // file
                zos.putNextEntry(new ZipEntry(file
                                                      .getName()
                                              + file.separator
                                              + files[i].getName()));
                while (true) {
                    byte[] b = new byte[100];
                    int len = bis.read(b);
                    if (len == -1) {
                        break;
                    }
                    zos.write(b, 0, len);
                }

                // close the input stream
                bis.close();
            }

        }
        // close the zip output stream
        zos.close();
    }
}
