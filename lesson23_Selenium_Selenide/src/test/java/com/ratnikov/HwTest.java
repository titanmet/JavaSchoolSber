package com.ratnikov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HwTest extends BaseTest {
    @Test
    public void test1() {
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']\n"));

        searchInput.sendKeys("Java");
        searchInput.sendKeys(Keys.ENTER);

        WebElement targetText = driver.findElement(By.xpath("//h3[text()='Java | Oracle']"));
        Assert.assertTrue(targetText.isDisplayed());
    }

    @Test
    public void selenideExample() {
        Configuration.browser = "chrome";
        open("https://www.google.com/");

        $(By.name("q")).setValue("Java").pressEnter();
        $(By.xpath("//h3[text()='Java | Oracle']")).shouldBe(Condition.visible);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.get("https://www.java.com/ru/");
        Thread.sleep(2000);
    }

    @Test
    public void test3() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement element = driver.findElement(By.xpath("//Button[text()='Add Element']"));
        element.sendKeys(Keys.ENTER);
        new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Button[text()='Delete']")));
    }

    @Test
    public void test4() {
        driver.get("https://www.sberbank.ru/ru/person");
        sberPage.checkOfTheMainPageLocation();
    }

    @Test
    public void test5() {
        driver.get("https://www.sberbank.ru/ru/person");
        sberPage.clickServicesButton();
        sberPage.clickAllServicesButton();
        sberPage.clickPayButton();
        sberPage.clickPayServiceButton();
        sberPage.clickMortgageButton();
        sberPage.clickAllMortgageButton();
    }
}
