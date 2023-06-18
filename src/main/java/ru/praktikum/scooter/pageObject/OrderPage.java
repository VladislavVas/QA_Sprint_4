package ru.praktikum.scooter.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.scooter.Const;

public class OrderPage extends BasePage {

    // лого "Самокат" в шапке
    private final By logoScooter = By.xpath("//*[@alt = 'Scooter']");
    // Поле ввода имени
    private final By firstNameField = By.cssSelector("input[placeholder='* Имя']");
    // Поле ввода фамилии
    private final By lastNameField = By.cssSelector("input[placeholder='* Фамилия']");
    // Поле ввода адреса доставки
    private final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле ввода станции метро для доставки
    private final By metroStationField = By.cssSelector("input[placeholder='* Станция метро']");
    // Локатор первой станции метро в выпадающем списке
    private final By stationSelect = By.xpath("(.//button[contains(@class, 'select-search__option')])[1]");
    // Поле ввода телефона заказчика
    private final By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");


    public OrderPage(WebDriver driver) {
        super(driver);
        if (!driver.getCurrentUrl().equals(Const.ORDER_PAGE_URL)) {
            throw new IllegalArgumentException("This is not Scooter order page. " +
                    "Expected  " + Const.ORDER_PAGE_URL +
                    " but got: " + driver.getCurrentUrl());
        }
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetroStation(String station) {
        driver.findElement(metroStationField).sendKeys(station);
        waitSeconds(10);
        driver.findElement(stationSelect).click();
    }

    public void setPhoneNumber(String number) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(number);
    }

    public RentPage clickNextButton() {
        driver.findElement(nextButton).click();
        return new RentPage(driver);
    }

    public void setAllFields(String firstName, String lastName, String address, String phoneNumber, String metroStation) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setMetroStation(metroStation);
    }

    public void clickScooterLogo() {
        driver.findElement(logoScooter).click();
    }

}
