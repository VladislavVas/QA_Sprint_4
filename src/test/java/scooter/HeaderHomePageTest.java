package scooter;

import org.junit.Test;
import ru.praktikum.scooter.Const;
import ru.praktikum.scooter.pages.HomePage;
import ru.praktikum.scooter.pages.OrderPage;

import static org.junit.Assert.assertEquals;

public class HeaderHomePageTest extends BaseTest {

    @Test
    public void clickOnTheLinkInTheYandexLogo() {
        HomePage homePage = new HomePage(driver);
        homePage.clickYandexLogo();
        String handle = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(handle);
        assertEquals(Const.YANDEX_URL, driver.getCurrentUrl());
    }

    @Test
    public void clickOnTheLinkInTheScooterLogo() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = homePage.rentScooterByHeaderButton();
        orderPage.clickScooterLogo();
        assertEquals("Wrong page!", Const.APP_URL, driver.getCurrentUrl());
    }
}
