package com.xyzq.doit.zfq.example.tess4j;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AppTest {

    public static void main(String[] args) {

        File imageFile = new File("/Users/zhengfq/Documents/9D4EB079-5A2D-41B6-B3FB-BE276A0AD9BD.png");

        File imageFile2 = new File("/Users/zhengfq/git/study-example/tess4j/testdata/1522279330801.jpg");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping

        try {
            //读取一个文件夹下的所有图片并验证
                 /*    String[] filelist = imageFile.list();
                 for (int i = 0; i < filelist.length; i++) {
                         File readfile = new File("E:\\valimg" + "\\" + filelist[i]);
                         if (!readfile.isDirectory()) {
                                 System.out.println("path=" + readfile.getPath());
                                 System.out.println("absolutepath="
                                                 + readfile.getAbsolutePath());
                                 System.out.println("name=" + readfile.getName());

                                 String result = instance.doOCR(readfile);
                                 //String result = instance.doOCR(change(readfile));
                                 System.err.println(readfile.getName() +" result："+  result);
                      }
                 }*/
//            instance.setDatapath("data");

            instance.setLanguage("chi_sim"); //加载语言包
            String result = instance.doOCR(imageFile2);

            System.err.println(imageFile2.getName() + " result：" + result);

        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }

    public static BufferedImage change(File file) {

        // 读取图片字节数组
        BufferedImage textImage = null;
        try {
            InputStream in = new FileInputStream(file);
            BufferedImage image = ImageIO.read(in);
            textImage = ImageHelper.convertImageToGrayscale(
                    ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight()));  //对图片进行处理
            textImage = ImageHelper.getScaledInstance(image, image.getWidth() * 5, image.getHeight() * 5);  //将图片扩大5倍

        } catch (IOException e) {
            e.printStackTrace();
        }

        return textImage;
    }

}