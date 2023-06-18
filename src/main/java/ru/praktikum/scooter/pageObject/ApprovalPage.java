package ru.praktikum.scooter.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.scooter.Const;

public class ApprovalPage extends BasePage {

    // локатор кнопки "Да"
    private final By approveButton = By.xpath(".//button[text()='Да']");

    public ApprovalPage(WebDriver driver) {
        super(driver);
        if (!driver.getCurrentUrl().equals(Const.ORDER_PAGE_URL)) {
            throw new IllegalArgumentException("This is not Scooter Success order page. " +
                    "Expected " + Const.ORDER_PAGE_URL +
                    " but got: " + driver.getCurrentUrl());
        }
    }

    public PlacedOrderPage approveOrder() {
        driver.findElement(approveButton).click();
        return new PlacedOrderPage(driver);
    }
}
