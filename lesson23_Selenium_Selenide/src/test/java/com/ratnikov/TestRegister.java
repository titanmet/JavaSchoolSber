package com.ratnikov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;

public class TestRegister {
    @Test
    public void testRegisterSelenide() {
        open("http://localhost:8080/");
        $(By.xpath("//button[text()='Перейти на страницу регистрации']")).click();
        $(By.xpath("//h2[text()='Регистрация нового пользователя']"));
        $(By.name("name")).setValue("andrey");
        $(By.name("lastName")).setValue("ra");
        $(By.name("email")).setValue("titanmet@mail.ru");
        $(By.name("userName")).setValue("andrey3");
        $(By.name("password")).setValue("100100");
        $(By.xpath("//button[text()='Зарегистрировать']")).click();
        Selenide.sleep(5000);
        $(By.xpath("//h4[text()='Пользователь успешно зарегистрирован']")).shouldBe(Condition.visible);
    }
}
