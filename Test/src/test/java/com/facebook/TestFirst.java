package com.facebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;




public class TestFirst {

    public ChromeDriver driver;

   @Before
    public void setup() {
       System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
       Map<String, Object> prefs = new HashMap<String, Object>();
       prefs.put("profile.default_content_setting_values.notifications", 2);
       ChromeOptions options = new ChromeOptions();
       options.setExperimentalOption("prefs", prefs);
       driver = new ChromeDriver(options);
       driver.get("https://www.facebook.com/login/");
    }


    @Test
    public void testFirst() {

        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        WebElement login = driver.findElement(By.id("loginbutton"));
        username.sendKeys("+380502405043");
        password.sendKeys("wrestling123");
        login.click();
        String actualy_url = "https://www.facebook.com/?sk=welcome";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualy_url);
        String СonectingUser = driver.findElement (By.linkText ("Dmitriy Glushko")).getText();
        System.out.println("User name "+СonectingUser);
    }
    @Test
    public void testSecond() {
        WebElement drop_down = driver.findElement(By.id("loginform"));
        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        WebElement login = driver.findElement(By.id("loginbutton"));
        username.sendKeys("+380502405043");
        password.sendKeys("wrestling123");
        login.click();
        String СonectingUser = driver.findElement (By.linkText ("Dmitriy Glushko")).getText();
        String HardName = "Ivanov Ilya";
        Assert.assertEquals(СonectingUser, HardName);
    }
            @After
            public void closeFacebook() {
                driver.close();


            }

        }







