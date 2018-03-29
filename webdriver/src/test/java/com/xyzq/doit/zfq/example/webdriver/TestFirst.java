package com.xyzq.doit.zfq.example.webdriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;


public class TestFirst {
    @Test
    public void f() {

        //如果火狐浏览器没有默认安装在C盘，需要制定其路径
//        System.setProperty("webdriver.gecko.driver",
//                           "/Applications/Firefox.app/Contents/MacOS/firefox");

        //定义驱动对象为 FirefoxDriver 对象
        WebDriver driver = new SafariDriver();


        //驱动的网址
        driver.get("http://www.baidu.com/");


        //浏览器窗口变大
        driver.manage().window().maximize();

        //定位输入框元素
        WebElement txtbox = driver.findElement(By.name("wd"));

        //在输入框输入文本
        txtbox.sendKeys("HelloWorld");

        //定位按钮元素
        WebElement btn = driver.findElement(By.id("su"));

        //点击按钮
        btn.click();


        //关闭驱动
        driver.close();
        driver.quit();

    }
}