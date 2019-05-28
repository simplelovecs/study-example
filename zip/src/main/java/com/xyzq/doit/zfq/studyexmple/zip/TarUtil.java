package com.xyzq.doit.zfq.studyexmple.zip;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author zhengfq
 * @since 2018-04-22
 */
public final class TarUtil {
    public static final void tar(final String dir, final OutputStream outFile) {
        File file = new File(dir);
        if (!file.exists()) {
            throw new RuntimeException("此文件不存在！");
        }

        try (TarArchiveOutputStream zos = new TarArchiveOutputStream(outFile, "utf-8")) {
            zos.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
            tarEntry("", file, zos);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static final void tar(final String dir, final String outFile) {
        File file = new File(dir);
        if (!file.exists()) {
            throw new RuntimeException("此文件不存在！");
        }
        try {
            tar(dir, new FileOutputStream(outFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void tarEntry(final String prefix, final File entry, final TarArchiveOutputStream zos) {
        final String rprefix;
        if (prefix == null || "".equals(prefix)) {
            rprefix = "";
        } else {
            rprefix = prefix + File.separator;
        }
        if (entry.isDirectory()) {
            try {
                TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(rprefix + entry.getName() + File.separator);
                tarArchiveEntry.setSize(entry.length());
                zos.putArchiveEntry(tarArchiveEntry);
                zos.closeArchiveEntry();
                Arrays.stream(entry.listFiles()).forEach(file -> {
                    tarEntry(rprefix + entry.getName(), file, zos);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(prefix + File.separator + entry.getName());
                tarArchiveEntry.setSize(entry.length());
                zos.putArchiveEntry(tarArchiveEntry);

                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(entry))) {
                    final byte[] buf = new byte[200];
                    int len;
                    while ((len = bis.read(buf)) != -1) {
                        zos.write(buf, 0, len);
                    }
                } catch (IOException e) {
                }
                zos.closeArchiveEntry();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
