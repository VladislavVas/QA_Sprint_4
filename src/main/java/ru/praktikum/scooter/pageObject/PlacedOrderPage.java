package ru.praktikum.scooter.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.scooter.Const;

public class PlacedOrderPage extends BasePage{

    // Локатор сообщения успешного заказа
    private final By orderMessage = By.xpath(".//div[text()='Заказ оформлен']");

    public PlacedOrderPage(WebDriver driver) {
        super(driver);
        if (!driver.getCurrentUrl().equals(Const.ORDER_PAGE_URL)) {
            throw new IllegalArgumentException("This is not Scooter placed order page. " +
                    "Expected " + Const.ORDER_PAGE_URL +
                    " but got: " + driver.getCurrentUrl());
        }
    }

    public boolean getOrderStatusMessage() {
        return isDisplayed(orderMessage);
    }
}
