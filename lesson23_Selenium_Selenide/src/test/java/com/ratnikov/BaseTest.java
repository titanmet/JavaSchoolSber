package com.ratnikov;

import com.ratnikov.pages.AllCreditsPage;
import com.ratnikov.pages.MainPage;
import com.ratnikov.pages.SberPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public MainPage mainPage;
    public AllCreditsPage allCreditsPage;
    public SberPage sberPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //  options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        allCreditsPage = new AllCreditsPage(driver);
        sberPage = new SberPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
