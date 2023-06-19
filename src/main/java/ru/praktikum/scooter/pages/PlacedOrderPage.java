package ru.praktikum.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.scooter.Const;

import static junit.framework.TestCase.assertEquals;

public class PlacedOrderPage extends BasePage {

    // Локатор сообщения успешного заказа
    private final By orderMessage = By.xpath(".//div[text()='Заказ оформлен']");

    public PlacedOrderPage(WebDriver driver) {
        super(driver);
        assertEquals("This is not Scooter placed order page.", Const.ORDER_PAGE_URL, driver.getCurrentUrl());
    }

    public boolean getOrderStatusMessage() {
        return isDisplayed(orderMessage);
    }
}
