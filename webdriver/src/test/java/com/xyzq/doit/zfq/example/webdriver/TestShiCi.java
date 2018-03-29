package com.xyzq.doit.zfq.example.webdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by zhengfq on 2018/3/28.
 */
public class TestShiCi {
    @Test
    public void f() {

        //如果火狐浏览器没有默认安装在C盘，需要制定其路径
//        System.setProperty("webdriver.gecko.driver",
//                           "/Applications/Firefox.app/Contents/MacOS/firefox");

        //定义驱动对象为 FirefoxDriver 对象
        WebDriver driver = new SafariDriver();


        //驱动的网址
        driver.get("https://so.gushiwen.org/search.aspx?value=两朝开济老臣心");

        //浏览器窗口变大
        driver.manage().window().maximize();

        //关闭驱动
        driver.close();
        driver.quit();

    }
}
