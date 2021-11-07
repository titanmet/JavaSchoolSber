package com.ratnikov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideExample extends BaseTest {
    @Test
    public void selenideExample() {
        Configuration.browser = "chrome";
        open("https://www.google.com/");

        $(By.name("q")).setValue("sberbank").pressEnter();
        $(By.xpath("//h3[text()='Частным клиентам — СберБанк']")).shouldBe(Condition.visible);
    }
}
