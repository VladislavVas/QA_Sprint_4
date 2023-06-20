package ru.praktikum.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ru.praktikum.scooter.Const;

import static org.junit.Assert.assertEquals;

public class RentPage extends BasePage {

    // Локатор хедера "Про аренду"
    private final By rentPageHeader = By.cssSelector("div.Order_Header__BZXOb");
    // Поле "Комментарий для курьера"
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Поле ввода даты доставки
    private final By deliveryDate = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // Кнопка "Заказать"
    private final By confirmButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Выпадающий список со сроком аренды
    private final By rentalPeriodDropdown = By.cssSelector("div.Dropdown-root");

    public RentPage(WebDriver driver) {
        super(driver);
        assertEquals("This is not Scooter rent page.", Const.ORDER_PAGE_URL, driver.getCurrentUrl());
    }

    public String getRentPageHeader() {
        return driver.findElement(rentPageHeader).getText();
    }

    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void setColour(String colour) {
        driver.findElement(By.id(colour)).click();
    }

    public void setDeliveryDate(String date) {
        driver.findElement(deliveryDate).clear();
        driver.findElement(deliveryDate).sendKeys(date);
        driver.findElement(deliveryDate).sendKeys(Keys.ENTER);
    }

    public void setRentalPeriod(String period) {
        driver.findElement(rentalPeriodDropdown).click();
        String periodLocator = String.format(".//div[@class = 'Dropdown-option'] [%s]", period);
        driver.findElement(By.xpath(periodLocator)).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

}
