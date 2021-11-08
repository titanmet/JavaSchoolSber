package com.ratnikov;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class SelenoidTests {

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "95.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
    }

    @Test
    public void testSelenide1() {
        open("https://www.google.com/");
        Selenide.sleep(5000);
        $(By.name("q")).setValue("sberbank").pressEnter();
        Selenide.sleep(5000);
    }

    @Test
    public void testSelenide2() {
        open("https://www.google.com/");
        Selenide.sleep(5000);
    }

    @Test
    public void testSelenide3() {
        open("https://www.google.com/");
        Selenide.sleep(5000);
    }

    @Test
    public void testSelenide4() {
        open("https://www.google.com/");
        Selenide.sleep(5000);
    }

    @Test
    public void testSelenide5() {
        open("https://www.google.com/");
        Selenide.sleep(5000);
    }

    @Test
    public void testSelenide6() {
        open("https://www.google.com/");
        Selenide.sleep(5000);
    }

    @Test
    public void testSelenide7() {
        open("https://www.google.com/");
        Selenide.sleep(5000);
    }
}

