package com.ratnikov;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SimpleTest {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
//        WebElement searchInput = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']\n"));
        searchInput.sendKeys("sberbank");
//        searchInput.submit();
//        searchInput.sendKeys(Keys.RETURN);
        searchInput.sendKeys(Keys.ENTER);
        WebElement targetText = driver.findElement(By.xpath("//h3[text()='Частным клиентам — СберБанк']"));
//        WebElement targetClass = driver.findElement(By.className("g"));
        Assert.assertTrue(targetText.isDisplayed());
//        Assert.assertTrue(targetClass.isDisplayed());
        driver.quit();
    }
}
