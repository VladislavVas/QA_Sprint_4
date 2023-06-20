package ru.praktikum.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.praktikum.scooter.Const;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage {

    private static final List<String> questionsButtonsList = List.of(
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"
    );
    private static final List<String> textQuestionsList = List.of(
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"
    );
    // лого "Яндекс" в шапке
    private final By logoYandex = By.cssSelector("a.Header_LogoYandex__3TSOI");
    // кнопка "Заказать" в шапке
    private final By headerRentButton = By.xpath("(.//button[contains(text(), 'Заказать')])[1]");
    // кнопка "Заказать" в теле
    private final By bodyRentButton = By.xpath("(.//button[contains(text(), 'Заказать')])[2]");
    // кнопка "да все привыкли" (принятие куки) в
    private final By confirmCookieButton = By.className("App_CookieButton__3cvqF");

    public HomePage(WebDriver driver) {
        super(driver);
        assertEquals("This is not Scooter home page.", Const.APP_URL, driver.getCurrentUrl());
    }

    public void acceptCookie() {
        driver.findElement(confirmCookieButton).click();
    }

    public OrderPage rentScooterByHeaderButton() {
        driver.findElement(headerRentButton).click();
        return new OrderPage(driver);
    }


    public OrderPage rentScooterByBodyButton() {
        WebElement button = driver.findElement(bodyRentButton);
        scrollIntoView(button);
        button.click();
        return new OrderPage(driver);
    }

    public void clickQuestionButton(int buttonIndex) {
        String locator = questionsButtonsList.get(buttonIndex);
        WebElement element = driver.findElement(By.id(locator));
        scrollIntoView(element);
        waitToBeClickable(By.id(locator));
        driver.findElement(By.id(locator)).click();
    }

    public String getActualAnswerText(int locatorIndex) {
        String locator = textQuestionsList.get(locatorIndex);
        return driver.findElement(By.id(locator)).getText();
    }

    public void clickYandexLogo() {
        waitToBeClickable(logoYandex);
        driver.findElement(logoYandex).click();
    }

}
