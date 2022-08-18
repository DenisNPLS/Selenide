package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @Test
    void Test1() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        $x("//input[@placeholder='Город']").val("Рязань").pressEscape();
        $x("//input[@placeholder='Дата встречи']").doubleClick().pressEscape().sendKeys("13.12.2023");
        $x("//input[@name='name']").val("Семин Денис");
        $x("//input[@name='phone']").val("+79109009593");
        $x("//label").click();
        $x("//*[contains(text(),'Забронировать')]").click();
        $x("//div[@class='notification__content']").shouldBe(visible, Duration.ofSeconds(20));
    }

}
