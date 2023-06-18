package scooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.Const;

public class BaseTest {

    protected WebDriver driver;
    protected String url;

    @Before
    public void setUp() {

        this.driver = new ChromeDriver();
        this.url = Const.APP_URL;
        driver.get(url);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
