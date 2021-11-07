package com.ratnikov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SimpleTest extends BaseTest {
    @Test
    public void test1() {
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']\n"));

        searchInput.sendKeys("sberbank");
        searchInput.sendKeys(Keys.ENTER);

        WebElement targetText = driver.findElement(By.xpath("//h3[text()='Частным клиентам — СберБанк']"));
        Assert.assertTrue(targetText.isDisplayed());
    }

    @Test
    public void selenideExample() {
        Configuration.browser = "chrome";
        open("https://www.google.com/");

        $(By.name("q")).setValue("sberbank").pressEnter();
        $(By.xpath("//h3[text()='Частным клиентам — СберБанк']")).shouldBe(Condition.visible);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(800, 600));
//        driver.manage().window().maximize();
        driver.get("https://www.sberbank.ru/");
        Thread.sleep(5000);
    }

    @Test
    public void test3() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement element = driver.findElement(By.xpath("//Button[text()='Start']"));
        element.sendKeys(Keys.ENTER);
//        WebElement targetText = driver.findElement(By.xpath("//h4[text()='Hello World!']\n"));
//        Assert.assertTrue(targetText.isDisplayed());
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
    }

    @Test
    public void test4() {
        driver.get("https://www.sberbank.ru/ru/person");
        mainPage.checkOfTheMainPageLocation();
    }
    
    @Test
    public void test5() {
        driver.get("https://www.sberbank.ru/ru/person");
        mainPage.clickCreditsButton();
        mainPage.clickAllCreditsButton();
        mainPage.checkOfTheMainPageLocation();
    }
}
