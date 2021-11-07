package com.ratnikov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SberPage {
    public WebDriver driver;

    public SberPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//img[@alt='Официальный сайт Сбербанка России']")
    private WebElement elMainIcon;

    @FindBy(xpath = "//a[@aria-label='Сервисы']")
    private WebElement elServicesButton;

    @FindBy(xpath = "//a[text()='Все онлайн-сервисы']")
    private WebElement elAllServicesButton;

    @FindBy(xpath = "//a[@aria-label='Платежи']")
    private WebElement elPayButton;

    @FindBy(xpath = "//a[text()='Оплата услуг']")
    private WebElement elPayServiceButton;

    @FindBy(xpath = "//a[@aria-label='Ипотека']")
    private WebElement elMortgageButton;

    @FindBy(xpath = "//a[text()='Все ипотечные кредиты']")
    private WebElement elAllMortgageButton;

    public void checkOfTheMainPageLocation() {
        Assert.assertTrue(elMainIcon.isDisplayed());
    }

    public void clickServicesButton() {
        elServicesButton.click();
    }

    public void clickAllServicesButton() {
        elAllServicesButton.click();
    }

    public void clickPayButton() {
        elPayButton.click();
    }

    public void clickPayServiceButton() {
        elPayServiceButton.click();
    }

    public void clickMortgageButton() {
        elMortgageButton.click();
    }

    public void clickAllMortgageButton() {
        elAllMortgageButton.click();
    }
}
