package ru.praktikum.scooter.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitSeconds(int seconds) {
        new WebDriverWait(driver, seconds);
    }

    public void waitToBeClickable(By locator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

}
