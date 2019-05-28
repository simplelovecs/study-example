package com.xyzq.doit.zfq.studyexmple.zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zhengfq
 * @since 2018-04-22
 */
public final class ZipUtil {

    public static final void zip(final String dir, final OutputStream outFile) {
        File file = new File(dir);
        if (!file.exists()) {
            throw new RuntimeException("此文件不存在！");
        }

        try (ZipOutputStream zos = new ZipOutputStream(outFile)) {
            zipEntry("", file, zos);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static final void zip(final String dir, final String outFile) {
        File file = new File(dir);
        if (!file.exists()) {
            throw new RuntimeException("此文件不存在！");
        }
        try {
            zip(dir, new FileOutputStream(outFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void zipEntry(final String prefix, final File entry, final ZipOutputStream zos) {
        final String rprefix;
        if (prefix == null || "".equals(prefix)) {
            rprefix = "";
        } else {
            rprefix = prefix + File.separator;
        }
        if (entry.isDirectory()) {
            try {
                zos.putNextEntry(new ZipEntry(rprefix + entry.getName() + File.separator));
                zos.closeEntry();
                Arrays.stream(entry.listFiles()).forEach(file -> {
                    zipEntry(rprefix + entry.getName(), file, zos);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                zos.putNextEntry(new ZipEntry(prefix + File.separator + entry.getName()));
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(entry))) {
                    final byte[] content = new byte[200];
                    int size;
                    while ((size = bis.read(content)) != -1) {
                        zos.write(content, 0, size);
                    }
                } catch (IOException e) {
                }
                zos.closeEntry();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
