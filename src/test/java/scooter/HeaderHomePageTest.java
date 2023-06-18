package scooter;

import org.junit.Test;
import ru.praktikum.scooter.Const;
import ru.praktikum.scooter.pageObject.BasePage;
import ru.praktikum.scooter.pageObject.HomePage;
import ru.praktikum.scooter.pageObject.OrderPage;


import static org.junit.Assert.assertEquals;

public class HeaderHomePageTest extends BaseTest {

    @Test
    public void clickOnTheLinkInTheYandexLogo() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickYandexLogo();
        BasePage page = new BasePage(driver);
        page.waitSeconds(10);
        assertEquals("Wrong page!", "https://yandex.ru/", page.getUrl());
    }

    @Test
    public void clickOnTheLinkInTheScooterLogo() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = homePage.rentScooterByHeaderButton();
        homePage.waitSeconds(3);
        orderPage.clickScooterLogo();
        homePage.waitSeconds(3);
        assertEquals("Wrong page!", Const.APP_URL, driver.getCurrentUrl());
    }
}
