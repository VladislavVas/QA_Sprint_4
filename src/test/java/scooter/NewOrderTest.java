package scooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.scooter.pages.*;

@RunWith(Parameterized.class)
public class NewOrderTest extends BaseTest {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String comment;
    private final String colour;
    private final String deliveryDate;
    private final String rentalPeriod;


    public NewOrderTest(String firstName, String lastName, String address, String metroStation,
                        String number, String comment, String colour, String deliveryDate, String rentalPeriod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = number;
        this.comment = comment;
        this.colour = colour;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
    }


    @Parameterized.Parameters
    public static Object[][] expectedParams() {
        return new Object[][]{
                {"Иван", "Иванов", "Красная площадь, д. 1", "Охотный ряд", "84957777777", "коментарий", "black", "21.09.2023", "1"},
                {"Петр", "Петров", "Трубная, д. 1", "Трубная", "84959999999", "коментарий", "grey", "11.11.2023", "4"},
        };
    }


    @Test
    public void rentScooterOrderPageByHeaderButton() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        OrderPage orderPage = homePage.rentScooterByHeaderButton();
        orderPage.setFirstName(firstName);
        orderPage.setLastName(lastName);
        orderPage.setAddress(address);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.setMetroStation(metroStation);
        RentPage rentPage = orderPage.clickNextButton();
        rentPage.setCommentField(comment);
        Assert.assertEquals("Couldn't go to the rental page", "Про аренду", rentPage.getRentPageHeader());
    }

    @Test
    public void rentScooterOrderPageByBodyButton() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        OrderPage orderPage = homePage.rentScooterByBodyButton();
        orderPage.setFirstName(firstName);
        orderPage.setLastName(lastName);
        orderPage.setAddress(address);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.setMetroStation(metroStation);
        RentPage rentPage = orderPage.clickNextButton();
        Assert.assertEquals("Couldn't go to the rental page", "Про аренду", rentPage.getRentPageHeader());
    }

    @Test
    public void rentScooterRentPageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        OrderPage orderPage = homePage.rentScooterByBodyButton();
        orderPage.setAllFields("Имя", "Фамилия", "Адрес", "84957777777", "Выхино");
        RentPage rentPage = orderPage.clickNextButton();
        rentPage.setColour(colour);
        rentPage.setDeliveryDate(deliveryDate);
        rentPage.setCommentField(comment);
        rentPage.setRentalPeriod(rentalPeriod);
        rentPage.clickConfirmButton();
        ApprovalPage approvalPage = new ApprovalPage(driver);
        PlacedOrderPage placedOrderPage = approvalPage.approveOrder();
        Assert.assertTrue("Order processing error", placedOrderPage.getOrderStatusMessage());
    }

}