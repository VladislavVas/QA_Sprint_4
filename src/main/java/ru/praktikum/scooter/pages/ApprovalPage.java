package ru.praktikum.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.scooter.Const;

import static org.junit.Assert.assertEquals;

public class ApprovalPage extends BasePage {

    // локатор кнопки "Да"
    private final By approveButton = By.xpath(".//button[text()='Да']");

    public ApprovalPage(WebDriver driver) {
        super(driver);
        assertEquals("This is not Scooter approval page.", Const.ORDER_PAGE_URL, driver.getCurrentUrl());
    }

    public PlacedOrderPage approveOrder() {
        driver.findElement(approveButton).click();
        return new PlacedOrderPage(driver);
    }
}
