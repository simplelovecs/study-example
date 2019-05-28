package com.xyzq.doit.zfq.studyexmple.zip;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author zhengfq
 * @since 2018-04-22
 */
public final class GZUtil {
    public static final void gz(final String dir, final OutputStream outFile) {
        File file = new File(dir);
        if (!file.exists()) {
            throw new RuntimeException("此文件不存在！");
        }

        try (GZIPOutputStream zos = new GZIPOutputStream(outFile)) {
            TarUtil.tar(dir, zos);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


    public static final void gz(final String dir, final String outFile) {
        File file = new File(dir);
        if (!file.exists()) {
            throw new RuntimeException("此文件不存在！");
        }
        try {
            gz(dir, new FileOutputStream(outFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
